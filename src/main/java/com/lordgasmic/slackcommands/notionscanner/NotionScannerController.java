package com.lordgasmic.slackcommands.notionscanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotionScannerController {

    @GetMapping("/api/v1/slack/notion-scanner")
    public Object notionScanner() {
        return null;
    }
}