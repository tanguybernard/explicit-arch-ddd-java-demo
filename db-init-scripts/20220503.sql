-- Creation of freelancer table
CREATE TABLE IF NOT EXISTS freelancer (
   id SERIAL PRIMARY KEY,
   first_name varchar(250) NOT NULL,
   last_name varchar(250) NOT NULL
);

INSERT INTO freelancer ( first_name, last_name ) VALUES ( 'John', 'DoReMiFaSolLaSi' );
INSERT INTO freelancer ( first_name, last_name ) VALUES ( 'Boby', 'Dylan' );
