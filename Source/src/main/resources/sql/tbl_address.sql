DROP TABLE IF EXISTS db_sms.tbl_address;
CREATE TABLE db_sms.tbl_address
(
    id INT(9) NOT NULL DEFAULT 0,
    ken_id INT(2) DEFAULT NULL,
    city_id INT(5) DEFAULT NULL,
    town_id INT(9) DEFAULT NULL,
    zip VARCHAR(8) DEFAULT NULL,
    office_flg TINYINT(1) DEFAULT NULL,
    delete_flg TINYINT(1) DEFAULT NULL,
    ken_name VARCHAR(8) DEFAULT NULL,
    ken_furi VARCHAR(8) DEFAULT NULL,
    city_name VARCHAR(24) DEFAULT NULL,
    city_furi VARCHAR(24) DEFAULT NULL,
    town_name VARCHAR(32) DEFAULT NULL,
    town_furi VARCHAR(32) DEFAULT NULL,
    town_memo VARCHAR(16) DEFAULT NULL,
    kyoto_street VARCHAR(32) DEFAULT NULL,
    block_name VARCHAR(64) DEFAULT NULL,
    block_furi VARCHAR(64) DEFAULT NULL,
    memo VARCHAR(255) DEFAULT NULL,
    office_name VARCHAR(255) DEFAULT NULL,
    office_furi VARCHAR(255) DEFAULT NULL,
    office_address VARCHAR(255) DEFAULT NULL,
    new_id INT(11) DEFAULT NULL,
    PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '住所マスタテーブル';
