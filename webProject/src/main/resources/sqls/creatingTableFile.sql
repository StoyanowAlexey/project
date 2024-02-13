set search_path to myShema;
show search_path;
create table users
(
    id           bigserial primary key,
    email        varchar,
    password     varchar,
    name         varchar,
    age          integer,
    phone_number varchar,
    work         varchar
);
create schema "myShema"
