package com.siva.RESTAPI.resource;

/**
 * ------------------------------------------------------------
 * CricketResource
 * ------------------------------------------------------------
 *
 * REST Resource class exposing Cricket Player APIs.
 *
 * Author      : Shiv (Associate Software Engineer)
 * Project     : RESTAPI (JAX-RS / Jersey)
 * Description : Handles HTTP requests and delegates all
 *               business logic to the Service layer.
 *
 * Architecture:
 *   Resource  →  Service  →  Repository Interface  →  JDBC Repo
 *
 * Notes:
 * - This class contains NO business logic.
 * - All validations and exceptions are handled in Service.
 * - Responses follow RESTful HTTP semantics.
 *
 * ------------------------------------------------------------
 */

import com.siva.RESTAPI.model.ApiResponse;
import com.siva.RESTAPI.model.CricketPlayer;
import com.siva.RESTAPI.service.CricketPlayerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cricket")
public class CricketResource {

    /**
     * Service layer acts as the business logic coordinator.
     * Resource layer should NOT directly interact with the repository.
     */
    private final CricketPlayerService service = new CricketPlayerService();

    /**
     * HTTP GET
     * URL: /cricket
     *
     * Responsibility:
     * - Accept HTTP request
     * - Delegate business logic to Service layer
     * - Return HTTP response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CricketPlayer> getAllPlayers() {

        // Delegates data fetching to service layer
        return service.getAllPlayers();
    }

    /**
     * HTTP GET
     * URL: /cricket/{id}
     *
     * Responsibility:
     * - Extract path parameter
     * - Delegate existence check and fetching to Service layer
     * - Return HTTP response only
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerById(@PathParam("id") int id) {

        // Service layer handles:
        // - Existence validation
        // - PlayerNotFoundException if needed
        CricketPlayer player = service.getPlayerById(id);

        return Response.ok(player).build();
    }

    /**
     * HTTP GET
     * URL: /cricket/players?name=Virat
     *
     * Responsibility:
     * - Read query parameter
     * - Delegate validation & filtering logic to Service layer
     */
    @GET
    @Path("/players")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayersByName(@QueryParam("name") String name) {

        // Validation logic moved to service layer
        List<CricketPlayer> players = service.getPlayersByName(name);

        return Response.ok(players).build();
    }

    /**
     * HTTP POST
     * URL: /cricket
     *
     * Responsibility:
     * - Accept request body
     * - Delegate validation, duplicate check, and save logic to Service layer
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlayer(CricketPlayer player) {

        // Service layer handles:
        // - Field validation
        // - Duplicate checks
        // - Persistence
        CricketPlayer saved = service.createPlayer(player);

        ApiResponse<CricketPlayer> response =
                new ApiResponse<>(201,
                                  "Player inserted successfully",
                                  saved);

        return Response.status(Response.Status.CREATED)
                       .entity(response)
                       .build();
    }

    /**
     * Bulk insert endpoint.
     *
     * Resource only checks request shape.
     * All business rules are handled in Service.
     */
    @POST
    @Path("/bulk")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlayersInBulk(List<CricketPlayer> players) {

        ApiResponse<?> response = service.addPlayersInBulk(players);

        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    
    /**
     * HTTP PUT
     * URL: /cricket/players/{id}
     *
     * Responsibility:
     * - Accept full object replacement
     * - Delegate all business rules to Service layer
     */
    @PUT
    @Path("/players/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlayer(@PathParam("id") int id,
                                 CricketPlayer player) {

        // Service layer handles:
        // - Validation
        // - Existence check
        // - Duplicate prevention
        CricketPlayer updated = service.updatePlayer(id, player);

        return Response.ok(updated).build();
    }

    /**
     * HTTP PATCH
     * URL: /cricket/players/{id}
     *
     * Responsibility:
     * - Accept partial updates
     * - Delegate merge & persistence logic to Service layer
     */
    @PATCH
    @Path("/players/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchPlayer(@PathParam("id") int id,
                                CricketPlayer incomingPlayer) {

        // Service layer handles:
        // - Fetch existing entity
        // - Apply partial updates
        // - Save changes
        CricketPlayer updated = service.patchPlayer(id, incomingPlayer);

        ApiResponse<CricketPlayer> response =
                new ApiResponse<>(200,
                                  "Player updated successfully",
                                  updated);

        return Response.ok(response).build();
    }

    /**
     * HTTP DELETE
     * URL: /cricket/players/{id}
     *
     * Responsibility:
     * - Delegate existence check and delete operation to Service layer
     * - Return REST-pure 204 response
     */
    @DELETE
    @Path("/players/{id}")
    public Response deletePlayer(@PathParam("id") int id) {

        // Service layer handles:
        // - Player existence validation
        // - Delete operation
        service.deletePlayer(id);

        return Response.noContent().build(); // 204
    }
}
