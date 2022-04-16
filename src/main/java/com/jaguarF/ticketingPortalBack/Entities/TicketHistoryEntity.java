package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ticket_history", schema = "TICKETING_PORTAL", catalog = "")
public class TicketHistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ticket_id")
    private int ticketId;
    @Basic
    @Column(name = "status_id")
    private int statusId;
    @Basic
    @Column(name = "assignee_id")
    private int assigneeId;
    @Basic
    @Column(name = "action")
    private String action;
    @Basic
    @Column(name = "date")
    private Timestamp date;

}
