DROP TABLE IF EXISTS heroes;

CREATE TABLE heroes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    alias VARCHAR(50) NOT NULL,
    superPower VARCHAR(70) NOT NULL,
    teamID INT NOT NULL
);