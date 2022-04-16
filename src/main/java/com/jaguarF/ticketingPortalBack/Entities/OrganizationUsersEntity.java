package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "organization_users", schema = "TICKETING_PORTAL", catalog = "")
public class OrganizationUsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "organization_id")
    private int organizationId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "active")
    private int active;

}
