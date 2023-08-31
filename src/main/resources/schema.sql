CREATE TABLE IF NOT EXISTS flights
(
    flight_number  VARCHAR(255) PRIMARY KEY,
    origin         VARCHAR(255),
    destination    VARCHAR(255),
    departure_time TIME,
    arrival_time   TIME,
    price          DECIMAL
);
