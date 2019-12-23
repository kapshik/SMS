DROP TABLE IF EXISTS db_sms.tbl_branch;
CREATE TABLE db_sms.tbl_branch
(
    customerNo VARCHAR(10) NOT NULL,
    branchNo VARCHAR(10) NOT NULL,
    branchName VARCHAR(50) NOT NULL,
    zipcode VARCHAR(10) NOT NULL,
    address VARCHAR(100) NOT NULL,
    addressDetail VARCHAR(100) NOT NULL,
    telNo VARCHAR(50) NOT NULL,
    faxNo VARCHAR(50) NOT NULL,
    PRIMARY KEY (customerNo, branchNo)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '支店情報テーブル';
