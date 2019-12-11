DROP TABLE IF EXISTS db_sms.tbl_deliverydest;
CREATE TABLE db_sms.tbl_deliverydest
(
    deliveryDestNo INT(11) ZEROFILL AUTO_INCREMENT,
    branchNo INT(11) NOT NULL,
    customerNo INT(11) NOT NULL,
    deliveryDestName VARCHAR(50) NOT NULL,
    zipcode VARCHAR(10) NOT NULL,
    address VARCHAR(100) NOT NULL,
    addressDetail VARCHAR(100) NOT NULL,
    telNo VARCHAR(50) NOT NULL,
    faxNo VARCHAR(50) NOT NULL,
    PRIMARY KEY (deliveryDestNo, customerNo, branchNo)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '納品先情報テーブル';
