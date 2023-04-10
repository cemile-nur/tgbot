package com.cemile.tgbot;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class Http {
    private HttpClient httpClient = HttpClient.create();
    private Map<String, String> sourceUri = new HashMap<String, String>() {{
        put("nesibeaydin", "http://nesibeaydin.yerlem.com:7073/");
        put("tedem", "http://tedem.yerlem.com:7077/");
        put("sinav", "http://sinavkoleji.yerlem.com:7076/");
        put("ideal", "http://idealkoleji.yerlem.com:7074/");
        put("med", "http://medokullari.yerlem.com:7075/");
    }};

    public DataFrame fetchBetweenDates(SparkSession session, String sourceId, String beginDate, String endDate) {
        String source = sourceUri.get(sourceId);
        if (source != null) {
            String uri = sourceUri.get(sourceId) +
                    "api/transportation/search/findAllByBetweenBeginDates?" +
                    "beginDate=" + beginDate + "&" + "endDate=" + endDate;

            ObjectMapper objectMapper = ObjectMapperFactory.create();
            String response = Https.get(httpClient, uri).block();
            JsonNode node = objectMapper.readTree(response);
            JsonNode embedded = node.get("_embedded");
            JsonNode transportationNode = embedded.get("transportation");
            String json = transportationNode.toString();

            Dataset<Row> df = session.read().json(Collections.singletonList(json));
            return df;
        } else {
            throw new IllegalArgumentException("sourceId, DataSource içerisinde tanımlı değil.");
        }
    }

    public DataFrame fetchToday(SparkSession session, String sourceId, int index) {
        String source = sourceUri.get(sourceId);
        if (source != null) {
            String uri = sourceUri.get(sourceId) + "/search/findAllBy1Day";

            String response = Https.get(httpClient, uri).block();
            JsonNode node = ObjectMapperFactory.create().readTree(response);
            JsonNode embedded = node.get("_embedded");
            JsonNode transportationNode = embedded.get("transportation");
            String json = transportationNode.toString();

            Dataset<Row> df = session.read().json(Collections.singletonList(json));
            return df.filter(functions.col("index").equalTo(index));
        } else {
            throw new IllegalArgumentException("sourceId, DataSource içerisinde tanımlı değil.");
        }
    }
}
