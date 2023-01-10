package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.PermissionsEntity;
import com.jaguarF.ticketingPortalBack.Repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService {

    @Autowired
    PermissionRepository repository;

    @Transactional
    public List<PermissionsEntity> getAllPermissions(){
        List<PermissionsEntity> permissions = repository.findAll();
        if (permissions.size()>0){
            return permissions;
        }
        return new ArrayList<>();
    }

}
