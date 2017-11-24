DROP TABLE IF EXISTS `follow`.`user`;
CREATE TABLE `follow`.`user` (
  `user_id` VARCHAR(16) NOT NULL COMMENT '用户id',
  `username` VARCHAR(45) NULL COMMENT '用户名',
  `password` VARCHAR(45) NULL COMMENT '密码',
  `email` VARCHAR(45) NULL COMMENT '邮箱',
  `age` INT(2) NULL COMMENT '年龄',
  `time` TIMESTAMP NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`))
COMMENT = '用户表';

