package com.siva.RESTAPI.security;

/**
 * ------------------------------------------------------------
 * RoleAuthorizationFilter
 * ------------------------------------------------------------
 *
 * JAX-RS request filter responsible for ROLE-BASED AUTHORIZATION.
 *
 * Author      : Shiv (Associate Software Engineer)
 * Project     : RESTAPI (Jersey / JAX-RS)
 *
 * Responsibilities:
 * - Determine user role based on API key
 * - Authorize requests based on HTTP method
 * - Enforce USER vs ADMIN permissions
 *
 * Authorization Rules:
 * - USER  → GET only
 * - ADMIN → GET, POST, PUT, PATCH, DELETE
 *
 * Status Codes:
 * - 403 Forbidden → Authenticated but not authorized
 *
 * ------------------------------------------------------------
 */

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import java.io.InputStream;
import java.util.Properties;

@Provider
@Priority(Priorities.AUTHORIZATION) // Runs AFTER authentication filter
public class RoleAuthorizationFilter implements ContainerRequestFilter {

    private static final String API_KEY_HEADER = "X-API-KEY";

    private static final String ADMIN_KEY;
    private static final String USER_KEY;

    // Load role-based keys from configuration once
    static {
        try {
            Properties properties = new Properties();

            InputStream inputStream =
                    RoleAuthorizationFilter.class
                            .getClassLoader()
                            .getResourceAsStream("application.properties");

            if (inputStream == null) {
                throw new RuntimeException(
                        "application.properties not found in classpath");
            }

            properties.load(inputStream);

            ADMIN_KEY = properties.getProperty("api.key.admin");
            USER_KEY  = properties.getProperty("api.key.user");

            if (ADMIN_KEY == null || USER_KEY == null) {
                throw new RuntimeException(
                        "API keys for roles not configured properly");
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load role-based API key configuration", e);
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext) {

        // 1️⃣ Read API key (already authenticated)
        String apiKey = requestContext.getHeaderString(API_KEY_HEADER);

        // 2️⃣ Determine role
        String role = determineRole(apiKey);

        // 3️⃣ Read HTTP method
        String method = requestContext.getMethod();

        // 4️⃣ Enforce authorization rules
        if (!isAllowed(role, method)) {

            Response forbiddenResponse =
                    Response.status(Response.Status.FORBIDDEN)
                            .type(MediaType.APPLICATION_JSON)
                            .entity(
                                "{ \"status\": 403, " +
                                "\"message\": \"Access denied for this operation\" }"
                            )
                            .build();

            requestContext.abortWith(forbiddenResponse);
        }
    }

    /**
     * Determines role based on API key.
     */
    private String determineRole(String apiKey) {
        if (ADMIN_KEY.equals(apiKey)) {
            return "ADMIN";
        }
        if (USER_KEY.equals(apiKey)) {
            return "USER";
        }
        return "UNKNOWN";
    }

    /**
     * Authorization rules based on role and HTTP method.
     */
    private boolean isAllowed(String role, String method) {

        // ADMIN can do everything
        if ("ADMIN".equals(role)) {
            return true;
        }

        // USER can only read
        if ("USER".equals(role)) {
            return "GET".equals(method);
        }

        return false;
    }
}
