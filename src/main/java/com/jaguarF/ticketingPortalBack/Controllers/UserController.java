package com.jaguarF.ticketingPortalBack.Controllers;

import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Services.TicketService;
import com.jaguarF.ticketingPortalBack.Services.UserService;
import org.apache.catalina.User;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service("UserController")
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;


    //Creates new user
    @PostMapping("/create")
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






}
