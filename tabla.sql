CREATE TABLE producto(
	id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
	precio INT NOT NULL,
    descripcion VARCHAR(300) NOT NULL
);