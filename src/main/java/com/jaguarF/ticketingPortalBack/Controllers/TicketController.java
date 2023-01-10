package com.jaguarF.ticketingPortalBack.Controllers;
import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;

import com.jaguarF.ticketingPortalBack.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service("TicketController")
@RequestMapping("tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //Returns list of all tickets or tickets in specified status or reported by specified user
    @GetMapping()
    List<TicketsEntity> getAllTickets(@RequestParam(required = false) String status, @RequestParam(required=false) Integer userId){
        if (status != null){
            List<TicketsEntity> tickets = ticketService.getAllTickets(status);
            if(userId!=null){
                tickets.removeIf(x->x.getAuthor().getId()!=userId);
            }
            return tickets;
        }else if(userId!=null){
            List<TicketsEntity> tickets = ticketService.getUserTickets(userId);
            return tickets;
        }
        List<TicketsEntity> tickets = ticketService.getAllTickets();
        return tickets;
    }

    //Return details for specified ticket
    @GetMapping("/{authorId}")
    TicketsEntity getUserTickets(@PathVariable int authorId){
        TicketsEntity ticket = ticketService.getTicketDetails(authorId);
        return ticket;
    }

    //Creates new ticket
    @PostMapping("/create")
    TicketsEntity createTicket(@RequestBody TicketsEntity ticket){
        TicketsEntity createResponse = ticketService.save(ticket);
        return createResponse;
    }

    //Updates the ticket
    @PutMapping("/change")
    TicketsEntity changeTicket(@RequestBody TicketsEntity ticket){
        TicketsEntity changeResponse = ticketService.update(ticket);
        return changeResponse;
    }

    //Deletes the ticket
    @DeleteMapping("{ticketId}")
    HttpStatus deleteTicket(@PathVariable int ticketId){
        if (ticketService.delete(ticketId)){
            return HttpStatus.NO_CONTENT;
        }else{
            return HttpStatus.NOT_FOUND;
        }
    }
}
