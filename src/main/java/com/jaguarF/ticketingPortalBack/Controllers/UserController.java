package com.jaguarF.ticketingPortalBack.Controllers;

import com.jaguarF.ticketingPortalBack.Entities.UserPermissionsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;

@RestController
@Service("UserController")
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    //Creates new user
    @PostMapping("/{create}")
    UsersEntity createUser(@RequestBody UsersEntity user){
        user.setActive(1);
        UsersEntity createResponse = userService.save(user);
        return createResponse;
    }

    @PutMapping("/update")
    UsersEntity updateUser(@RequestBody UsersEntity user){
        user.setLastUpdate(Timestamp.from(Instant.now()));
        UsersEntity updateResponse = userService.save(user);
        return updateResponse;
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

    @PostMapping("/{userId}/activate")
    HttpStatus activateUser(@PathVariable int userId){
        return userService.activateUser(userId);
    }







}
