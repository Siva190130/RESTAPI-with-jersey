package com.siva.RESTAPI.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

public class MyApplication extends ResourceConfig {

    public MyApplication() {

        // Scan everything
        packages("com.siva.RESTAPI");

        // Enable JSON serialization
        register(JacksonFeature.class);
    }
}
