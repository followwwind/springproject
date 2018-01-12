CREATE DATABASE  IF NOT EXISTS `book-system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `book-system`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: book-system
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` varchar(32) NOT NULL COMMENT '图书编号',
  `book_name` varchar(45) DEFAULT NULL COMMENT '图书名称',
  `author` varchar(45) DEFAULT NULL COMMENT '作者',
  `publishers` varchar(45) DEFAULT NULL COMMENT '出版社',
  `price` double DEFAULT NULL COMMENT '价格',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `status` int(2) DEFAULT NULL COMMENT '图书状态，0表示空闲，1表示被占用，即被借用',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图书信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('783ec5eedb31456993d68ff07d04a1fd','悲惨世界','雨果','人民文学出版社',66,'2017-12-13 15:32:47',0),('a15407dc01a247aaba36ebf83ee68b7b','老人与海','海明威','上海译文出版社',8.7,'2017-12-23 01:22:23',0),('cb363b4fa47a435eada3387d8d180623','红楼梦','曹雪芹','人民文学出版社',59.7,'2017-12-13 15:32:47',0),('d108bde3639c4f62b201a8b2e61db920','月亮和六便士','毛姆','上海译文出版社 ',59.9,'2017-12-23 01:22:22',0),('f118a183b9e94eb1840fe99b4854550f','傲慢与偏见','奥斯丁','人民文学出版社',47.7,'2017-12-23 01:22:22',0),('f3789f4b3500449193e31539f1e45bcc','三国演义','罗贯中','人民文学出版社',99.5,'2017-12-13 15:32:47',0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `record_id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `book_id` varchar(32) DEFAULT NULL COMMENT '图书id',
  `borrow_time` timestamp NULL DEFAULT NULL COMMENT '借书日期',
  `return_time` timestamp NULL DEFAULT NULL COMMENT '还书日期',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结束还书记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES ('561d26e8409449278717aa63ccd21722','f086a68286784a0eb4826c6039ed5a7c','48e7778d736b4f1bbc8d5c401ff8246e','2018-01-06 09:53:46','2018-01-06 09:53:46');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `user_id` varchar(32) NOT NULL COMMENT '学号',
  `name` varchar(45) NOT NULL COMMENT '姓名',
  `password` varchar(45) DEFAULT NULL COMMENT '账号密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `count` int(2) DEFAULT NULL COMMENT '借书本数',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `type` int(2) DEFAULT NULL COMMENT '账户类型，1为系统账户，2为普通用户',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('18c7d1959f3b4e3488987375ad55cdcb','admin','123','18112345678',0,'2017-12-14 01:32:48',1),('f086a68286784a0eb4826c6039ed5a7c','wind','123','18771933912',0,'2017-12-13 15:33:31',2);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-12 15:33:06
