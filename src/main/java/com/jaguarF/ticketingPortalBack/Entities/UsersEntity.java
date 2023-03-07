package com.jaguarF.ticketingPortalBack.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "TICKETING_PORTAL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UsersEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password_salt")
    private String passwordSalt;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "date_added")
    private Timestamp dateAdded;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
    @Basic
    @Column(name = "active")
    private int active;



    @OneToMany(mappedBy = "author")
    @JsonIgnore
    @JsonBackReference(value="user-ticket")
    private Collection<TicketsEntity> Tickets;


    @OneToMany(mappedBy = "user")
    //@JsonManagedReference(value="user-up")
    private Collection<UserPermissionsEntity> UserPermissions;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    //@JsonManagedReference(value="user-er")
    private Collection<EmailRecipientsEntity> EmailsReceived;


    @OneToMany(mappedBy = "user")
    //@JsonManagedReference(value="user-ou")
    private Collection<OrganizationUsersEntity> UserOrganizations;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    @JsonBackReference(value="user-tc")
    //@JsonManagedReference(value="user-tc")
    private Collection<TicketCommentsEntity> CommentsAdded;

    @OneToMany(mappedBy = "assignee")
    @JsonIgnore
    @JsonBackReference(value="user-th")
    private Collection<TicketHistoryEntity> TicketHistory;

    @OneToMany(mappedBy = "assignee")
    @JsonIgnore
    //@JsonBackReference(value="assignee-ticket")
    //@JsonManagedReference(value="user-th")
    private Collection<TicketsEntity> TicketsAssigned;


}
