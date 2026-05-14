CREATE TABLE IF NOT EXISTS product (
    id          BIGSERIAL,
    name        VARCHAR(255)    NOT NULL,
    description TEXT,
     price       INT    NOT NULL DEFAULT 0,  -- ✅ 추가

    status      VARCHAR(255)    NOT NULL DEFAULT 'AVAILABLE',
    created_at  TIMESTAMP   NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP,

    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE INDEX idx_product_created_at ON product (created_at DESC);

COMMENT ON TABLE product IS '상품';
COMMENT ON COLUMN product.name          IS '상품명';
COMMENT ON COLUMN product.description   IS '상품 설명';
COMMENT ON COLUMN product.status        IS '상태';
COMMENT ON COLUMN product.created_at    IS '생성일';
COMMENT ON COLUMN product.updated_at    IS '마지막 수정일';