DROP TABLE t_tc_user;
CREATE TABLE t_tc_user (
  user_id VARCHAR (32) PRIMARY KEY,
  login_name VARCHAR (30) NOT NULL UNIQUE,
  password VARCHAR (50) NOT NULL,
  email VARCHAR (50),
  phone VARCHAR (20),
  age int,
  birthday TIMESTAMP (5),
  create_by VARCHAR (32) NOT NULL,
  create_time TIMESTAMP (6) NOT NULL,
  update_by VARCHAR (32) NOT NULL,
  update_time TIMESTAMP (6) NOT NULL

);

CREATE INDEX i_tc_user_login_name ON t_tc_user (login_name);
CREATE INDEX i_tc_user_phone ON t_tc_user (phone);