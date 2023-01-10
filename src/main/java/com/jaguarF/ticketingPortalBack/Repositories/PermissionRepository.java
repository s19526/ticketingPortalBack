package com.jaguarF.ticketingPortalBack.Repositories;

import com.jaguarF.ticketingPortalBack.Entities.PermissionsEntity;
import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionsEntity, Serializable> {
}
