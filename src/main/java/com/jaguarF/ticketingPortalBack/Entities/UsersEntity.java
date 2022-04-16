package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
@Data
@Entity
@Table(name = "users", schema = "TICKETING_PORTAL", catalog = "")
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
    private int passwordSalt;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "second_name")
    private String secondName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Basic
    @Column(name = "avatar")
    private byte[] avatar;
    @Basic
    @Column(name = "date_added")
    private Timestamp dateAdded;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
    @Basic
    @Column(name = "active")
    private int active;

}
