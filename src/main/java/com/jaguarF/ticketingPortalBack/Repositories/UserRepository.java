package com.jaguarF.ticketingPortalBack.Repositories;

import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Serializable> {
    public List<UsersEntity> findById (int userId);
    public UsersEntity findByEmailAndPasswordSalt(String email,String password_salt);
    UsersEntity findUserEntityByIdAndActive(int userId, int i);
}
