package com.jaguarF.ticketingPortalBack.Entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Getter@Setter@NoArgsConstructor
@Entity
@Table(name = "ticket_emails", schema = "TICKETING_PORTAL")
public class TicketEmailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    //@Basic
    //@Column(name = "ticket_id")
    //private int ticketId;
    //@Basic
    //@Column(name = "email_id")
    //private int emailId;
    @Basic
    @Column(name = "date_sent")
    private Timestamp dateSent;

    @ManyToOne(optional = false)
    private TicketsEntity ticket;

    @ManyToOne(optional = false)
    private EmailsEntity email;

    @OneToMany(mappedBy = "ticketEmail")
    private Collection<EmailRecipentsEntity> recipents;

}
