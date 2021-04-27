DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM dishes;
ALTER SEQUENCE global_seq RESTART 100000;

INSERT INTO users(name, email, password)
VALUES ('User', 'user@gmail.com', 'password' ),
       ('Admin', 'admin@gmail.com', 'admin' );

INSERT INTO user_roles (user_id, role)
VALUES (100000, 'ADMIN'),
       (100001, 'USER');

INSERT INTO dishes(name, price)
VALUES ('Котлета по киевски', 15000),
       ('Кролик в сметанном соусе', 30000),
       ('Салат греческий', 10000);