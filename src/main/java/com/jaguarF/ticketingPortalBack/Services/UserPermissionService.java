package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.PermissionsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UserPermissionsEntity;
import com.jaguarF.ticketingPortalBack.Repositories.PermissionRepository;
import com.jaguarF.ticketingPortalBack.Repositories.UserPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserPermissionService {

    @Autowired
    UserPermissionRepository repository;

    @Transactional
    public List<UserPermissionsEntity> getUserPermissions(int userId){
        List<UserPermissionsEntity> permissions = repository.findByUserId(userId);
        if (permissions.size()>0){
            System.out.printf(new ArrayList<>(permissions).toString());
            return permissions;
        }
        return new ArrayList<>();
    }

}
