DROP TABLE IF EXISTS db_sms.tbl_customer;
CREATE TABLE db_sms.tbl_customer
(
    customerNo VARCHAR(10) NOT NULL,
    customerName VARCHAR(50) NOT NULL,
    zipcode VARCHAR(10) NOT NULL,
    address VARCHAR(100) NOT NULL,
    addressDetail VARCHAR(100) NOT NULL,
    telNo VARCHAR(50) NOT NULL,
    faxNo VARCHAR(50) NOT NULL,
    startDate DATE NOT NULL,
    paymentTerms VARCHAR(50) NOT NULL,
    PRIMARY KEY (customerNo)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '顧客情報テーブル';
