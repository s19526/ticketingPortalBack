package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "organizations", schema = "TICKETING_PORTAL", catalog = "")
public class OrganizationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "company_name")
    private String companyName;
    @Basic
    @Column(name = "max_users")
    private int maxUsers;
    @Basic
    @Column(name = "priority")
    private String priority;
    @Basic
    @Column(name = "active")
    private int active;
}
