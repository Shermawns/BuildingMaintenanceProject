CREATE TABLE tb_trilogger (
    id BIGINT PRIMARY KEY REFERENCES tb_user (id) ON DELETE CASCADE
);
