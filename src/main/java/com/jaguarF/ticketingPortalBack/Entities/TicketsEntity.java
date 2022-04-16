package com.jaguarF.ticketingPortalBack.Entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "tickets", schema = "TICKETING_PORTAL")
public class TicketsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "author_id")
    private int authorId;
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

}
