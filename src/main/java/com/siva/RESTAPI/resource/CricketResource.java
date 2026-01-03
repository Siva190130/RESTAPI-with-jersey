package com.siva.RESTAPI.resource;

import com.siva.RESTAPI.model.ApiResponse;
import com.siva.RESTAPI.model.CricketPlayer;
import com.siva.RESTAPI.repository.CricketPlayerRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.List;

@Path("/cricket")
public class CricketResource {

    private final CricketPlayerRepository repository = new CricketPlayerRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CricketPlayer> getAllPlayers() {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlayer(CricketPlayer player) {

        repository.save(player);

        ApiResponse<CricketPlayer> response =
                new ApiResponse<>(200,
                                  "Player inserted successfully",
                                  player);

        return Response.status(Response.Status.OK)
                       .entity(response)
                       .build();
    }
    
    @POST
    @Path("/bulk")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlayers(List<CricketPlayer> players) {
    	repository.saveAll(players);

        ApiResponse<List<CricketPlayer>> response =
                new ApiResponse<>(200,
                                  "Players inserted successfully",
                                  players);

        return Response.status(Response.Status.OK)
                       .entity(response)
                       .build();
    }

}
