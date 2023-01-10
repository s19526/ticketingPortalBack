package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.OrganizationUsersEntity;
import com.jaguarF.ticketingPortalBack.Entities.OrganizationsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Repositories.OrganizationRepository;
import com.jaguarF.ticketingPortalBack.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    OrganizationRepository repository;


    @Transactional
    public Collection<UsersEntity> getOrganization(int organizationId) {
        OrganizationsEntity organization = repository.findOrganizationsEntityById(organizationId);
        Collection<OrganizationUsersEntity> orgUsers = organization.getOrganizationUsers();
        Collection<UsersEntity> response = new ArrayList<>();
        orgUsers.forEach(x->response.add(x.getUser()));
        return response;
    }


}
