package com.lordgasmic.slackcommands.notionscanner;

import org.springframework.stereotype.Service;

@Service
public class NotionScannerService {

    public Object notionScanner() {
        SlackResponse data = new SlackResponse();
        data.setName("potato");
        return data;
    }
}
