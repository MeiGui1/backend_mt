CREATE TABLE Patient (
    id serial PRIMARY KEY,
    shortname text NOT NULL,
    gender text NOT NULL,
    CONSTRAINT gender_constraint CHECK (((gender = 'Female'::text) OR (gender = 'Male'::text)))
);

insert into Patient (shortname, gender) values ('Fonsie Janks', 'Male');
insert into Patient (shortname, gender) values ('Clyde Le Moucheux', 'Male');
insert into Patient (shortname, gender) values ('Celestina Hudel', 'Female');
insert into Patient (shortname, gender) values ('Tansy Sweatman', 'Female');
insert into Patient (shortname, gender) values ('Ellissa Matzke', 'Female');
insert into Patient (shortname, gender) values ('Floria MacGilmartin', 'Female');
insert into Patient (shortname, gender) values ('Susann Blamey', 'Female');
insert into Patient (shortname, gender) values ('Erny Cauldfield', 'Male');
insert into Patient (shortname, gender) values ('Kylila Clail', 'Female');
insert into Patient (shortname, gender) values ('Raven Cricket', 'Female');
insert into Patient (shortname, gender) values ('Walt Duplan', 'Male');
insert into Patient (shortname, gender) values ('Jaquenette Sleicht', 'Female');
insert into Patient (shortname, gender) values ('Emanuel Sparshutt', 'Male');
insert into Patient (shortname, gender) values ('Adrianne Hynson', 'Female');
insert into Patient (shortname, gender) values ('Donalt Riggs', 'Male');
insert into Patient (shortname, gender) values ('Andros Randles', 'Male');
insert into Patient (shortname, gender) values ('Germain Seamarke', 'Male');
insert into Patient (shortname, gender) values ('Percival Fleetwood', 'Male');
insert into Patient (shortname, gender) values ('Garreth Marsy', 'Male');
insert into Patient (shortname, gender) values ('Clayborne Fuke', 'Male');