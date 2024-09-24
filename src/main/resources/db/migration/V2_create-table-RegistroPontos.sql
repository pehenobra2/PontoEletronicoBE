CREATE TABLE pontos (
    id BIGINT PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    foto VARCHAR(255),
    funcionario_id BIGINT,
    CONSTRAINT fk_funcionario
        FOREIGN KEY (funcionario_id)
        REFERENCES usuario (id)
);