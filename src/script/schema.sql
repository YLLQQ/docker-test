create table weather
(
	city varchar(80),
	temp_lo integer,
	temp_hi integer,
	prcp real,
	date date,
	id serial not null
		constraint weather_pk
			primary key
);

alter table weather owner to postgres;

INSERT INTO public.weather (city, temp_lo, temp_hi, prcp, date, id) VALUES ('San Francisco', 46, 50, 0.25, '1994-11-27', 1);
INSERT INTO public.weather (city, temp_lo, temp_hi, prcp, date, id) VALUES ('San Francisco', 46, 50, 0.25, '1994-11-27', 2);
INSERT INTO public.weather (city, temp_lo, temp_hi, prcp, date, id) VALUES ('San Francisco', 46, 50, 0.25, '1994-11-27', 3);