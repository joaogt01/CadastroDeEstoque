CREATE TABLE usuarios(
    id serial PRIMARY KEY,
    nome varchar(255) NOT NULL,
    usuario varchar(255) NOT NULL,
    senha varchar(255) NOT NULL
)