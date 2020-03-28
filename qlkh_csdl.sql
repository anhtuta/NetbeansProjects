-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: qlkh_csdl
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `detai`
--

DROP TABLE IF EXISTS `detai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detai` (
  `dtid` varchar(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `level` varchar(20) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`dtid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detai`
--

LOCK TABLES `detai` WRITE;
/*!40000 ALTER TABLE `detai` DISABLE KEYS */;
INSERT INTO `detai` VALUES ('1','tinh toan luoi','nha nuoc',700),('2','phat hien tri thuc','bo',300),('3','phan loai vb','bo',270),('4','dich tu dong Anh Viet','truong',30),('5','quản lý sv','lớp',700);
/*!40000 ALTER TABLE `detai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giangvien`
--

DROP TABLE IF EXISTS `giangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giangvien` (
  `gvid` varchar(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `addr` varchar(40) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  PRIMARY KEY (`gvid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvien`
--

LOCK TABLES `giangvien` WRITE;
/*!40000 ALTER TABLE `giangvien` DISABLE KEYS */;
INSERT INTO `giangvien` VALUES ('1','Vu tuyet trinh','hoang mai, Hanoi','1975-10-10'),('2','nguyen nhat quang','hai ba trung, Hanoi','1976-11-03'),('3','tran duc khanh','dong da, HN','1977-06-04'),('4','nguyen hong phuong','tay ho, Hn','1983-12-10'),('5','le thanh phuong','hai ba trung, Hn','1976-10-10');
/*!40000 ALTER TABLE `giangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thamgia`
--

DROP TABLE IF EXISTS `thamgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thamgia` (
  `gvid` varchar(5) NOT NULL,
  `dtid` varchar(5) NOT NULL,
  `hours` int(11) DEFAULT NULL,
  PRIMARY KEY (`gvid`,`dtid`),
  KEY `dtid` (`dtid`),
  CONSTRAINT `thamgia_ibfk_1` FOREIGN KEY (`gvid`) REFERENCES `giangvien` (`gvid`),
  CONSTRAINT `thamgia_ibfk_2` FOREIGN KEY (`dtid`) REFERENCES `detai` (`dtid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thamgia`
--

LOCK TABLES `thamgia` WRITE;
/*!40000 ALTER TABLE `thamgia` DISABLE KEYS */;
INSERT INTO `thamgia` VALUES ('1','1',100),('1','2',80),('1','3',80),('2','1',120),('2','3',140),('3','3',150),('4','4',180);
/*!40000 ALTER TABLE `thamgia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-11 18:42:58
