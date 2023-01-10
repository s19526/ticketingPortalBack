package com.jaguarF.ticketingPortalBack.Repositories;

import com.jaguarF.ticketingPortalBack.Entities.OrganizationsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationsEntity, Serializable> {
    OrganizationsEntity findOrganizationsEntityById(int organizationId);
}
