package com.lordgasmic.slackcommands.notionscanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lordgasmic.slackcommands.notionscanner.models.NotionPageProperties;
import com.lordgasmic.slackcommands.notionscanner.models.NotionPageResponse;
import com.lordgasmic.slackcommands.notionscanner.models.NotionPageTitle;
import com.lordgasmic.slackcommands.notionscanner.models.NotionPageTitleObject;
import com.lordgasmic.slackcommands.notionscanner.models.NotionSearchRequest;
import com.lordgasmic.slackcommands.notionscanner.models.NotionSearchResponse;
import com.lordgasmic.slackcommands.notionscanner.models.SlackRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NotionScannerService {

    private static final String NOTION_SEARCH_API = "https://api.notion.com/v1/search";

    @Value("${notion.integration}")
    private String notionIntegration;

    private HttpClient client;

    public NotionScannerService( ) {
        this.client = HttpClient.newBuilder().build();
    }

    public Object notionScanner(SlackRequest slackRequest) throws IOException, InterruptedException {
        NotionSearchRequest searchRequest = new NotionSearchRequest();
        searchRequest.setQuery(slackRequest.getText());

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(searchRequest);

        log.info("notion token: " + notionIntegration);

        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(NOTION_SEARCH_API))
                                         .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                                         .header("Authorization", "Bearer: " + notionIntegration)
                                         .header("Notion-Version", "2022-06-28")
                                         .header("Content-Type", "application/json")
                                         .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        NotionSearchResponse searchResponse = new ObjectMapper().readValue(response.body(), NotionSearchResponse.class);
        List<String> pageTitles = searchResponse.getResults().stream()
                                                             .map(NotionPageResponse::getProperties)
                                                             .map(NotionPageProperties::getTitle)
                                                             .map(t -> t.getTitle().stream().findFirst().map(NotionPageTitleObject::getPlain_text).orElseThrow())
                                                             .collect(Collectors.toList());

        return pageTitles;
    }
}
