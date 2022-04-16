package com.jaguarF.ticketingPortalBack.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jaguarF.ticketingPortalBack.Entities.Ticket_old;

import java.util.List;

@RestController
public class TicketController {

    @GetMapping("/tickets")
    public static List<Ticket_old> getTickets(@RequestParam(value="userId") Long userId){
        return Ticket_old.getUserTickets(userId);
    }

}
