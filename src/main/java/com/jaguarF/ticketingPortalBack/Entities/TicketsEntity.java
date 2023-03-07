package com.jaguarF.ticketingPortalBack.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tickets", schema = "TICKETING_PORTAL", catalog = "")
public class TicketsEntity {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column (name = "status")
    private String status;
    @Basic
    @Column(name = "summary")
    private String summary;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "source")
    private String source;
    @Basic
    @Column(name = "date_created")
    private Timestamp dateCreated;

    //@JsonManagedReference(value="user-ticket")
    @ManyToOne(optional = false)
    private UsersEntity author;
    @ManyToOne()
    private UsersEntity assignee;

    @OneToMany(mappedBy = "ticket")
    @JsonManagedReference(value="ticket-tc")
    private Collection<TicketCommentsEntity> comments = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "ticket")
    @JsonIgnore
    //@JsonBackReference(value="ticket-th")
    private Collection<TicketHistoryEntity> history = new java.util.ArrayList<>();


    @OneToMany(mappedBy = "ticket")
    @JsonManagedReference(value="ticket-te")
    private Collection<TicketEmailsEntity> ticketEmails = new java.util.ArrayList<>();

}
