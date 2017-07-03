package com.akquinet.service;

import com.akquinet.model.Images.Image;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CLE on 02.07.17.
 */

@Service

public class ImageService {

    @Value("${getty.images.key}")
    private String gettyKey;

    @Value("${getty.images.url_base}")
    private String gettyUrlSearch;


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<Image> searchImages(String keyword) {


        RestTemplate restTemplate = new RestTemplate();
        URI searchUrl = getUri(gettyUrlSearch, keyword);

        HttpEntity entity = getHttpEntity();


        log.info("Start retrieving metadata for " + searchUrl);
        ResponseEntity<String> responseEntity = restTemplate.exchange(searchUrl, HttpMethod.GET, entity, String.class);
        List<Image> allImages = deserializeJson(responseEntity);
        return allImages;

    }

    private List<Image> deserializeJson(ResponseEntity<String> responseEntity) {

        List<Image> allImages = new ArrayList<Image>();
        String objects = responseEntity.getBody();

        JSONObject json = new JSONObject(objects);

        // get the images part of JSON object
        JSONArray imagesJson = (JSONArray) json.get("images");


        ObjectMapper mapper = new ObjectMapper();
        try {
            allImages = mapper.readValue(imagesJson.toString(), new TypeReference<List<Image>>() {
            });
            log.info("Metadate return from Getty API : " + allImages.size());
        } catch (IOException e) {
            log.error("Could not deserialize the Json Object !");
            e.printStackTrace();
        }


        return allImages;
    }


    private HttpEntity getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", gettyKey);
        return new HttpEntity(headers);
    }

    private URI getUri(String url, String keyword) {
        String uriString = url;
        List<String> fieldsname = new ArrayList<String>();
        fieldsname.add("artist");
        fieldsname.add("caption");
        fieldsname.add("date_camera_shot");
        fieldsname.add("display_set");
        fieldsname.add("max_dimensions");
        fieldsname.add("title");
        String allFields = String.join(",", fieldsname);


        return UriComponentsBuilder.fromUriString(uriString).queryParam("fields", allFields).queryParam("phrase", keyword).build().encode().toUri();

    }


}
