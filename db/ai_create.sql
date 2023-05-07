-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-05-07 09:54:16.709

-- tables
-- Table: ai_site
CREATE TABLE ai_site (
                         id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         company varchar(255)  NOT NULL,
                         description varchar(255)  NOT NULL,
                         link varchar(255)  NOT NULL,
                         type_id int  NOT NULL,
                         user_id int  NOT NULL,
                         status varchar(1)  NOT NULL,
                         created_at timestamp  NOT NULL,
                         updated_at timestamp  NULL,
                         CONSTRAINT ai_site_pk PRIMARY KEY (id)
);

-- Table: comment
CREATE TABLE comment (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         ai_site_id int  NOT NULL,
                         content varchar(255)  NOT NULL,
                         created_at timestamp  NOT NULL,
                         updated_at timestamp  NULL,
                         CONSTRAINT comment_pk PRIMARY KEY (id)
);

-- Table: evaluation
CREATE TABLE evaluation (
                            id serial  NOT NULL,
                            score int  NOT NULL,
                            comment varchar(1023)  NOT NULL,
                            user_id int  NOT NULL,
                            ai_sites_id int  NOT NULL,
                            created_at timestamp  NOT NULL,
                            updated_at timestamp  NULL,
                            CONSTRAINT evaluation_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture (
                         id serial  NOT NULL,
                         data bytea  NOT NULL,
                         ai_sites_id int  NOT NULL,
                         evaluation_id int  NOT NULL,
                         CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        username varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        points int  NOT NULL,
                        role_id int  NOT NULL,
                        status varchar(1)  NOT NULL,
                        email varchar(255)  NULL,
                        created_at timestamp  NOT NULL,
                        updated_at timestamp  NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: ai_sites_type (table: ai_site)
ALTER TABLE ai_site ADD CONSTRAINT ai_sites_type
    FOREIGN KEY (type_id)
        REFERENCES type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: ai_sites_user (table: ai_site)
ALTER TABLE ai_site ADD CONSTRAINT ai_sites_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: comment_ai_site (table: comment)
ALTER TABLE comment ADD CONSTRAINT comment_ai_site
    FOREIGN KEY (ai_site_id)
        REFERENCES ai_site (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: comment_user (table: comment)
ALTER TABLE comment ADD CONSTRAINT comment_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: evaluation_ai_sites (table: evaluation)
ALTER TABLE evaluation ADD CONSTRAINT evaluation_ai_sites
    FOREIGN KEY (ai_sites_id)
        REFERENCES ai_site (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: evaluation_user (table: evaluation)
ALTER TABLE evaluation ADD CONSTRAINT evaluation_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: picture_ai_sites (table: picture)
ALTER TABLE picture ADD CONSTRAINT picture_ai_sites
    FOREIGN KEY (ai_sites_id)
        REFERENCES ai_site (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: picture_evaluation (table: picture)
ALTER TABLE picture ADD CONSTRAINT picture_evaluation
    FOREIGN KEY (evaluation_id)
        REFERENCES evaluation (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

