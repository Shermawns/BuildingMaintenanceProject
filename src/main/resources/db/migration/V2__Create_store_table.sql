CREATE TABLE tb_store (
    id BIGINT PRIMARY KEY REFERENCES tb_user (id) ON DELETE CASCADE,
    cnpj VARCHAR(100) NOT NULL UNIQUE
);
