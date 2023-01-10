package com.jaguarF.ticketingPortalBack.Repositories;

import com.jaguarF.ticketingPortalBack.Entities.PermissionsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UserPermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermissionsEntity, Serializable> {

    public  List<UserPermissionsEntity> findByUserId(int userId);
}
