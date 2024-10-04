CREATE TABLE booking (
    id SERIAL PRIMARY KEY,
    flight_number VARCHAR(50) NOT NULL,
    passenger_name VARCHAR(100) NOT NULL
);
