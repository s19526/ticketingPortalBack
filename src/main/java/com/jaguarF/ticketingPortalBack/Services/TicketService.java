package com.jaguarF.ticketingPortalBack.Services;

import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;
import com.jaguarF.ticketingPortalBack.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpStatusCodeException;

import javax.transaction.Transactional;
import java.net.http.HttpResponse;
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
    public TicketsEntity getTicketDetails(int ticketId){
        TicketsEntity ticket = repository.findById(ticketId).get();
        return ticket;
    }

    @Transactional
    public TicketsEntity save(TicketsEntity ticket) {
        TicketsEntity response = repository.save(ticket);
        return response;
    }
    @Transactional
    public TicketsEntity update(TicketsEntity ticket){
            TicketsEntity toUpdate = repository.findById(ticket.getId()).get();
            toUpdate.setSummary(ticket.getSummary());
            toUpdate.setStatus(ticket.getStatus());
            if(ticket.getAssignee()!=null)
                toUpdate.setAssignee(ticket.getAssignee());
            toUpdate.setDescription(ticket.getDescription());
            TicketsEntity response = repository.save(toUpdate);
            return response;
    }
    @Transactional
    public Boolean delete(int id) {
       if(repository.deleteById(id)==1){
           return true;
       }
       return false;
    }
}
