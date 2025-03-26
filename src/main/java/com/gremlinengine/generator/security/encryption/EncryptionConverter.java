package com.gremlinengine.generator.security.encryption;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Converter
public class EncryptionConverter implements AttributeConverter<String, String> {

    private static EncryptionUtil encryptionUtil;

    @Autowired
    public EncryptionConverter(EncryptionUtil encryptionUtil) { }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return (attribute == null) ? null : encryptionUtil.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : encryptionUtil.decrypt(dbData);
    }
}
