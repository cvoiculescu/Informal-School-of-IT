drop database booking;
create database booking;
use booking;
create table accommodation
(
    id          int not null auto_increment,
    type        varchar(32),
    bed_type    varchar(32),
    max_guests  int,
    description varchar(512),
    primary key (id)
);
create table room_fair
(
    id     int not null auto_increment,
    value  double,
    season varchar(32),
    primary key (id)
);
create table accommodation_fair_relation
(
    id               int not null auto_increment,
    id_accommodation int,
    id_room_fair     int,
    primary key (id),
    foreign key (id_accommodation) references accommodation (id),
    foreign key (id_room_fair) references room_fair (id)
);
select *
from accommodation;
select *
from room_fair;
select *
from accommodation_fair_relation;
# following statement is to show all combined fields with relations
select *
from accommodation a,
     room_fair rf,
     accommodation_fair_relation afr
where a.id = afr.id_accommodation
  AND rf.id = afr.id_room_fair;