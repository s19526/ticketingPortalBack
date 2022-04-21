package com.jaguarF.ticketingPortalBack.Repositories;

import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketsEntity, Serializable> {
    public List<TicketsEntity> findByAuthorId (int authorId);
    public List<TicketsEntity> findByStatus (String status);
}
