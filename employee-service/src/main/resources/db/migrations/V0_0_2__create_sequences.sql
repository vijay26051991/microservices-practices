-- Engine : Postgres
-- Author : vijaykumar.s
-- Date : 26/05/2020

--
CREATE SEQUENCE dept_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE dept_id_seq
    OWNER TO postgres;


CREATE SEQUENCE id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE id_seq
    OWNER TO postgres;



