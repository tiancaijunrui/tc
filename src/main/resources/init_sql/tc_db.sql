DROP TABLE IF EXISTS  t_tc_user ;
CREATE TABLE t_tc_user (
  user_id VARCHAR (32) PRIMARY KEY,
  ali_user_id VARCHAR (30) NOT NULL UNIQUE,
  nick_name VARCHAR (50) ,
  email VARCHAR (50),
  phone VARCHAR (20),
  age int,
  birthday TIMESTAMP (5),
  avatar VARCHAR(1000),
  create_by VARCHAR (32) NOT NULL,
  create_time TIMESTAMP (6) NOT NULL,
  update_by VARCHAR (32) NOT NULL,
  update_time TIMESTAMP (6) NOT NULL
);

CREATE INDEX i_tc_user_login_name ON t_tc_user (ali_user_id);
CREATE INDEX i_tc_user_phone ON t_tc_user (phone);

CREATE TABLE t_tc_account (
  account_id VARCHAR(32) PRIMARY key,
  user_id VARCHAR (32) not null,
  corp_id VARCHAR(32) not null,
  login_name VARCHAR(50) not null,
  password VARCHAR(50) not null,
  phone VARCHAR(20),
  email varchar(50),
  encrypted_answers_one VARCHAR(100),
  encrypted_answers_two VARCHAR(100),
  encrypted_answers_three VARCHAR(100),
  encrypted_answers_four VARCHAR(100),
  create_by VARCHAR (32) NOT NULL,
  create_time TIMESTAMP (6) NOT NULL,
  update_by VARCHAR (32) NOT NULL,
  update_time TIMESTAMP (6) NOT NULL
);

CREATE TABLE t_tc_corp_code (
  corp_id VARCHAR(32) PRIMARY key,
  corp_code VARCHAR (100) not null,
  create_by VARCHAR (32) NOT NULL,
  create_time TIMESTAMP (6) NOT NULL,
  update_by VARCHAR (32) NOT NULL,
  update_time TIMESTAMP (6) NOT NULL
);