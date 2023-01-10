package com.jaguarF.ticketingPortalBack.Controllers;

import com.jaguarF.ticketingPortalBack.Entities.OrganizationUsersEntity;
import com.jaguarF.ticketingPortalBack.Entities.UserPermissionsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Services.OrganizationService;
import com.jaguarF.ticketingPortalBack.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@Service("OrganizationController")
@RequestMapping("organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/{organizationId}/users")
    Collection<UsersEntity> getUser(@PathVariable int organizationId){
        return organizationService.getOrganization(organizationId);
    }







}
