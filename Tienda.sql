CREATE DATABASE TIENDA;
USE TIENDA;

CREATE TABLE IF NOT EXISTS USUARIOS(
    USUARIO VARCHAR(50) PRIMARY KEY,
    PASS VARCHAR(50),
    ROL BOOLEAN,
    VENDEDOR INT
);
INSERT INTO USUARIOS VALUES('ADMIN','ADMIN',1,0);
INSERT INTO USUARIOS VALUES('HECTOR','HECTOR',0,1);

CREATE TABLE IF NOT EXISTS SUCURSALES(
    CODIGO INT PRIMARY KEY,
    NOMBRE VARCHAR(100),
    DIRECCION VARCHAR(50),
    CORREO VARCHAR(50),
    TELEFONO INT
);

INSERT INTO SUCURSALES VALUES(1,'SUCURSAL1','1AV','SUCURSAL1@CORREO',1)
INSERT INTO SUCURSALES VALUES(2,'SUCURSAL2','2AV','SUCURSAL2@CORREO',2)
INSERT INTO SUCURSALES VALUES(3,'SUCURSAL3','3AV','SUCURSAL3@CORREO',3)

CREATE TABLE IF NOT EXISTS PRODUCTOS(
    CODIGO INT PRIMARY KEY,
    NOMBRE VARCHAR(100),
    DESCRIPCION VARCHAR(100),
    CANTIDAD INT,
    PRECIO DOUBLE
);

INSERT INTO PRODUCTOS VALUES(1,'PRODUCTO1','PRODUCTO1',1,1)
INSERT INTO PRODUCTOS VALUES(2,'PRODUCTO2','PRODUCTO2',2,2)
INSERT INTO PRODUCTOS VALUES(3,'PRODUCTO3','PRODUCTO3',3,3)

CREATE TABLE IF NOT EXISTS CLIENTES(
    CODIGO INT PRIMARY KEY,
    NOMBRE VARCHAR(100),
    NIT INT,
    CORREO VARCHAR(50),
    GENERO VARCHAR(1)
);

INSERT INTO CLIENTES VALUES(1,'CLIENTE1',11111111,'CLIENTE1@CORREO','M')
INSERT INTO CLIENTES VALUES(2,'CLIENTE2',11111112,'CLIENTE2@CORREO','M')
INSERT INTO CLIENTES VALUES(3,'CLIENTE3',11111113,'CLIENTE3@CORREO','F')

CREATE TABLE IF NOT EXISTS VENDEDORES(
    CODIGO INT PRIMARY KEY,
    NOMBRE VARCHAR(100),
    CAJA INT,
    VENTAS INT,
    GENERO VARCHAR(1)
);

INSERT INTO VENDEDORES VALUES(1,'VENDEDOR1',1,1,'M')
INSERT INTO VENDEDORES VALUES(2,'VENDEDOR2',2,2,'M')
INSERT INTO VENDEDORES VALUES(3,'VENDEDOR3',3,3,'F')

CREATE TABLE IF NOT EXISTS FACTURAS(
    CODIGO INT PRIMARY KEY,
    CLIENTE INT,
    VENDEDOR INT,
    FECHA VARCHAR(11),
    TOTAL DOUBLE,
    FOREIGN KEY(VENDEDOR) REFERENCES VENDEDORES(CODIGO)
);

CREATE TABLE IF NOT EXISTS DETALLEFACTURAS(
    CODIGOFACTURA INT,
    CODIGO INT,
    CODIGOPRODUCTO INT,
    CANTIDAD INT,
    FOREIGN KEY(CODIGOFACTURA) REFERENCES FACTURAS(CODIGO),
    FOREIGN KEY(CODIGOPRODUCTO) REFERENCES PRODUCTOS(CODIGO)
);