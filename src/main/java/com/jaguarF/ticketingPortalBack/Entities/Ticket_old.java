package com.jaguarF.ticketingPortalBack.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
@Data
@Entity(name = "tickets")
@Table(schema = "TICKETING_PORTAL")
public class Ticket_old {

        @Id
        @Getter@Setter private Long id;
        @Getter@Setter private String name;
        @Getter@Setter private Long author_id;
        @Getter@Setter private String description;
        @Getter@Setter private String source;
        @Getter@Setter private Timestamp date_created;

        public Ticket_old() {
        }
        public Ticket_old(Long userId){
                //get tickets for chosen user
        }

        public static List<Ticket_old> getUserTickets(Long userId) {


                Configuration cfg = new Configuration();
                cfg.configure();
                SessionFactory sf = cfg.buildSessionFactory();
                Session s = sf.openSession();
                Query<Ticket_old> q = s.createQuery("FROM tickets WHERE author_id == " + userId);
                List<Ticket_old> results = q.list();
                return results;
        }

}
