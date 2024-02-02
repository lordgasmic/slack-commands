package com.lordgasmic.slackcommands.notionscanner.models;

import lombok.Data;

@Data
public class NotionSearchRequest {
    private String query;
    private FilterOptions filter = new FilterOptions();
    private SortOptions sort = new SortOptions();
}


/**
 * {
 *     "query":"onion",
 *     "filter": {
 *         "value": "page",
 *         "property": "object"
 *     },
 *     "sort":{
 *       "direction":"ascending",
 *       "timestamp":"last_edited_time"
 *     }
 *   }
 */
