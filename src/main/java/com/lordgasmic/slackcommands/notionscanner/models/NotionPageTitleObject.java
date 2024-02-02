package com.lordgasmic.slackcommands.notionscanner.models;

import lombok.Data;

@Data
public class NotionPageTitleObject {
    private String type;
    private Object text;
    private Object annotations;
    private String plain_text;
    private String href;
}
