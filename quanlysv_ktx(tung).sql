-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlysv_ktx(tung)
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
-- Table structure for table `dormitory`
--

DROP TABLE IF EXISTS `dormitory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dormitory` (
  `Dormitory_name` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `Dormitory_capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`Dormitory_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dormitory`
--

LOCK TABLES `dormitory` WRITE;
/*!40000 ALTER TABLE `dormitory` DISABLE KEYS */;
INSERT INTO `dormitory` VALUES ('B10',400),('B13',500),('B5',400),('B6',380),('B7',380),('B8',450),('B9',400);
/*!40000 ALTER TABLE `dormitory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `Manager_id` int(11) NOT NULL,
  `Manager_name` text,
  `Manager_password` text,
  `Manager_phone` text,
  `Manager_add` text,
  `Dormitory_name` text,
  PRIMARY KEY (`Manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1000,'Vũ Đức Tùng','tung','0987580129','Hai Duong','B7'),(1001,'Vũ Thị Tươi','tuoi','01692414330','Hai Duong','B9'),(1002,'Vũ Đức Thuận','thuan','01641231230','Ha Noi','B5'),(1003,'Bùi Văn Cường','cuong','0989123123','Ha Noi','B6'),(1004,'Nguyễn Thị Oanh','oanh','01621233210','Ha Nam','B8'),(1005,'Nguyễn Văn Đạt','dat','0913214231','Bac Ninh','B10'),(1006,'Cao Anh Tú','tu','01234567890','Bac Giang','B13');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `Room_id` int(11) NOT NULL,
  `Room_name` int(11) DEFAULT NULL,
  `Dormitory_name` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`Room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,100,'B7'),(2,101,'B7'),(3,102,'B7'),(4,103,'B7'),(5,104,'B7'),(6,105,'B7'),(7,106,'B7'),(8,107,'B7'),(9,108,'B7'),(10,109,'B7'),(11,110,'B7'),(12,111,'B7'),(13,112,'B7'),(14,113,'B7'),(15,200,'B7'),(16,201,'B7'),(17,202,'B7'),(18,203,'B7'),(19,204,'B7'),(20,205,'B7'),(21,206,'B7'),(22,207,'B7'),(23,208,'B7'),(24,209,'B7'),(25,210,'B7'),(26,211,'B7'),(27,212,'B7'),(28,213,'B7'),(29,214,'B8');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_detail`
--

DROP TABLE IF EXISTS `room_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_detail` (
  `Room_capacity` int(11) DEFAULT NULL,
  `Room_free` int(11) DEFAULT NULL,
  `Room_id` int(11) NOT NULL,
  `Dormitory_name` text,
  PRIMARY KEY (`Room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_detail`
--

LOCK TABLES `room_detail` WRITE;
/*!40000 ALTER TABLE `room_detail` DISABLE KEYS */;
INSERT INTO `room_detail` VALUES (2,2,1,'B7'),(8,8,2,'B7'),(8,8,3,'B7'),(8,8,4,'B7'),(8,8,5,'B7'),(8,8,6,'B7'),(8,8,7,'B7'),(8,8,8,'B7'),(8,8,9,'B7'),(8,8,10,'B7'),(8,1,11,'B7'),(8,8,12,'B7'),(8,8,13,'B7'),(2,2,14,'B7');
/*!40000 ALTER TABLE `room_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `Student_code` int(11) NOT NULL,
  `Student_name` text,
  `Student_image` text,
  `Student_k` int(11) DEFAULT NULL,
  `Student_school` text,
  `Student_birth` text,
  `Student_gentl` text,
  `Student_homeLand` text,
  `Student_phone` text,
  `Room_id` int(11) DEFAULT NULL,
  `Dormitory_name` text,
  PRIMARY KEY (`Student_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (123,'Thuận','',60,'CD nghề','01/10/1997','nam','HN','210391230',11,'B7'),(124,'Hùng','',58,'Điện','01/11/1991','nam','HN','213123123',11,'B7'),(125,'Anh','',58,'Hóa','3/12/1995','nam','Hà Tĩnh','142341234',11,'B7'),(126,'Đăng','',58,'Điện','2/1/1995','nam','HN','012930129',11,'B7'),(127,'Tú','',58,'ĐTVT','04/12/1995','nam','Bắc Giang','093018233',11,'B7'),(128,'Thái','',58,'ĐTVT','1/2/1995','nam','Hải Dương','12039',11,'B7'),(20134459,'Vũ Đức Tùng','',58,'Điện Tử Viễn Thông','22/05/1995','nam','Hải Dương','0987580129',11,'B7');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-11 18:44:49
