package com.gremlinengine.generator.security.encryption;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class EncryptionUtil {

    // Store both in env variables of the system
    /**
    private static final String ALGORITHM = System.getenv("ENCRYPTION_ALGORITHM");
    private static final String SECRET_KEY = System.getenv("ENCRYPTION_SECRET_KEY");
    */

    //For now we store them in properties
    @Value("${encryption.algorithm}")
    private String algorithm;

    @Value("${encryption.secret-key}")
    private String secretKey;

    private SecretKey key;

    public String encrypt(String value) {
        try{

            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    public String decrypt(String value) {
        try {
            value = value.replaceAll("\\s", "");
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting data", e);
        }
    }

    @PostConstruct
    public void init() {
        key = new SecretKeySpec(secretKey.getBytes(), algorithm);
    }
}
