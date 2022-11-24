-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-04-13 17:50:07.241

CREATE DATABASE TICKETING_PORTAL;
USE TICKETING_PORTAL;

-- tables
-- Table: email_recipents
CREATE TABLE email_recipents (
    id int NOT NULL AUTO_INCREMENT,
    ticket_email_id int NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT ticket_emails_pk PRIMARY KEY (id)
);

-- Table: emails
CREATE TABLE emails (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    subject varchar(100) NOT NULL,
    content varchar(1000) NOT NULL,
    created timestamp NOT NULL,
    CONSTRAINT emails_pk PRIMARY KEY (id)
);

-- Table: organization_users
CREATE TABLE organization_users (
    id int NOT NULL AUTO_INCREMENT,
    organization_id int NOT NULL,
    user_id int NOT NULL,
    active int NOT NULL,
    CONSTRAINT organization_users_pk PRIMARY KEY (id)
);

-- Table: organizations
CREATE TABLE organizations (
    id int NOT NULL AUTO_INCREMENT,
    company_name varchar(64) NOT NULL,
    max_users int NOT NULL,
    priority varchar(9) NOT NULL COMMENT 'Atrybut ''''priority'''' będzie przyjmował jedną z 3 wartości:
NORMAL / HIGH / VERY_HIGH ',
    active int NOT NULL,
    CONSTRAINT organizations_pk PRIMARY KEY (id)
);

-- Table: permissions
CREATE TABLE permissions (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    created timestamp NOT NULL,
    CONSTRAINT permissions_pk PRIMARY KEY (id)
);

-- Table: statuses
CREATE TABLE statuses (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    description varchar(64) NOT NULL,
    CONSTRAINT statuses_pk PRIMARY KEY (id)
);

-- Table: ticket_comments
CREATE TABLE ticket_comments (
    id int NOT NULL AUTO_INCREMENT,
    ticket_id int NOT NULL,
    author_id int NOT NULL,
    content varchar(500) NOT NULL,
    date_added timestamp NOT NULL,
    internal int NOT NULL,
    deleted int NOT NULL,
    CONSTRAINT ticket_comments_pk PRIMARY KEY (id)
);

-- Table: ticket_emails
CREATE TABLE ticket_emails (
    id int NOT NULL AUTO_INCREMENT,
    ticket_id int NOT NULL,
    email_id int NOT NULL,
    date_sent timestamp NOT NULL,
    CONSTRAINT ticket_emails_pk PRIMARY KEY (id)
);

-- Table: ticket_history
CREATE TABLE ticket_history (
    id int NOT NULL AUTO_INCREMENT,
    ticket_id int NOT NULL,
    status_id int NOT NULL,
    assignee_id int NOT NULL,
    action varchar(64) NOT NULL,
    date timestamp NOT NULL,
    CONSTRAINT ticket_history_pk PRIMARY KEY (id)
);

-- Table: tickets
CREATE TABLE tickets (
    id int NOT NULL AUTO_INCREMENT,
    author_id int NOT NULL,
    summary varchar(100) NOT NULL,
    description varchar(500) NOT NULL,
    source varchar(6) NOT NULL COMMENT 'W tym polu chce przechowywać informację o kanale przez który zgłoszenie zostało złożone',
    date_created timestamp NOT NULL,
    CONSTRAINT tickets_pk PRIMARY KEY (id)
);

-- Table: user_permissions
CREATE TABLE user_permissions (
    id int NOT NULL AUTO_INCREMENT,
    permission_id int NOT NULL,
    user_id int NOT NULL,
    date_added timestamp NOT NULL,
    active int NOT NULL,
    CONSTRAINT user_permissions_pk PRIMARY KEY (id)
);

-- Table: users
CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(64) NOT NULL,
    password_salt int NOT NULL,
    name varchar(32) NOT NULL,
    second_name varchar(32) NULL,
    last_name varchar(64) NOT NULL,
    date_of_birth date NULL,
    avatar blob NULL,
    date_added timestamp NOT NULL,
    last_update timestamp NULL,
    active int NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: email_recipents_ticket_emails (table: email_recipents)
ALTER TABLE email_recipents ADD CONSTRAINT email_recipents_ticket_emails FOREIGN KEY email_recipents_ticket_emails (ticket_email_id)
    REFERENCES ticket_emails (id);

-- Reference: email_recipents_users (table: email_recipents)
ALTER TABLE email_recipents ADD CONSTRAINT email_recipents_users FOREIGN KEY email_recipents_users (user_id)
    REFERENCES users (id);

-- Reference: email_sticket_emails (table: ticket_emails)
ALTER TABLE ticket_emails ADD CONSTRAINT email_sticket_emails FOREIGN KEY email_sticket_emails (email_id)
    REFERENCES emails (id);

-- Reference: organizations_organization_users (table: organization_users)
ALTER TABLE organization_users ADD CONSTRAINT organizations_organization_users FOREIGN KEY organizations_organization_users (organization_id)
    REFERENCES organizations (id);

-- Reference: permissions_user_permissions (table: user_permissions)
ALTER TABLE user_permissions ADD CONSTRAINT permissions_user_permissions FOREIGN KEY permissions_user_permissions (permission_id)
    REFERENCES permissions (id);

-- Reference: ticket_comments_tickets (table: ticket_comments)
ALTER TABLE ticket_comments ADD CONSTRAINT ticket_comments_tickets FOREIGN KEY ticket_comments_tickets (ticket_id)
    REFERENCES tickets (id);

-- Reference: ticket_comments_users (table: ticket_comments)
ALTER TABLE ticket_comments ADD CONSTRAINT ticket_comments_users FOREIGN KEY ticket_comments_users (author_id)
    REFERENCES users (id);

-- Reference: ticket_emails_tickets (table: ticket_emails)
ALTER TABLE ticket_emails ADD CONSTRAINT ticket_emails_tickets FOREIGN KEY ticket_emails_tickets (ticket_id)
    REFERENCES tickets (id);

-- Reference: ticket_history_statuses (table: ticket_history)
ALTER TABLE ticket_history ADD CONSTRAINT ticket_history_statuses FOREIGN KEY ticket_history_statuses (status_id)
    REFERENCES statuses (id);

-- Reference: ticket_history_tickets (table: ticket_history)
ALTER TABLE ticket_history ADD CONSTRAINT ticket_history_tickets FOREIGN KEY ticket_history_tickets (ticket_id)
    REFERENCES tickets (id);

-- Reference: ticket_history_users (table: ticket_history)
ALTER TABLE ticket_history ADD CONSTRAINT ticket_history_users FOREIGN KEY ticket_history_users (assignee_id)
    REFERENCES users (id);

-- Reference: tickets_users (table: tickets)
ALTER TABLE tickets ADD CONSTRAINT tickets_users FOREIGN KEY tickets_users (author_id)
    REFERENCES users (id);

-- Reference: users_organization_users (table: organization_users)
ALTER TABLE organization_users ADD CONSTRAINT users_organization_users FOREIGN KEY users_organization_users (user_id)
    REFERENCES users (id);

-- Reference: users_user_permissions (table: user_permissions)
ALTER TABLE user_permissions ADD CONSTRAINT users_user_permissions FOREIGN KEY users_user_permissions (user_id)
    REFERENCES users (id);

-- End of file.

