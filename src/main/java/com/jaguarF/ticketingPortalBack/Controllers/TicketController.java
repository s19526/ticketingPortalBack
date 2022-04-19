package com.jaguarF.ticketingPortalBack.Controllers;
import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;

import com.jaguarF.ticketingPortalBack.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service("TicketController")
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping()
    List<TicketsEntity> getAllTickets(){
        List<TicketsEntity> tickets = ticketService.getAllTickets();
        return tickets;
    }
    @GetMapping("/{id}")
    List<TicketsEntity> getUserTickets(@PathVariable int id){
        List<TicketsEntity> tickets = ticketService.getUserTickets(id);
        return tickets;
    }



}
