
--Create Schema (Schema is a logical namespace that contains database objects such as tables, views, indexes, etc. )

CREATE SCHEMA freelancer_management;

-- Creation of freelancer table
CREATE TABLE IF NOT EXISTS freelancer_management.freelancer (
   id SERIAL PRIMARY KEY,
   first_name varchar(250) NOT NULL,
   last_name varchar(250) NOT NULL
);

INSERT INTO freelancer_management.freelancer ( first_name, last_name ) VALUES ( 'John', 'DoReMiFaSolLaSi' );
INSERT INTO freelancer_management.freelancer ( first_name, last_name ) VALUES ( 'Boby', 'Dylan' );


CREATE SCHEMA project_management;

CREATE TABLE IF NOT EXISTS project_management.project (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    project_name varchar(250) NOT NULL
);

INSERT INTO project_management.project ( customer_id, project_name ) VALUES ( 1, 'EDF' );


CREATE SCHEMA customer_management;


-- Create DB test

CREATE DATABASE test;
\c test;

CREATE SCHEMA freelancer_management;

-- Creation of freelancer table
CREATE TABLE IF NOT EXISTS freelancer_management.freelancer (
    id SERIAL PRIMARY KEY,
    first_name varchar(250) NOT NULL,
    last_name varchar(250) NOT NULL
    );

CREATE SCHEMA project_management;

CREATE TABLE IF NOT EXISTS project_management.project (
  id SERIAL PRIMARY KEY,
  customer_id INTEGER NOT NULL,
  project_name varchar(250) NOT NULL
    );
