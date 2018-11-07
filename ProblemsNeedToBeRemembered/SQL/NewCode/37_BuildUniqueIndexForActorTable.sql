/* 题目描述
针对如下表actor结构创建索引：
CREATE TABLE IF NOT EXISTS actor (
actor_id smallint(5) NOT NULL PRIMARY KEY,
first_name varchar(45) NOT NULL,
last_name varchar(45) NOT NULL,
last_update timestamp NOT NULL DEFAULT (datetime('now','localtime')))

对first_name创建唯一索引uniq_idx_firstname，对last_name创建普通索引idx_lastname */

CREATE UNIQUE INDEX  uniq_idx_firstname ON actor(first_name);
CREATE INDEX idx_lastname ON actor(last_name);
