# 溯源系统数据库 origin
DROP DATABASE IF EXISTS origin;
CREATE DATABASE IF NOT EXISTS origin DEFAULT CHARSET = utf8;
USE origin;

# 管理员表 admin
DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
  id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '管理员id',
  adminname VARCHAR(20) NOT NULL DEFAULT '' COMMENT '管理员帐号',
  adminpassword VARCHAR(20) NOT NULL DEFAULT '' COMMENT '管理员密码',
  level INT(11) NOT NULL DEFAULT 1 COMMENT '管理员等级；1:系统管理员,2:超级管理员',
  time DATETIME NOT NULL DEFAULT NOW() COMMENT '管理员创建时间',
  remark VARCHAR(255) DEFAULT ''
)ENGINE = InnoDB,CHARSET = utf8;


# 产品表 product
DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id int(11) PRIMARY KEY AUTO_INCREMENT COMMENT '产品id',
  prucut_name VARCHAR(255) NOT NULL DEFAULT '' COMMENT '产品名称',
  product_msg VARCHAR(255) NOT NULL DEFAULT '' COMMENT '产品信息',
  time DATETIME NOT NULL DEFAULT NOW()
)ENGINE = InnoDB, CHARSET = utf8;


# 工厂表 factory
DROP TABLE IF EXISTS factory;
CREATE TABLE factory (
  id int(11) PRIMARY KEY AUTO_INCREMENT COMMENT '工厂id',
  fac_username VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工厂帐号',
  fac_password VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工厂密码',
  fac_msg VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工厂信息',
  time DATETIME NOT NULL DEFAULT NOW() COMMENT '工厂帐号创建时间'
)ENGINE = InnoDB,CHARSET = utf8;


# 生产链表 productchain
DROP TABLE IF EXISTS productchain;
CREATE TABLE IF NOT EXISTS productchain (
  id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '生产链id',
  pid INT(11) NOT NULL COMMENT '产品id',
  fid INT(11) NOT NULL COMMENT '工厂id',
  CONSTRAINT fk_productchain_pid FOREIGN KEY (pid) REFERENCES product(id),
  CONSTRAINT fk_productchain_fid FOREIGN KEY (fid) REFERENCES factory(id)
)ENGINE = InnoDB,CHARSET = utf8;


# 批次表 batch
DROP TABLE IF EXISTS batch;
CREATE TABLE batch (
  batch_id VARCHAR(255) PRIMARY KEY NOT NULL DEFAULT '' COMMENT '批次号',
  pcid INT(11) NOT NULL COMMENT '生产链id',
  time DATETIME NOT NULL DEFAULT NOW() COMMENT '批次创建时间',
  CONSTRAINT fk_batch_pcid FOREIGN KEY (pcid) REFERENCES productchain(id)
)ENGINE = InnoDB,CHARSET = utf8;


# 模板表 templet
DROP TABLE IF EXISTS template;
CREATE TABLE template (
  id int(11) PRIMARY KEY AUTO_INCREMENT COMMENT '模板id',
  ttitle VARCHAR(255) NOT NULL DEFAULT '' COMMENT '标题',
  tproperty VARCHAR(255) NOT NULL DEFAULT '' COMMENT '属性',
  status INT(11) NOT NULL DEFAULT 0 COMMENT '模板审核状态；0:无效,1:成功,2:待审核',
  pcid INT(11) NOT NULL COMMENT '生产链id',
  fid INT(11) NOT NULL COMMENT '工厂id',
  time DATETIME NOT NULL DEFAULT NOW()  COMMENT '模板创建时间',
  CONSTRAINT fk_template_pcid FOREIGN KEY (pcid) REFERENCES productchain(id),
  CONSTRAINT fk_template_fid FOREIGN KEY (fid) REFERENCES factory(id)
)ENGINE = InnoDB,CHARSET = utf8;


# 数据表 data
DROP TABLE IF EXISTS data;
CREATE TABLE data (
  id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '数据id',
  fid INT(11) NOT NULL COMMENT '工厂id',
  bid VARCHAR(255) NOT NULL COMMENT '批次号',
  status INT(11) NOT NULL DEFAULT 0 COMMENT '数据审核状态；0:无效,1:成功,2:待审核',
  time DATETIME NOT NULL DEFAULT now() COMMENT '数据创建时间',
  CONSTRAINT fk_data_fid FOREIGN KEY (fid) REFERENCES factory(id),
  CONSTRAINT fk_data_bid FOREIGN KEY (bid) REFERENCES batch(batch_id)
)ENGINE = InnoDB,CHARSET = utf8;