package uz.hajime.user.modules.user.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import uz.hajime.user.modules.user.UserService;
import uz.hajime.user.modules.user.dto.UserCreateDto;

@Path("/user")
public class UserController {

    @Inject
    UserService userService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(UserCreateDto dto) {
        userService.createUser(dto);
    }
}
