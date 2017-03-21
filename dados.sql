CREATE DATABASE clientes;

USE clientes;

-- Clientes
CREATE TABLE cliente(
	id INTEGER NOT NULL,
    nome VARCHAR(50) NOT NULL,
    fone CHAR(10) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

SELECT * FROM cliente;