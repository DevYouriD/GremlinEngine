package com.gremlinengine.generator.rest.controller;

import com.gremlinengine.generator.rest.service.PdfService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class CVDownloadController {

    private final PdfService pdfService;

    public CVDownloadController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/resume/download")
    public ResponseEntity<byte[]> downloadResumePdf() throws IOException {
        Context context = new Context();
        context.setVariable("name", "Chad Gibbons");
        context.setVariable("title", "Graphic Designer");

        context.setVariable("contact", Map.of(
                "phone", "123-456-7890",
                "email", "hello@reallygreatsite.com",
                "address", "123 Anywhere St., Any City",
                "website", "reallygreatsite.com"
        ));

        context.setVariable("skills", List.of("Web Design", "Creative Thinking", "Adobe Photoshop", "Adobe Illustrator"));
        context.setVariable("languages", List.of("English", "French", "Hindi", "Bengali"));

        context.setVariable("profile", "Lorem ipsum dolor sit amet...");

        context.setVariable("education", List.of(
                Map.of("degree", "Masters in Art and Illustration", "institution", "Really Great University", "years", "2012 - 2014", "points", List.of("Post graduated in graphic designing", "In-house extensive training")),
                Map.of("degree", "BA in Art and Illustration", "institution", "Really Great University", "years", "2009 - 2012", "points", List.of("Academic excellence in visual identity and motion graphic designing"))
        ));

        context.setVariable("experience", List.of(
                Map.of("company", "Salford & Co.", "position", "Creative Director", "dates", "Mar 2018 - Present", "responsibilities", List.of("Works closely with the marketing team regarding advertisements and promotions")),
                Map.of("company", "Borcelle", "position", "Project Manager", "dates", "Dec 2015 - Jan 2018", "responsibilities", List.of("Handled multiple digital accounts and worked with reputed organizations to provide unique graphic designs"))
        ));

        byte[] pdf = pdfService.generatePdf("cv-template", context);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("resume.pdf").build());

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
