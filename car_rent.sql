CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create type fuel_type_enum as ENUM('Petrol', 'Diesel', 'Electric', 'Hybrid');
create type transmission_enum as ENUM ('Manual', 'Automatic');
create type body_type_enum as ENUM ('Sedan', 'SUV', 'Hatchback', 'Coupe', 'Convertible');

create table car(
	id UUID primary key DEFAULT uuid_generate_v4(),
	name varchar(255),
	brand varchar(255),
	model varchar(255),
	year int,
	color varchar(55),
	fuel_type fuel_type_enum,
	transmission transmission_enum,
	body_type body_type_enum,
	mileage varchar(55),
	price DOUBLE PRECISION,
	airbags int
);

create table car_images(
	id UUId primary key DEFAULT uuid_generate_v4(),
	image_url text,
	car_id UUID,
	FOREIGN KEY (car_id) REFERENCES car(id)
);

INSERT INTO car (name, brand, model, year, color, fuel_type, transmission, body_type, mileage, price, airbags) 
VALUES ('Model S', 'Tesla', 'Long Range', 2023, 'White', 'Electric', 'Automatic', 'Sedan', '500 km', 79999.99, 6);

select * from car;

INSERT INTO car_images (image_url, car_id) 
VALUES ('https://imgd.aeplcdn.com/664x374/n/cw/ec/37138/model-3-exterior-right-front-three-quarter.jpeg', 'e4bf0d84-9bf4-42dc-97d2-0c31966994eb');


INSERT INTO car_images (image_url, car_id) 
VALUES ('https://imgd.aeplcdn.com/664x374/n/cw/ec/37138/model-3-exterior-left-front-three-quarter.jpeg', 'e4bf0d84-9bf4-42dc-97d2-0c31966994eb');


select * from car_images where car_id = 'e4bf0d84-9bf4-42dc-97d2-0c31966994eb';

select * from car_images;

delete from car_images where car_id = '3b4a2d5a-9e3b-4aa7-bb10-98aca56fea3a';
delete from car where id = '3b4a2d5a-9e3b-4aa7-bb10-98aca56fea3a';