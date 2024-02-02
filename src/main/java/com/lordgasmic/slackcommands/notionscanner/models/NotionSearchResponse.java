package com.lordgasmic.slackcommands.notionscanner.models;

import lombok.Data;

import java.util.List;

@Data
public class NotionSearchResponse {
    private String object;
    private List<NotionPageResponse> results;
    private String next_cursor;
    private boolean has_more;
    private String type;
    private Object page_or_database;
    private String developer_survey;
    private String request_id;
}
