package com.jaguarF.ticketingPortalBack.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor

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

    @OneToMany(mappedBy = "organization")
    //@JsonManagedReference(value="organization-ou")
    @JsonBackReference(value="organization-ou")
    private Collection<OrganizationUsersEntity> organizationUsers;

}
