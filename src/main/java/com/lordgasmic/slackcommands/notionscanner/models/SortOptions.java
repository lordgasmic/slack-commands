package com.lordgasmic.slackcommands.notionscanner.models;

import lombok.Data;

@Data
public class SortOptions {
    private String direction = "ascending";
    private String timestamp="last_edited_time";
}
