package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_permissions", schema = "TICKETING_PORTAL", catalog = "")
public class UserPermissionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "permission_id")
    private int permissionId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "date_added")
    private Timestamp dateAdded;
    @Basic
    @Column(name = "active")
    private int active;

}
