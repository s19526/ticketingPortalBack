package com.jaguarF.ticketingPortalBack.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    //@JsonManagedReference(value="permission-up")
    @JsonBackReference(value="permission-up")
    private Collection<UserPermissionsEntity> userPermission;

}
