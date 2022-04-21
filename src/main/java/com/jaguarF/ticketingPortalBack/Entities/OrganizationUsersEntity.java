package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "organization_users", schema = "TICKETING_PORTAL", catalog = "")
public class OrganizationUsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    //@Basic
    //@Column(name = "organization_id")
    //private int organizationId;
    //@Basic
    //@Column(name = "user_id")
    //private int userId;
    @Basic
    @Column(name = "active")
    private int active;

    @ManyToOne(optional = false)
    private OrganizationsEntity organization;

    @ManyToOne(optional = false)
    private UsersEntity user;

}
