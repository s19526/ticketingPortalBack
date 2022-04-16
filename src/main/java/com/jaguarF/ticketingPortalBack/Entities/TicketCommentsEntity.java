package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@Entity
@Table(name = "ticket_comments", schema = "TICKETING_PORTAL", catalog = "")
public class TicketCommentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ticket_id")
    private int ticketId;
    @Basic
    @Column(name = "author_id")
    private int authorId;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "date_added")
    private Timestamp dateAdded;
    @Basic
    @Column(name = "internal")
    private int internal;
    @Basic
    @Column(name = "deleted")
    private int deleted;

}
