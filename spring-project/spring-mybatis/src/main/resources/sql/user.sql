DROP TABLE IF EXISTS mysm.user;
CREATE TABLE mysm.`user` (
  `id` varchar(16) CHARACTER SET latin1 NOT NULL COMMENT '用户ID',
  `username` varchar(45) CHARACTER SET latin1 NOT NULL COMMENT '账号',
  `password` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '密码',
  `email` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

