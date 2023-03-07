package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.OrganizationUsersEntity;
import com.jaguarF.ticketingPortalBack.Entities.OrganizationsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    OrganizationRepository repository;

    @Transactional
    public List<UsersEntity> getOrganization(int organizationId) {
        OrganizationsEntity organization = repository.findOrganizationsEntityById(organizationId);
        Collection<OrganizationUsersEntity> orgUsers = organization.getOrganizationUsers();
        List<UsersEntity> response = new ArrayList<>();
        orgUsers.forEach(x->response.add(x.getUser()));
        response.sort((x,y)->x.getId()>y.getId()?1:-1);
        return response;

    }


}
