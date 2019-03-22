CREATE TABLE meals (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100),
      quantity INT,
      price DOUBLE
);

insert into meals (name, quantity, price) values
('Pasta', '2','2.4'),
('Pizza', '2','2.5'),
('Gnocchi', '2', '2.6');
