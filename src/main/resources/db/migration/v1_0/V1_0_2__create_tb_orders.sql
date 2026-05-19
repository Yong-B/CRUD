CREATE TABLE IF NOT EXISTS orders(
    id          BIGSERIAL,
    product_id  BIGINT       NOT NULL,

    created_at  TIMESTAMP    DEFAULT NOW(),
    updated_at  TIMESTAMP,

    CONSTRAINT pk_orders PRIMARY KEY (id),
    CONSTRAINT fk_orders_product
        FOREIGN KEY (product_id)
        REFERENCES product(id)
);
