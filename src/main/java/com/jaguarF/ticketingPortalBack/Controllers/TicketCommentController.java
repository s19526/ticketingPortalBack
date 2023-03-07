package com.jaguarF.ticketingPortalBack.Controllers;

import com.jaguarF.ticketingPortalBack.Entities.TicketCommentsEntity;
import com.jaguarF.ticketingPortalBack.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Service("TicketCommentController")
@RequestMapping("comments")
public class TicketCommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{ticketid}/all")
    Collection<TicketCommentsEntity> getAllComments(@PathVariable int ticketid){
        return commentService.getAllComments(ticketid);
    }

    @GetMapping("/{ticketid}")
    Collection<TicketCommentsEntity> getComments(@PathVariable int ticketid){
        return commentService.getComments(ticketid,0);
    }
    @PostMapping("/create")
    TicketCommentsEntity addComment(@RequestBody TicketCommentsEntity comment){
        return commentService.save(comment);
    }









}
