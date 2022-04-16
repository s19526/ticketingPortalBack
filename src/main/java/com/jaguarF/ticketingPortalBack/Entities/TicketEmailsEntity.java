package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@Entity
@Table(name = "ticket_emails", schema = "TICKETING_PORTAL")
public class TicketEmailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ticket_id")
    private int ticketId;
    @Basic
    @Column(name = "email_id")
    private int emailId;
    @Basic
    @Column(name = "date_sent")
    private Timestamp dateSent;

}
