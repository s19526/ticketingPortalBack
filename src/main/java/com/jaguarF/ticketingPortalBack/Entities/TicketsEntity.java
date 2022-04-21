package com.jaguarF.ticketingPortalBack.Entities;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.query.Query;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Getter@Setter@NoArgsConstructor
@Entity
@Table(name = "tickets", schema = "TICKETING_PORTAL")
public class TicketsEntity {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    //@Basic
    //@Column(name = "author_id")
    //private int authorId;
    @Basic
    @Column (name = "status")
    private String status;
    @Basic
    @Column(name = "summary")
    private String summary;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "source")
    private String source;
    @Basic
    @Column(name = "date_created")
    private Timestamp dateCreated;

    @ManyToOne(optional = false)
    private UsersEntity author;

    @OneToMany(mappedBy = "ticket")
    private Collection<TicketHistoryEntity> history;

    @OneToMany(mappedBy = "ticket")
    private Collection<TicketCommentsEntity> comments;

    @OneToMany(mappedBy = "ticket")
    private Collection<TicketEmailsEntity> ticketEmails;

}
