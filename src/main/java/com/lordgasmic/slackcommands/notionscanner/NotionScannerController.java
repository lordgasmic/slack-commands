package com.lordgasmic.slackcommands.notionscanner;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotionScannerController {

    private NotionScannerService service;

    public NotionScannerController(NotionScannerService service) {
        this.service = service;
    }

    @PostMapping(value="/api/v1/slack-commands/notion-scanner",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Object notionScanner(SlackRequest request) {
        return service.notionScanner(request);
    }
}
