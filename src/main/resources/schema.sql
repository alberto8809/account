CREATE TABLE IF NOT EXISTS account (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       amount DOUBLE NOT NULL CHECK (amount > 1 AND amount < 999999),
                                       terms INT NOT NULL CHECK (terms >= 4 AND terms <= 52),
                                       rate DOUBLE NOT NULL CHECK (rate > 0 AND rate < 1)
);

CREATE TABLE IF NOT EXISTS payment (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       account_id INT NOT NULL,
                                       payment_number INT NOT NULL,
                                       amount DOUBLE NOT NULL,
                                       payment_date DATE NOT NULL,
                                       FOREIGN KEY (account_id) REFERENCES account (id)
);
