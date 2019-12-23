DROP TABLE IF EXISTS db_sms.tbl_orderdetail;
CREATE TABLE db_sms.tbl_orderdetail
(
    customerNo VARCHAR(10) NOT NULL,
    orderNo VARCHAR(50) NOT NULL,
    productCode VARCHAR(50) NOT NULL,
    quantityOrdered INT NOT NULL,
    priceOrdered INT NOT NULL,
    PRIMARY KEY (customerNo, orderNo, productCode)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '注文詳細(商品)情報テーブル';
