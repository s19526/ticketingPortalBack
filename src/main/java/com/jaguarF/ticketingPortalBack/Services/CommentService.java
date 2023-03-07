package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.OrganizationUsersEntity;
import com.jaguarF.ticketingPortalBack.Entities.OrganizationsEntity;
import com.jaguarF.ticketingPortalBack.Entities.TicketCommentsEntity;
import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;


@Service
public class CommentService {
    @Autowired
    CommentRepository repository;

    @Transactional
    public List<TicketCommentsEntity> getAllComments(int ticketId) {
        List<TicketCommentsEntity> tickets = repository.findAllByTicketId(ticketId);
        return tickets;
    }
    @Transactional
    public List<TicketCommentsEntity> getComments(int ticketId, int internal) {
        List<TicketCommentsEntity> tickets = repository.findAllByTicketIdAndInternal(ticketId,internal);
        return tickets;
    }

    @Transactional
    public TicketCommentsEntity save(TicketCommentsEntity comment) {
      return repository.save(comment);
    }
}

