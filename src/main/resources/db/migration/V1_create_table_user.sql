CREATE TABLE usuarios(
    id SERIAL PRIMARY KEY,
    nome varchar(255) NOT NULL,
    usuario varchar(255) NOT NULL,
    senha varchar(255) NOT NULL
);

CREATE TABLE estoque (
    id SERIAL PRIMARY KEY,
    localizacao VARCHAR(100) NOT NULL
);

CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE PRECISION NOT NULL,
    quantidade INT NOT NULL,
    estoque_id BIGINT REFERENCES estoque(id)
);

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE venda (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    total DOUBLE PRECISION,
    cliente_id BIGINT REFERENCES cliente(id)
);

CREATE TABLE venda_produto (
    venda_id BIGINT REFERENCES venda(id),
    produto_id BIGINT REFERENCES produto(id),
    PRIMARY KEY (venda_id, produto_id)
);