set search_path to myShema;
show search_path;
create table users
(
    id           bigint default nextval('my_shema.base_information_id_seq'::regclass) not null
        constraint base_information_pkey
            primary key,
    email        varchar,
    password     varchar,
    name         varchar,
    age          integer,
    phone_number varchar,
    work         varchar
);

create schema "myShema"
