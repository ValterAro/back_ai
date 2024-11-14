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
                         pricing_type varchar(10)  NOT NULL, -- Added pricing type (free, freemium, paid)
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

-- Table: evaluation_feedback (New table for thumbs up/down)
CREATE TABLE evaluation_feedback (
                                     id serial  NOT NULL,
                                     user_id int  NOT NULL,
                                     evaluation_id int  NOT NULL,
                                     feedback boolean  NOT NULL, -- true for thumbs up, false for thumbs down
                                     created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                     CONSTRAINT evaluation_feedback_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture (
                         id serial  NOT NULL,
                         data bytea  NOT NULL,
                         ai_sites_id int  NULL,
                         evaluation_id int  NULL,
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

-- Table: user_story (New table for user stories)
CREATE TABLE user_story (
                            id serial  NOT NULL,
                            user_id int  NOT NULL,
                            ai_site_id int  NOT NULL,
                            review_score int  NOT NULL,
                            experience text  NOT NULL,
                            created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                            updated_at timestamp  NULL,
                            CONSTRAINT user_story_pk PRIMARY KEY (id)
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

-- Reference: evaluation_feedback_user (table: evaluation_feedback)
ALTER TABLE evaluation_feedback ADD CONSTRAINT evaluation_feedback_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: evaluation_feedback_evaluation (table: evaluation_feedback)
ALTER TABLE evaluation_feedback ADD CONSTRAINT evaluation_feedback_evaluation
    FOREIGN KEY (evaluation_id)
        REFERENCES evaluation (id)
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

-- Reference: user_story_user (table: user_story)
ALTER TABLE user_story ADD CONSTRAINT user_story_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_story_ai_site (table: user_story)
ALTER TABLE user_story ADD CONSTRAINT user_story_ai_site
    FOREIGN KEY (ai_site_id)
        REFERENCES ai_site (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.
