CREATE TABLE empleados (
	id int NOT NULL primary key auto_increment,
	nombre varchar(100) NOT NULL,
	faena varchar(100) NOT NULL,
	salario double NOT NULL
);

--
-- Datos tabla
--

INSERT INTO empleados (id,nombre,faena,salario) VALUES
(1,'pepe','PEON',1500),
(2,'laura','PEON',1500),
(3,'francisco','JEFE',1800),
(4,'eva','JEFE',1500);