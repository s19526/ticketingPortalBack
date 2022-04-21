package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;
import com.jaguarF.ticketingPortalBack.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository repository;


    //Method to retrieve all the existing tickets
    @Transactional
    public List<TicketsEntity> getAllTickets(){
        List<TicketsEntity> tickets = repository.findAll();
        if(tickets.size() > 0) {
            return tickets;
        }
    return new ArrayList<>();
    }
    @Transactional
    public List<TicketsEntity> getAllTickets(String status){
        List<TicketsEntity> tickets = repository.findByStatus(status);
        if(tickets.size() > 0) {
            return tickets;
        }
        return new ArrayList<>();
    }
    //Method to retrieve all the existing tickets reported by specified user
    @Transactional
    public List<TicketsEntity> getUserTickets(int authorId){
        List<TicketsEntity> tickets = repository.findByAuthorId(authorId);
        if(tickets.size() > 0) {
            return tickets;
        }
        return new ArrayList<>();
    }

    @Transactional
    public TicketsEntity save(TicketsEntity ticket){
            TicketsEntity response = repository.save(ticket);
            return response;
    }

    @Transactional
    public TicketsEntity update(TicketsEntity ticket){
            TicketsEntity response = repository.save(ticket);
            return response;
    }



}
