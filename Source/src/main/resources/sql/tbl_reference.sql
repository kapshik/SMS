DROP TABLE IF EXISTS db_sms.tbl_reference;
CREATE TABLE db_sms.tbl_reference
(
    type VARCHAR(50) NOT NULL,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (type, code)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'リファレンス情報テーブル';

INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "PRODUCT_TYPE", "PT_001", "送料別");
INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "PRODUCT_TYPE", "PT_002", "送料込");
INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "PRODUCT_TYPE", "PT_003", "その他");

INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "UNIT_TYPE", "UT_001", "本");
INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "UNIT_TYPE", "UT_002", "丁");
INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "UNIT_TYPE", "UT_003", "個");
INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "UNIT_TYPE", "UT_004", "BOX");

INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "PAYMENT_TERMS", "TM_001", "月末締め翌月末支払い");
INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "PAYMENT_TERMS", "TM_002", "月末締め翌月25日手形支払い");
INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "PAYMENT_TERMS", "TM_003", "月末締め翌々月10日支払い");
INSERT INTO db_sms.tbl_reference(type, code, name) VALUES( "PAYMENT_TERMS", "TM_004", "25日締め翌月末支払い");
