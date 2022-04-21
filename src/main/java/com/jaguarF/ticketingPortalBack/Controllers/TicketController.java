package com.jaguarF.ticketingPortalBack.Controllers;
import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;

import com.jaguarF.ticketingPortalBack.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.util.List;

@RestController
@Service("TicketController")
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //Returns list of all tickets or tickets in specified status
    @GetMapping()
    List<TicketsEntity> getAllTickets(@RequestParam(required = false) String status){
        if (status != null){
            List<TicketsEntity> tickets = ticketService.getAllTickets(status);
            return tickets;
        }
        List<TicketsEntity> tickets = ticketService.getAllTickets();
        return tickets;
    }

    //Returns list of all tickets reported by specified user
    @GetMapping("/{user_id}")
    List<TicketsEntity> getUserTickets(@PathVariable int user_id){
        List<TicketsEntity> tickets = ticketService.getUserTickets(user_id);
        return tickets;
    }

    //Creates new ticket
    @PostMapping("/create")
    TicketsEntity createTicket(@RequestBody TicketsEntity ticket){
        TicketsEntity createResponse = ticketService.save(ticket);
        return createResponse;
    }

    //Updates the ticket
    @PutMapping("/change")
    TicketsEntity changeStatus(@RequestBody TicketsEntity ticket){
        TicketsEntity changeResponse = ticketService.update(ticket);
        return changeResponse;

    }


//ResponseEntity.status(HttpStatus.OK).body("");






}
