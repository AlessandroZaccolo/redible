CREATE TABLE meals (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100),
      price DOUBLE,
      quantity INT,
);

insert into meals (name, price, quantity) values
('Pasta', '2.3','2'),
('Pizza', '2.3','2'),
('Gnocchi', '2.3', '2');
