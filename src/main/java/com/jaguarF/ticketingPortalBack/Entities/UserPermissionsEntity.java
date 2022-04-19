package com.jaguarF.ticketingPortalBack.Entities;

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
