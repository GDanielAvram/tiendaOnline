
insert into CLIENTE (NOMBRE, APELLIDOS,EMAIL, NOMBREUSUARIO, PASSWORD, FECHANACIMIENTO, DIRECCIONENVIO, BANCO, NUMEROTARJETA, TITULAR, CODIGOSEGURIDAD, DIRECCIONFACTURACION) values ('Marcos', 'Puente', 'marcos.puente@gmail.com', 'marcos.puente','$2a$10$M9f2gMMe.uAoaYoSekvimO5Tr0k84patlTvqH3sfgAq2sohZyYGLC', '19-9-1992', 'Calle Claret', 'Santander', '7687656876546776', 'Marcos Puente', '1234', 'Madrid');
insert into CLIENTE (NOMBRE, APELLIDOS,EMAIL, NOMBREUSUARIO, PASSWORD, FECHANACIMIENTO, DIRECCIONENVIO, BANCO, NUMEROTARJETA, TITULAR, CODIGOSEGURIDAD, DIRECCIONFACTURACION) values ('Daniel', 'Avram', 'daniel.avram@gmail.com', 'dani','$2a$10$R2YSXVFFXESuP/N/FMRUe.q61c6tQ6vYqfh2irb9ZhBvezASZI6Fy', '16-02-2000', 'Calle Pedriza', 'La Caixa', '21341233421', 'Daniel Avram', '1234', 'Madrid');
insert into CLIENTE (NOMBRE, APELLIDOS,EMAIL, NOMBREUSUARIO, PASSWORD, FECHANACIMIENTO, DIRECCIONENVIO, BANCO, NUMEROTARJETA, TITULAR, CODIGOSEGURIDAD, DIRECCIONFACTURACION) values ('user', 'user', 'user@gmail.com','user', '$2a$10$1/HtE5/jvlSolOL6sTUna.RW059oCXK00DetE0XKG127eY5sIT8Wa', '01-01-2000', 'Calle Uno', 'Bankia', '0000000000000000', 'user', '0000', 'Madrid');
 																														
insert into PRODUCTO (NOMBREPRODUCTO, PRECIO, STOCK) values ('Teclado', 9, 604);
insert into PRODUCTO (NOMBREPRODUCTO, PRECIO, STOCK) values ('Monitor', 119, 40);

insert into ROL (NOMBREROL) values ('ROL_ADMIN');
insert into ROL (NOMBREROL) values ('ROL_CLIENTE');

insert into CLIENTE_ROL (IDROL, IDCLIENTE) values (2, 1);
insert into CLIENTE_ROL (IDROL, IDCLIENTE) values (1, 2);
insert into CLIENTE_ROL (IDROL, IDCLIENTE) values (3, 2);
