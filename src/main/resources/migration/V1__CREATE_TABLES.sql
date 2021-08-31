create table hibernate_sequence (
    next_val bigint
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE dish_category_entity (
    id BIGSERIAL,
    title varchar(64) not null,
    PRIMARY KEY (id)
);

CREATE TABLE product_category_entity (
    id BIGSERIAL,
    title varchar(64) not null,
    PRIMARY KEY (id)
);

CREATE TABLE product_entity (
    id BIGSERIAL,
    title varchar(64) not null,
    PRIMARY KEY (id)
);

CREATE TABLE dish_entity (
    id BIGSERIAL,
    title varchar(64) not null,
    PRIMARY KEY (id)
);

CREATE TABLE recipes
(
    id BIGSERIAL,
    product_id bigint NOT NULL,
    dish_id bigint NOT NULL,
    quantity character varying NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT produck_id_fk FOREIGN KEY (product_id)
        REFERENCES product_entity (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT dish_id_fk FOREIGN KEY (dish_id)
        REFERENCES dish_entity (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
