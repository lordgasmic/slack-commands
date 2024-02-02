package com.lordgasmic.slackcommands.notionscanner;

import com.lordgasmic.slackcommands.notionscanner.models.SlackRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class NotionScannerController {

    private NotionScannerService service;

    public NotionScannerController(NotionScannerService service) {
        this.service = service;
    }

    @PostMapping(value="/api/v1/slack-commands/notion-scanner",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Object notionScanner(SlackRequest request) throws IOException, InterruptedException {
        return service.notionScanner(request);
    }
}
