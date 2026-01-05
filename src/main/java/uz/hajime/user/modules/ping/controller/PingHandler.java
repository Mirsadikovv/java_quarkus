package uz.hajime.user.modules.ping.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/ping")
public class PingHandler {

    @GET
    public String ping() {
        return "pong";
    }
}