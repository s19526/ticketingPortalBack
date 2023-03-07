package com.jaguarF.ticketingPortalBack.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "email_recipents", schema = "TICKETING_PORTAL", catalog = "")
public class EmailRecipientsEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne(optional = false)
    @JsonBackReference(value="te-er")
    private TicketEmailsEntity ticketEmail;

    @ManyToOne(optional = false)
    @JsonBackReference(value="user-er")
    private UsersEntity user;

}
