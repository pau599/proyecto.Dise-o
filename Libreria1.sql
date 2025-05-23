CREATE DATABASE IF NOT EXISTS organizadorlibros;
USE organizadorlibros;

CREATE TABLE IF NOT EXISTS usuario (
    usuarioId INT AUTO_INCREMENT PRIMARY KEY,
    nombreUsuario VARCHAR(50) NOT NULL UNIQUE,
    correo VARCHAR(100) NOT NULL,
    contraseña VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS libros (
    IdLibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(100),
    año INT,
    genero VARCHAR(50),
    fechaLectura DATE,
    usuarioId INT,
    CONSTRAINT fk_usuario FOREIGN KEY (usuarioId) REFERENCES usuario(usuarioId)
);

CREATE TABLE Favoritos (
    idFavorito INT AUTO_INCREMENT PRIMARY KEY,
    usuarioId INT NOT NULL,
    libroId INT NOT NULL,
    fechaAgregado DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_favorito_usuario FOREIGN KEY (usuarioId) REFERENCES usuario(usuarioId),
    CONSTRAINT fk_favorito_libro FOREIGN KEY (libroId) REFERENCES libros(IdLibro)
);


	

DESCRIBE usuario;

DESCRIBE libros;

ALTER TABLE libros ADD COLUMN usuarioId INT;
