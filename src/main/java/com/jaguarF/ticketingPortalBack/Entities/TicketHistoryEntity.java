package com.jaguarF.ticketingPortalBack.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Getter@Setter@NoArgsConstructor
@Entity
@Table(name = "ticket_history", schema = "TICKETING_PORTAL")
public class TicketHistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "action")
    private String action;
    @Basic
    @Column(name = "date")
    private Timestamp date;

    @ManyToOne(optional = false)
    private TicketsEntity ticket;

    @ManyToOne(optional = false)
    private StatusesEntity status;

    @ManyToOne(optional = false)
    private UsersEntity assignee;

}
