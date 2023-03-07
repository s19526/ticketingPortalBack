package com.jaguarF.ticketingPortalBack.Repositories;

import com.jaguarF.ticketingPortalBack.Entities.TicketCommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<TicketCommentsEntity, Serializable> {
    List<TicketCommentsEntity> findAllByTicketIdAndInternal(int ticketId, int internal);
    List<TicketCommentsEntity> findAllByTicketId(int ticketId);

}
