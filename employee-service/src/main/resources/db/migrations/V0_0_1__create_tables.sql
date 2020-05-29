-- Engine : Postgres
-- Author : vijaykumar.s
-- Date : 25/05/2020

--DROP SCHEMA IF EXISTS employee;

CREATE TABLE employee_info(emp_id bigint,
      first_name character varying,
      last_name character varying,
      middle_name character varying,
      designation character varying,
      email character varying,
      mobile character varying,
      date_of_joining date,
      created_date date,
      modified_date date,
      date_of_exit date,
      PRIMARY KEY (emp_id));

ALTER TABLE employee_info
    OWNER to postgres;

CREATE TABLE department_info
(
    dept_id character varying NOT NULL,
    dept_name character varying NOT NULL,
    dept_head character varying NOT NULL,
    PRIMARY KEY (dept_id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE department_info
    OWNER to postgres;



CREATE TABLE emp_dep_map
(
    emp_id bigint NOT NULL,
    CONSTRAINT emp_id_fk FOREIGN KEY (emp_id)
        REFERENCES employee_info (emp_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE emp_dep_map
    OWNER to postgres;