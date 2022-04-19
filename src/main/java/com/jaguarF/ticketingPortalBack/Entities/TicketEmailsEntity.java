package com.jaguarF.ticketingPortalBack.Entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
@Getter@Setter@NoArgsConstructor
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
