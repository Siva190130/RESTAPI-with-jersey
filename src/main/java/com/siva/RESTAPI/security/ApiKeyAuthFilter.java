//package com.siva.RESTAPI.security;
//
///**
// * ------------------------------------------------------------
// * ApiKeyAuthFilter
// * ------------------------------------------------------------
// *
// * JAX-RS request filter responsible for API Key authentication.
// *
// * Author      : Shiv (Associate Software Engineer)
// * Project     : RESTAPI (Jersey / JAX-RS)
// *
// * Responsibilities:
// * - Intercept every incoming HTTP request
// * - Extract API key from request headers
// * - Validate API key against configured value
// * - Block unauthorized requests BEFORE they reach resources
// *
// * Security Model:
// * - Stateless
// * - Header-based API key authentication
// * - Applied to ALL endpoints
// *
// * Header Expected:
// *   X-API-KEY: <api-key>
// *
// * ------------------------------------------------------------
// */
//
//import javax.annotation.Priority;
//import javax.ws.rs.Priorities;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.Provider;
//
//import java.io.InputStream;
//import java.util.Properties;
//
//@Provider
//@Priority(Priorities.AUTHENTICATION) // Ensure this runs early
//public class ApiKeyAuthFilter implements ContainerRequestFilter {
//
//    /**
//     * Name of the HTTP header that carries the API key.
//     */
//    private static final String API_KEY_HEADER = "X-API-KEY";
//
//    /**
//     * Expected API key loaded from configuration.
//     * Loaded once when the filter is initialized.
//     */
//    private static final String EXPECTED_API_KEY;
//
//    // Static initialization block runs once at class load time
//    static {
//        try {
//            Properties properties = new Properties();
//
//            // Load application.properties from classpath
//            InputStream inputStream =
//                    ApiKeyAuthFilter.class
//                            .getClassLoader()
//                            .getResourceAsStream("application.properties");
//
//            if (inputStream == null) {
//                throw new RuntimeException(
//                        "application.properties not found in classpath");
//            }
//
//            properties.load(inputStream);
//
//            EXPECTED_API_KEY = properties.getProperty("api.key");
//
//            if (EXPECTED_API_KEY == null || EXPECTED_API_KEY.trim().isEmpty()) {
//                throw new RuntimeException(
//                        "api.key not configured in application.properties");
//            }
//
//        } catch (Exception e) {
//            // Fail fast: application should not start without security config
//            throw new RuntimeException(
//                    "Failed to load API key configuration", e);
//        }
//    }
//
//    /**
//     * This method is invoked for EVERY incoming HTTP request.
//     */
//    @Override
//    public void filter(ContainerRequestContext requestContext) {
//
//        // 1️⃣ Extract API key from request headers
//        String apiKey =
//                requestContext.getHeaderString(API_KEY_HEADER);
//
//        // 2️⃣ Validate API key
//        if (apiKey == null || !apiKey.equals(EXPECTED_API_KEY)) {
//
//            // 3️⃣ Build unauthorized response
//            Response unauthorizedResponse =
//                    Response.status(Response.Status.UNAUTHORIZED)
//                            .type(MediaType.APPLICATION_JSON)
//                            .entity(
//                                "{ \"status\": 401, " +
//                                "\"message\": \"Invalid or missing API key\" }"
//                            )
//                            .build();
//
//            // 4️⃣ Abort request processing
//            requestContext.abortWith(unauthorizedResponse);
//        }
//
//        // If valid → request continues to Resource
//    }
//}
