DROP TABLE IF EXISTS db_sms.tbl_product;
CREATE TABLE db_sms.tbl_product
(
    productCode VARCHAR(50) NOT NULL,
    productName VARCHAR(50) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    quantityPerBox INT DEFAULT NULL,
    quantityOfBox INT DEFAULT NULL,
    buyPrice INT DEFAULT NULL,
    unitPrice INT DEFAULT NULL,
    productType VARCHAR(50) DEFAULT NULL,
    unitType VARCHAR(50) DEFAULT NULL,
    remarks TEXT DEFAULT NULL,
    scheduledInStockDate DATE DEFAULT NULL,
    quantityInStock INT DEFAULT 0,
    PRIMARY KEY (productCode)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '商品情報テーブル';
