CREATE USER event_sourcing_user WITH PASSWORD '1234567';
CREATE DATABASE event_sourcing_db;
GRANT ALL PRIVILEGES ON DATABASE event_sourcing_db to event_sourcing_user;