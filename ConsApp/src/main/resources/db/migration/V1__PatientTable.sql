CREATE TABLE public.patient (
    id serial NOT NULL,
    shortname text NOT NULL,
    gender text NOT NULL,
    CONSTRAINT gender_constraint CHECK (((gender = 'Female'::text) OR (gender = 'Male'::text)))
);

