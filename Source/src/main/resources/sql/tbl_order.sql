DROP TABLE IF EXISTS db_sms.tbl_order;
CREATE TABLE db_sms.tbl_order
(
    customerNo INT(11) NOT NULL,
    branchNo INT(11) NOT NULL,
    deliveryDestNo INT(11) NOT NULL,
    orderNo VARCHAR(50) NOT NULL,
    shippingLabelNo VARCHAR(50) DEFAULT NULL,
    estimationNo VARCHAR(50) DEFAULT NULL,
    memo VARCHAR(50) DEFAULT NULL,
    estimationDate DATE DEFAULT NULL,
    orderDate DATE NOT NULL,
    registrationDate DATE NOT NULL,
    shippingDate DATE DEFAULT NULL,
    deliveryDate DATE DEFAULT NULL,
    invoiceDate DATE DEFAULT NULL,
    requiredDate DATE DEFAULT NULL,
    status varchar(15) NOT NULL,
    PRIMARY KEY (customerNo, orderNo)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '注文情報テーブル';
