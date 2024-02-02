package com.lordgasmic.slackcommands.notionscanner.models;

import lombok.Data;

import java.util.List;

@Data
public class NotionPageTitle {
    private String id;
    private String type;
    private List<NotionPageTitleObject> title;
}
