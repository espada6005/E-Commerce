INSERT INTO category (name) VALUES ('Tabs');
INSERT INTO category (name) VALUES ('Electronics');
INSERT INTO category (name) VALUES ('Gadgets');

INSERT INTO product (name, brand, price, inventory, description, category_id) VALUES 
('iPad 3 Pro', 'Samsung', 550.00, 10, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia', 1),
('iPad 5 Pro', 'Samsung', 550.00, 10, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia', 1),
('iPad 5 Pro', 'Apple', 540.00, 10, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia', 1),
('iPad 5 Pro', 'LG', 200.00, 10, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia', 1),
('iPad 6 Pro', 'LG', 200.00, 10, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia', 1),
('iPad 6 Pro', 'Apple', 200.00, 10, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia', 1),
('Smart TV', 'Dell', 2500.00, 6, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia', 2),
('Smart Watch', 'Apple', 2500.00, 12, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia', 3);

INSERT INTO user (email, password, first_name, last_name) VALUES 
('john@email.com', '$2a$10$GRUFTTTz35yu2OsEjyAKw.QlZgM2MBeP6WlyyqsUzk06atdD2/qq.', 'john', 'smith');