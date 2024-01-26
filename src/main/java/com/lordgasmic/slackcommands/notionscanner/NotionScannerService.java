package com.lordgasmic.slackcommands.notionscanner;

import org.springframework.stereotype.Service;

@Service
public class NotionScannerService {

    public Object notionScanner(SlackRequest request) {
        SlackResponse data = new SlackResponse();
        data.setName(request.getText());
        return data;
    }
}
