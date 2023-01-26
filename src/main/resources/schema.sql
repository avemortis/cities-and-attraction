drop TABLE IF EXISTS cities;
create table cities(
    city_id serial primary key,
    city_name VARCHAR(255),
    population integer,
    have_metro boolean,
    country_name varchar(255));

DROP TYPE IF EXISTS attraction_type CASCADE;
CREATE TYPE attraction_type AS ENUM ('MUSEUM', 'CATHEDRAL', 'GALLERY', 'SQUARE');

drop TABLE IF EXISTS attractions;
create table attractions(
    attraction_id serial primary key,
    city_id int not null,
    attraction_name VARCHAR(255),
    building_date date,
    description varchar(255),
    attr_type attraction_type
    );