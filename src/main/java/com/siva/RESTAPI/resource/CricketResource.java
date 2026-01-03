package com.siva.RESTAPI.resource;

import com.siva.RESTAPI.model.ApiResponse;
import com.siva.RESTAPI.model.CricketPlayer;
import com.siva.RESTAPI.repository.CricketPlayerRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/cricket")
public class CricketResource {

    private final CricketPlayerRepository repository = new CricketPlayerRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CricketPlayer> getAllPlayers() {
        return repository.findAll();
    }
    
    /**
     * HTTP GET method
     * URL: /api/cricket/{id}
     * Purpose: Fetch a single player using ID
     */
    @GET
    @Path("/{id}")                       // Path variable (dynamic value)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerById(
            @PathParam("id") int id) {   // Extracts ID from URL

        // Fetch player from database
        CricketPlayer player = repository.findById(id);

        // If no player found, return 404 Not Found
        if (player == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .build();
        }

        // If found, return 200 OK with player data
        return Response.status(Response.Status.OK)
                       .entity(player)   // JSON body
                       .build();
    }
    
    
    /**
     * Handles HTTP GET request to fetch players based on name.
     * Example:
     *   GET /cricket/players?name=Virat
     *
     * @param name query parameter used to filter players by name
     * @return HTTP response containing list of matching players
     */
    @GET
    @Path("/players")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayersByName(@QueryParam("name") String name) {

        // Validate query parameter
        if (name == null || name.trim().isEmpty()) {

            // Return 400 Bad Request if name is missing
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Query parameter 'name' must not be empty")
                    .build();
        }

        
		// Fetch players from repository based on name
        List<CricketPlayer> players =
                repository.getPlayersByName(name);

        // Return successful response with fetched data
        return Response
                .status(Response.Status.OK)
                .entity(players)
                .build();
    }



    /**
     * Creates a single cricket player.
     * Performs basic validation and duplicate check.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlayer(CricketPlayer player) {

        // ---------- Basic validation ----------
        if (player == null ||
            player.getName() == null || player.getName().trim().isEmpty() ||
            player.getTeam() == null || player.getTeam().trim().isEmpty() ||
            player.getRole() == null || player.getRole().trim().isEmpty()) {

            ApiResponse<String> response =
                    new ApiResponse<>(400,
                                      "Invalid player data. Name, team, and role are required.",
                                      null);

            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(response)
                           .build();
        }

        // ---------- Duplicate check (name + team) ----------
        boolean exists =
                repository.playerExists(player.getName(), player.getTeam());

        if (exists) {
            ApiResponse<String> response =
                    new ApiResponse<>(409,
                                      "Player already exists for this team.",
                                      null);

            return Response.status(Response.Status.CONFLICT)
                           .entity(response)
                           .build();
        }

        // ---------- Save player ----------
        repository.save(player);

        ApiResponse<CricketPlayer> response =
                new ApiResponse<>(201,
                                  "Player inserted successfully",
                                  player);

        return Response.status(Response.Status.CREATED)
                       .entity(response)
                       .build();
    }

    /**
     * Inserts multiple cricket players in bulk.
     * Skips duplicates and invalid records.
     */
    @POST
    @Path("/bulk")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlayers(List<CricketPlayer> players) {

        // ---------- Validate request ----------
        if (players == null || players.isEmpty()) {

            ApiResponse<String> response =
                    new ApiResponse<>(400,
                                      "Player list must not be empty.",
                                      null);

            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(response)
                           .build();
        }

        List<CricketPlayer> insertedPlayers = new ArrayList<>();
        List<CricketPlayer> skippedPlayers  = new ArrayList<>();

        // ---------- Process each player ----------
        for (CricketPlayer player : players) {

            // Basic validation
            if (player.getName() == null || player.getName().trim().isEmpty() ||
                player.getTeam() == null || player.getTeam().trim().isEmpty() ||
                player.getRole() == null || player.getRole().trim().isEmpty()) {

                skippedPlayers.add(player);
                continue;
            }

            // Duplicate check
            boolean exists =
                    repository.playerExists(player.getName(), player.getTeam());

            if (exists) {
                skippedPlayers.add(player);
                continue;
            }

            repository.save(player);
            insertedPlayers.add(player);
        }

        // ---------- Prepare response ----------
        ApiResponse<Object> response =
                new ApiResponse<>(201,
                                  "Bulk insert completed. "
                                          + "Inserted: " + insertedPlayers.size()
                                          + ", Skipped: " + skippedPlayers.size(),
                                  insertedPlayers);

        return Response.status(Response.Status.CREATED)
                       .entity(response)
                       .build();
    }


}
