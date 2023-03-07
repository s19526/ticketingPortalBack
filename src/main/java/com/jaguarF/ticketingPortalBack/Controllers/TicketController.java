package com.jaguarF.ticketingPortalBack.Controllers;
import com.jaguarF.ticketingPortalBack.Entities.OrganizationUsersEntity;
import com.jaguarF.ticketingPortalBack.Entities.TicketHistoryEntity;
import com.jaguarF.ticketingPortalBack.Entities.TicketsEntity;

import com.jaguarF.ticketingPortalBack.Entities.UsersEntity;
import com.jaguarF.ticketingPortalBack.Services.TicketService;
import com.jaguarF.ticketingPortalBack.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@Service("TicketController")
@RequestMapping("tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;
    //Returns list of all tickets or tickets in specified status or reported by specified user
    @GetMapping()
    List<TicketsEntity> getAllTickets( @RequestParam(required=false) Integer userId){
        if(userId!=null){
            List<TicketsEntity> tickets = new ArrayList<>();
            UsersEntity user = userService.getUser(userId);
            List<OrganizationUsersEntity> oue = (List)user.getUserOrganizations();
            for (OrganizationUsersEntity userOrganization : oue.get(0).getOrganization().getOrganizationUsers()) {
                tickets.addAll(ticketService.getUserTickets(userOrganization.getUser().getId()));
                tickets.sort((x,y)->x.getId()>y.getId()?1:-1);
            }
            return tickets;
        }
        List<TicketsEntity> tickets = ticketService.getAllTickets();
        return tickets;
    }

    //Return details of selected ticket
    @GetMapping("/{ticketId}")
    TicketsEntity getUserTickets(@PathVariable int ticketId){
        TicketsEntity ticket = ticketService.getTicketDetails(ticketId);
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

    @GetMapping("{ticketId}/history")
    Collection<TicketHistoryEntity> getTicketHistory(@PathVariable int ticketId){
        TicketsEntity ticket = ticketService.getTicketDetails(ticketId);
        return ticket.getHistory();
    }
}
