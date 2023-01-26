INSERT INTO cities(city_name, population, have_metro, country_name) VALUES('Moscow', 11980000, true, 'Russia');
INSERT INTO cities(city_name, population, have_metro, country_name) VALUES('Saint Petersburg', 5561000, true, 'Russia');
INSERT INTO cities(city_name, population, have_metro, country_name) VALUES('Kazan', 1308660, true, 'Russia');
INSERT INTO cities(city_name, population, have_metro, country_name) VALUES('Krasnoyarsk', 1067000, false , 'Russia');

INSERT INTO attractions(city_id, attraction_name, building_date, description, attr_type) VALUES(1, 'Red Square', '1991-12-25' , 'Is one of the oldest and largest squares in Moscow, the capital of Russia.', 'SQUARE');
INSERT INTO attractions(city_id, attraction_name, building_date, description, attr_type) VALUES(1, 'St. Basils Cathedral', '1991-12-25' , 'Great place for the first visit in Moscow, every tourist is obliged to visit this place at least once! From the outside, the building is very recognizable, so the photos will be credited', 'CATHEDRAL');