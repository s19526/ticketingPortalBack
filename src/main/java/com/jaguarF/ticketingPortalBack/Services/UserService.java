package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Repositories.UserRepository;
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
        UsersEntity response = repository.findByEmailAndPasswordSalt(user.getEmail(),user.getPasswordSalt());
        return response;
    }
    @Transactional
    public UsersEntity getUser(int userId){
        return repository.findById(userId).get(0);
    }

    @Transactional
    public HttpStatus deactivateUser(int userId) {
        UsersEntity ue = repository.findUserEntityByIdAndActive(userId, 1);
        if (ue != null) {
            ue.setLastUpdate(Timestamp.from(Instant.now()));
            ue.setActive(0);
            System.out.println("User updated");
            return HttpStatus.OK;
        } else return HttpStatus.NOT_FOUND;
    }
}
