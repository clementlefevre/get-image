package com.akquinet.controller;

import com.akquinet.model.Images.Image;
import com.akquinet.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ImageService imageService;


    @Value("${getty.images.key}")
    private String gettyKey;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Image> findImages(@RequestBody Map<String, String> jsonObject) {
        List<Image> images = imageService.searchImages(jsonObject.get("keywords"));
        return images;
    }


}
