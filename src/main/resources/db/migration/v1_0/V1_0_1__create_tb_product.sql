CREATE TABLE IF NOT EXISTS product(
    id          BIGSERIAL,
    name        VARCHAR(255),
    description TEXT,

    status      VARCHAR(255),
    created_at  TIMESTAMP       DEFAULT NOW(),
    updated_at  TIMESTAMP,

    CONSTRAINT pk_product PRIMARY KEY (id)
);

-- 테이블 코멘트
COMMENT ON TABLE product IS '상품';

-- 컬럼 코멘트
COMMENT ON COLUMN product.name          IS '상품명';
COMMENT ON COLUMN product.description   IS '상품 설명';
COMMENT ON COLUMN product.status        IS '상태';
COMMENT ON COLUMN product.created_at    IS '생성일';
COMMENT ON COLUMN product.updated_at    IS '마지막 수정일';