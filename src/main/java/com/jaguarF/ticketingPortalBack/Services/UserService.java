package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;

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
        UsersEntity response = repository.findByEmailAndPasswordSaltAndActive(user.getEmail(),user.getPasswordSalt(),1);
        return response;
    }
    @Transactional
    public UsersEntity getUser(int userId){
        return repository.findById(userId);
    }

    @Transactional
    public HttpStatus deactivateUser(int userId) {
        UsersEntity ue = repository.findUserEntityByIdAndActive(userId, 1);
        if (ue != null) {
            ue.setLastUpdate(Timestamp.from(Instant.now()));
            ue.setActive(0);
            return HttpStatus.OK;
        } else return HttpStatus.NOT_FOUND;
    }
    @Transactional
    public HttpStatus activateUser(int userId) {
        UsersEntity ue = repository.findUserEntityByIdAndActive(userId, 0);
        if (ue != null) {
            ue.setLastUpdate(Timestamp.from(Instant.now()));
            ue.setActive(1);
            return HttpStatus.OK;
        } else return HttpStatus.NOT_FOUND;
    }
}
