package com.jaguarF.ticketingPortalBack.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_permissions", schema = "TICKETING_PORTAL", catalog = "")
public class UserPermissionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "date_added")
    private Timestamp dateAdded;
    @Basic
    @Column(name = "active")
    private int active;

    @ManyToOne(optional = false)
    //@JsonBackReference(value="permission-up")
    private PermissionsEntity permission;

    @ManyToOne(optional = false)
    @JsonBackReference(value="user-up")
    private UsersEntity user;

}
