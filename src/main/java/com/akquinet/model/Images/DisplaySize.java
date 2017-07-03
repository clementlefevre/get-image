package com.akquinet.model.Images;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by CLE on 02.07.17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplaySize {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private URI uri;

    public DisplaySize() {
    }


    public URI getUri() {
        return uri;
    }

    public void setUri(String uri) {
        try {
            this.uri = new URI(uri);
        } catch (URISyntaxException e) {
            log.error("Could not cast the image url to URI format : ",uri );
        }
    }
}
