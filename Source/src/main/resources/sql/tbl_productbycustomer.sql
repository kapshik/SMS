DROP TABLE IF EXISTS db_sms.tbl_productByCustomer;
CREATE TABLE db_sms.tbl_productByCustomer
(
    customerNo VARCHAR(10) NOT NULL,
    productCode VARCHAR(50) NOT NULL,
    discountPrice INT DEFAULT NULL,
    PRIMARY KEY (customerNo, productCode)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '顧客別商品情報テーブル';
