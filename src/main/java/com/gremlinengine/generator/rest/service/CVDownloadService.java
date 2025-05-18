package com.gremlinengine.generator.rest.service;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class CVDownloadService {
    private final TemplateEngine templateEngine;

    public CVDownloadService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(String templateName, Context context) throws IOException {
        String htmlContent = templateEngine.process(templateName, context);

        Document doc = Jsoup.parse(htmlContent, "UTF-8");
        doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        String xhtml = doc.html();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(xhtml);
            renderer.layout();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        } catch (com.lowagie.text.DocumentException e) {
            throw new IOException("PDF generation failed", e);
        }
    }

}
