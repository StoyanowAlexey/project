alter table my_shema.base_information
    rename column column_name to id;
alter table my_shema.base_information
    add column_name bigserial primary key ;
insert into base_information (email,password) values ('bestg202@gmail.com','rapunchel');
set search_path to myShema;
show search_path;
create table "base_information"(email varchar, password varchar);
create schema "myShema"
