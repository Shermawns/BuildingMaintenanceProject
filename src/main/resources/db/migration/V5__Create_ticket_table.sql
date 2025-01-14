CREATE TABLE tb_ticket (
    ticket_id BIGSERIAL PRIMARY KEY,
    store_id BIGINT REFERENCES tb_store (id) ON DELETE SET NULL,
    trilogger_id BIGINT REFERENCES tb_trilogger (id) ON DELETE SET NULL,
    provider_id BIGINT REFERENCES tb_provider (id) ON DELETE SET NULL,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(200) NOT NULL,
    service VARCHAR(50) NOT NULL,
    status VARCHAR(50) DEFAULT 'OPEN',
    priority VARCHAR(50) DEFAULT 'LOW',
    created_date DATE DEFAULT CURRENT_DATE,
    deadline DATE
);
