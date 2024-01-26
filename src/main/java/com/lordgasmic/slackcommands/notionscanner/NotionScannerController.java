package com.lordgasmic.slackcommands.notionscanner;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotionScannerController {

    private NotionScannerService service;

    public NotionScannerController(NotionScannerService service) {
        this.service = service;
    }

    @PostMapping("/api/v1/slack-commands/notion-scanner")
    public Object notionScanner() {
        return service.notionScanner();
    }
}
