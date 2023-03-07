package com.jaguarF.ticketingPortalBack.Repositories;

import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Serializable> {
    UsersEntity findById (int userId);
    UsersEntity findByEmailAndPasswordSaltAndActive(String email,String password_salt, int active);
    UsersEntity findUserEntityByIdAndActive(int userId, int i);
}
