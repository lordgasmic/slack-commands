package com.lordgasmic.slackcommands.notionscanner.models;

import lombok.Data;

@Data
public class NotionPageResponse {
    private String object;
    private String id;
    private String created_time;
    private String last_edited_time;
    private Object created_by;
    private Object last_edited_by;
    private String cover;
    private String icon;
    private Object parent;
    private boolean archived;
    private NotionPageProperties properties;
    private String url;
    private String public_url;
}
