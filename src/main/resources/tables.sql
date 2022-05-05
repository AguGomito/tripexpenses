DROP TABLE IF EXISTS trips;
CREATE TABLE trips
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS trippers;
CREATE TABLE trippers
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    fk_trip_id INT NOT NULL,
    FOREIGN KEY (fk_trip_id) REFERENCES trips(id)
);

DROP TABLE IF EXISTS expenses;
CREATE TABLE expenses
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    detail VARCHAR(255) NOT NULL,
    amount DECIMAL NOT NULL,
    fk_paid_tripper INT NOT NULL,
    FOREIGN KEY (fk_paid_tripper) REFERENCES trippers(id)
);
