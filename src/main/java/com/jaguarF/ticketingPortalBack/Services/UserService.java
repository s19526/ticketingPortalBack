package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Repositories.TicketRepository;
import com.jaguarF.ticketingPortalBack.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;


    @Transactional
    public UsersEntity save(UsersEntity user) {
        UsersEntity response = repository.save(user);
        return response;
    }

    @Transactional
    public UsersEntity loginUser(UsersEntity user) {
        UsersEntity response = repository.findByEmailAndPasswordSalt(user.getEmail(),user.getPasswordSalt());
        return response;
    }


}
