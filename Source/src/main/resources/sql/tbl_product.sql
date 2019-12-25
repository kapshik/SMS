DROP TABLE IF EXISTS db_sms.tbl_product;
CREATE TABLE db_sms.tbl_product
(
    productCode VARCHAR(50) NOT NULL,
    productName VARCHAR(50) NOT NULL,
    unitPrice INT DEFAULT NULL,
    productType VARCHAR(50) DEFAULT NULL,
    unitType VARCHAR(50) DEFAULT NULL,
    remarks TEXT DEFAULT NULL,
    PRIMARY KEY (productCode)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '商品情報テーブル';
