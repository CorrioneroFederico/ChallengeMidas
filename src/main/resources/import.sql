INSERT INTO usuarios (username, password, email, rol) VALUES ('Lionel', '$2a$10$ocgbNtmsyMCm.LP/7vY2Y.eO8SsUKySmSQeeceG2Cl7QpMaD4kkK6', 'Lionelm@mail.com','ROLE_ADMIN');
INSERT INTO usuarios (username, password, email, rol) VALUES ('Lautaro', '$2a$10$ocgbNtmsyMCm.LP/7vY2Y.eO8SsUKySmSQeeceG2Cl7QpMaD4kkK6', 'Lautarom@mail.com','ROLE_CLIENTE');
INSERT INTO usuarios (username, password, email, rol) VALUES ('Nicolas', '$2a$10$ocgbNtmsyMCm.LP/7vY2Y.eO8SsUKySmSQeeceG2Cl7QpMaD4kkK6', 'Nicolasg@mail.com','ROLE_ADMIN');
INSERT INTO usuarios (username, password, email, rol) VALUES ('Sergio', '$2a$10$ocgbNtmsyMCm.LP/7vY2Y.eO8SsUKySmSQeeceG2Cl7QpMaD4kkK6', 'Sergioa@mail.com','ROLE_CLIENTE');
INSERT INTO usuarios (username, password, email, rol) VALUES ('Angel', '$2a$10$ocgbNtmsyMCm.LP/7vY2Y.eO8SsUKySmSQeeceG2Cl7QpMaD4kkK6', 'angelcc@mail.com','ROLE_ADMIN');
INSERT INTO usuarios (username, password, email, rol) VALUES ('Joaquin', '$2a$10$ocgbNtmsyMCm.LP/7vY2Y.eO8SsUKySmSQeeceG2Cl7QpMaD4kkK6', 'Joaquinc@mail.com','ROLE_CLIENTE');
INSERT INTO usuarios (username, password, email, rol) VALUES ('Julian', '$2a$10$ocgbNtmsyMCm.LP/7vY2Y.eO8SsUKySmSQeeceG2Cl7QpMaD4kkK6', 'Juliana@mail.com','ROLE_CLIENTE');
INSERT INTO usuarios (username, password, email, rol) VALUES ('admin', '$2a$10$ocgbNtmsyMCm.LP/7vY2Y.eO8SsUKySmSQeeceG2Cl7QpMaD4kkK6', 'admin@mail.com','ROLE_ADMIN');

INSERT INTO productos (nombre, descripcion, precio, disponible, fecha) VALUES ('TV Samsung', 'Smart TV 40 pulgadas', 400000, true, NOW());
INSERT INTO productos (nombre, descripcion, precio, disponible, fecha) VALUES ('Celular Samsung', 'S23 Ultra', 566000, true, NOW());
INSERT INTO productos (nombre, descripcion, precio, disponible, fecha) VALUES ('NoteBook Lenovo', '512 Gb disco, 16Gb ram ', 400000, false, NOW());

INSERT INTO carritos (descripcion, fecha, pedido_realizado, usuario_id) VALUES ('Sin descripcion', NOW(), true, 8)
INSERT INTO carrito_items (cantidad, carrito_id, producto_id) VALUES (2, 1, 1)

INSERT INTO carritos (descripcion, fecha, pedido_realizado, usuario_id) VALUES ('para Lionel Messi', NOW(), true, 1)
INSERT INTO carrito_items (cantidad, carrito_id, producto_id) VALUES (3, 2, 1)
INSERT INTO carrito_items (cantidad, carrito_id, producto_id) VALUES (1, 2, 2)
INSERT INTO carrito_items (cantidad, carrito_id, producto_id) VALUES (4, 2, 3)

INSERT INTO carritos (descripcion, fecha, pedido_realizado, usuario_id) VALUES ('para Lionel Messi', NOW(), true, 4)
INSERT INTO carrito_items (cantidad, carrito_id, producto_id) VALUES (5, 3, 1)
INSERT INTO carrito_items (cantidad, carrito_id, producto_id) VALUES (4, 3, 2)
INSERT INTO carrito_items (cantidad, carrito_id, producto_id) VALUES (4, 3, 3)