package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "statuses", schema = "TICKETING_PORTAL", catalog = "")
public class StatusesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;

}
