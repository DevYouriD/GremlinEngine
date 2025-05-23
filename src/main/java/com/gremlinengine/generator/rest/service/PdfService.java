package com.gremlinengine.generator.rest.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    private final TemplateEngine templateEngine;

    public PdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(String templateName, Context context) throws IOException {
        String htmlContent = templateEngine.process(templateName, context);

        // Clean and prepare HTML using Jsoup
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
