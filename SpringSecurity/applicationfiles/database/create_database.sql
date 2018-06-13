--psql -U postgre: access root account postgre
CREATE USER springexample WITH PASSWORD '123456';
CREATE DATABASE springexample OWNER springexample ENCODING = 'UTF8';
--psql -U emer -d emer (pass: 123456)
CREATE SCHEMA springexample;