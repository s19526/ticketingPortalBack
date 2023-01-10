package com.jaguarF.ticketingPortalBack.Controllers;

import com.jaguarF.ticketingPortalBack.Entities.PermissionsEntity;
import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UserPermissionsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Repositories.UserPermissionRepository;
import com.jaguarF.ticketingPortalBack.Services.PermissionService;
import com.jaguarF.ticketingPortalBack.Services.TicketService;
import com.jaguarF.ticketingPortalBack.Services.UserPermissionService;
import com.jaguarF.ticketingPortalBack.Services.UserService;
import org.apache.catalina.User;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.CollectionTable;
import javax.websocket.server.PathParam;
import java.io.Serializable;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@Service("UserController")
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    //Creates new user
    @PostMapping("/{create}")
    UsersEntity createTicket(@RequestBody UsersEntity user){
        user.setActive(1);
        UsersEntity createResponse = userService.save(user);
        return createResponse;
    }

    @PostMapping("/login")
    UsersEntity loginUser(@RequestBody UsersEntity user){
        UsersEntity createResponse = userService.loginUser(user);
        return createResponse;
    }

    @GetMapping("/permissions/{userId}")
    Collection<UserPermissionsEntity> getUsersPermissions (@PathVariable int userId){
        Collection<UserPermissionsEntity> createResponse = userService.getUser(userId).getUserPermissions();
        return createResponse;
    }

    @GetMapping("/{userId}")
    UsersEntity getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }

    @PostMapping("/{userId}/deactivate")
    HttpStatus deactivateUser(@PathVariable int userId){
        return userService.deactivateUser(userId);
    }







}
