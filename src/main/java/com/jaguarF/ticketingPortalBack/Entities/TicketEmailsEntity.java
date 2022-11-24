package com.jaguarF.ticketingPortalBack.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference(value="ticket-te")
    private TicketsEntity ticket;

    @ManyToOne(optional = false)
    @JsonBackReference(value="email-te")
    private EmailsEntity email;

    @OneToMany(mappedBy = "ticketEmail")
    @JsonManagedReference(value="te-er")
    private Collection<EmailRecipientsEntity> recipients;

}
