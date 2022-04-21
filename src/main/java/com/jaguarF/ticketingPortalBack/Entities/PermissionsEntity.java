package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "permissions", schema = "TICKETING_PORTAL", catalog = "")
public class PermissionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "created")
    private Timestamp created;

    @OneToMany(mappedBy = "permission")
    private Collection<UserPermissionsEntity> userPermission;

}
