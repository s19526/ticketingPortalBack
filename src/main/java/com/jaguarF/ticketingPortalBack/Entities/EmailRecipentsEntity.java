package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "email_recipents", schema = "TICKETING_PORTAL", catalog = "")
public class EmailRecipentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ticket_email_id")
    private int ticketEmailId;
    @Basic
    @Column(name = "user_id")
    private int userId;
}
