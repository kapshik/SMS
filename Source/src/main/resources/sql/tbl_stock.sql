DROP TABLE IF EXISTS db_sms.tbl_stock;
CREATE TABLE db_sms.tbl_stock
(
    productCode VARCHAR(50) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    quantityPerBox INT DEFAULT 0,
    quantityOfBox INT DEFAULT 0,
    inStockDate DATE DEFAULT NULL,
    inStockQuantity INT DEFAULT 0,
    PRIMARY KEY (productCode)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '在庫情報テーブル';
