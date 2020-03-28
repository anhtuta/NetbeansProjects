-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dormitory
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
  `Dormitory_name` varchar(10) NOT NULL,
  `Dormitory_capacity` int(11) NOT NULL,
  PRIMARY KEY (`Dormitory_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `Manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `Manager_name` varchar(45) NOT NULL,
  `Manager_password` varchar(45) DEFAULT NULL,
  `Manager_phone` varchar(45) DEFAULT NULL,
  `Manager_add` varchar(45) DEFAULT NULL,
  `Dormitory_name` varchar(10) NOT NULL,
  PRIMARY KEY (`Manager_id`,`Dormitory_name`),
  KEY `fk_Manager_Dormitory1_idx` (`Dormitory_name`),
  CONSTRAINT `fk_Manager_Dormitory1` FOREIGN KEY (`Dormitory_name`) REFERENCES `dormitory` (`Dormitory_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;
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
  `Room_id` int(11) NOT NULL AUTO_INCREMENT,
  `Room_name` varchar(45) DEFAULT NULL,
  `Dormitory_name` varchar(10) NOT NULL,
  PRIMARY KEY (`Room_id`,`Dormitory_name`),
  KEY `fk_Room_Dormitory1_idx` (`Dormitory_name`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'100','B7'),(2,'101','B7'),(3,'102','B7'),(4,'103','B7'),(5,'104','B7'),(6,'105','B7'),(7,'106','B7'),(8,'107','B7'),(9,'108','B7'),(10,'109','B7'),(11,'110','B7'),(12,'111','B7'),(13,'112','B7'),(14,'113','B7'),(15,'200','B7'),(16,'201','B7'),(17,'202','B7'),(18,'203','B7'),(19,'204','B7'),(20,'205','B7'),(21,'206','B7'),(22,'207','B7'),(23,'208','B7'),(24,'209','B7'),(25,'210','B7'),(26,'211','B7'),(27,'212','B7'),(28,'213','B7'),(29,'301','B7'),(30,'302','B7'),(31,'303','B7'),(32,'304','B7'),(33,'305','B7'),(34,'306','B7'),(35,'307','B7'),(36,'308','B7'),(37,'309','B7'),(38,'310','B7'),(39,'311','B7'),(40,'312','B7'),(41,'313','B7'),(42,'401','B7'),(43,'402','B7'),(44,'403','B7'),(45,'404','B7'),(46,'405','B7'),(47,'406','B7'),(48,'407','B7'),(49,'408','B7'),(50,'409','B7'),(51,'410','B7'),(52,'411','B7'),(53,'412','B7'),(54,'413','B7'),(55,'101','B6'),(56,'102','B6'),(57,'103','B6'),(58,'104','B6'),(59,'105','B6'),(60,'106','B6'),(61,'107','B6'),(62,'108','B6'),(63,'109','B6'),(64,'110','B6'),(65,'111','B6'),(66,'112','B6'),(67,'113','B6'),(68,'201','B6'),(69,'202','B6'),(70,'203','B6'),(71,'204','B6'),(72,'205','B6'),(73,'206','B6'),(74,'207','B6'),(75,'208','B6'),(76,'209','B6'),(77,'210','B6'),(78,'211','B6'),(79,'212','B6'),(80,'213','B6'),(81,'301','B6'),(82,'302','B6'),(83,'303','B6'),(84,'304','B6'),(85,'305','B6'),(86,'306','B6'),(87,'307','B6'),(88,'308','B6'),(89,'309','B6'),(90,'310','B6'),(91,'311','B6'),(92,'312','B6'),(93,'313','B6'),(94,'401','B6'),(95,'402','B6'),(96,'403','B6'),(97,'404','B6'),(98,'405','B6'),(99,'406','B6'),(100,'407','B6'),(101,'408','B6'),(102,'409','B6'),(103,'410','B6'),(104,'411','B6'),(105,'412','B6'),(106,'413','B6');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_detail`
--

DROP TABLE IF EXISTS `room_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_detail` (
  `Room_capacity` int(11) NOT NULL,
  `Room_free` int(11) DEFAULT NULL,
  `Room_id` int(11) NOT NULL,
  `Dormitory_name` varchar(10) NOT NULL,
  PRIMARY KEY (`Room_id`,`Dormitory_name`),
  CONSTRAINT `fk_Room_detail_Room1` FOREIGN KEY (`Room_id`, `Dormitory_name`) REFERENCES `room` (`Room_id`, `Dormitory_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_detail`
--

LOCK TABLES `room_detail` WRITE;
/*!40000 ALTER TABLE `room_detail` DISABLE KEYS */;
INSERT INTO `room_detail` VALUES (2,2,1,'B7'),(8,8,2,'B7'),(8,8,3,'B7'),(8,8,4,'B7'),(8,8,5,'B7'),(8,8,6,'B7'),(8,8,7,'B7'),(8,8,8,'B7'),(8,8,9,'B7'),(8,8,10,'B7'),(8,1,11,'B7'),(8,8,12,'B7'),(8,8,13,'B7'),(8,2,14,'B7'),(7,1,15,'B7'),(8,1,16,'B7'),(7,2,17,'B7'),(6,3,18,'B7'),(6,1,19,'B7'),(7,2,20,'B7'),(7,3,21,'B7'),(8,2,22,'B7'),(6,3,23,'B7'),(8,1,24,'B7'),(6,2,25,'B7'),(7,1,26,'B7'),(7,3,27,'B7'),(7,1,28,'B7'),(8,3,29,'B7'),(8,1,30,'B7'),(8,3,31,'B7'),(6,1,32,'B7'),(8,3,33,'B7'),(7,1,34,'B7'),(6,2,35,'B7'),(6,3,36,'B7'),(6,3,37,'B7'),(8,1,38,'B7'),(8,3,39,'B7'),(7,1,40,'B7'),(8,1,41,'B7'),(7,3,42,'B7'),(8,2,43,'B7'),(7,2,44,'B7'),(6,2,45,'B7'),(6,2,46,'B7'),(6,3,47,'B7'),(7,1,48,'B7'),(6,2,49,'B7'),(8,2,50,'B7'),(7,1,51,'B7'),(7,2,52,'B7'),(8,2,53,'B7'),(7,3,54,'B7'),(5,3,55,'B6'),(6,3,56,'B6'),(6,2,57,'B6'),(6,2,58,'B6'),(5,1,59,'B6'),(7,1,60,'B6'),(5,2,61,'B6'),(6,3,62,'B6'),(7,3,63,'B6'),(6,1,64,'B6'),(6,3,65,'B6'),(7,2,66,'B6'),(7,3,67,'B6'),(5,1,68,'B6'),(7,1,69,'B6'),(7,1,70,'B6'),(5,1,71,'B6'),(5,3,72,'B6'),(5,3,73,'B6'),(7,2,74,'B6'),(7,2,75,'B6'),(5,1,76,'B6'),(5,1,77,'B6'),(7,1,78,'B6'),(7,1,79,'B6'),(6,1,80,'B6'),(6,2,81,'B6'),(6,3,82,'B6'),(5,3,83,'B6'),(5,3,84,'B6'),(7,1,85,'B6'),(5,1,86,'B6'),(5,1,87,'B6'),(5,2,88,'B6'),(7,1,89,'B6'),(5,1,90,'B6'),(7,3,91,'B6'),(5,3,92,'B6'),(5,2,93,'B6'),(7,1,94,'B6'),(5,2,95,'B6'),(5,2,96,'B6'),(6,3,97,'B6'),(5,2,98,'B6'),(7,3,99,'B6'),(7,3,100,'B6'),(5,2,101,'B6'),(6,2,102,'B6'),(7,2,103,'B6'),(6,1,104,'B6'),(7,2,105,'B6'),(7,3,106,'B6');
/*!40000 ALTER TABLE `room_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `Student_code` varchar(20) NOT NULL,
  `Student_name` varchar(45) NOT NULL,
  `Student_image` blob,
  `Student_k` int(11) NOT NULL,
  `Student_school` varchar(45) DEFAULT NULL,
  `Student_birth` varchar(45) NOT NULL,
  `Student_gentl` varchar(10) NOT NULL,
  `Student_homeLand` varchar(45) DEFAULT NULL,
  `Student_phone` varchar(45) NOT NULL,
  `Room_id` int(11) NOT NULL,
  `Dormitory_name` varchar(10) NOT NULL,
  PRIMARY KEY (`Student_code`,`Room_id`,`Dormitory_name`),
  KEY `fk_Student_Room1_idx` (`Room_id`,`Dormitory_name`),
  CONSTRAINT `fk_Student_Room1` FOREIGN KEY (`Room_id`, `Dormitory_name`) REFERENCES `room` (`Room_id`, `Dormitory_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('123','Thuận','',60,'CD nghề','01/10/1997','nam','HN','210391230',11,'B7'),('124','Hùng','',58,'Điện','01/11/1991','nam','HN','213123123',11,'B7'),('125','Anh','',58,'Hóa','3/12/1995','nam','Hà Tĩnh','142341234',11,'B7'),('126','Đăng','',58,'Điện','2/1/1995','nam','HN','012930129',11,'B7'),('127','Tú','',58,'ĐTVT','04/12/1995','nam','Bắc Giang','093018233',11,'B7'),('128','Thái','',58,'ĐTVT','1/2/1995','nam','Hải Dương','12039',11,'B7'),('20130001','Phan Thị Dũng',NULL,58,'Viện Khoa học và Kỹ thuật Vật liệu','24/8/1997','Nữ','Lạng Sơn','0976233100',2,'B7'),('20130001','Nguyễn Văn A',NULL,58,'CNTT','12/12/1995','nữ','Sài Gòn','0976233222',28,'B7'),('20130002','Tạ Minh Hải Anh',NULL,59,'Khoa Giáo dục Quốc phòng','15/4/1994','Nam','Nghệ An','0976233101',14,'B7'),('20130003','Trần Văn Nghĩa',NULL,57,'Viện Điện tử - Viễn thông','20/5/1996','Nam','Lạng Sơn','0976233102',5,'B7'),('20130004','Phan Thị Hoa',NULL,56,'Viện Cơ khí','11/10/1996','Nam','Thanh Hóa','0976233103',16,'B7'),('20130005','Nguyễn Trọng Nghĩa',NULL,58,'Khoa Giáo dục Quốc phòng','4/5/1993','Nam','Hà Nội','0976233104',22,'B7'),('20130006','Thu Đức Nam',NULL,56,'Viện Toán ứng dụng và Tin học','13/9/1995','Nam','Sơn La','0976233105',15,'B7'),('20130007','Tạ Trung Phương Anh',NULL,58,'Viện Cơ khí','12/10/1995','Nam','Bắc Ninh','0976233106',26,'B7'),('20130008','Đặng Trọng Linh',NULL,58,'Viện Điện','16/7/1997','Nữ','Lào Cai','0976233107',17,'B7'),('20130009','Phạm Đức Huyền',NULL,56,'Viện Kỹ thuật Hoá học','16/1/1995','Nữ','Nghệ An','0976233108',19,'B7'),('20130010','Thu Đăng Dũng',NULL,58,'Khoa Giáo dục Quốc phòng','6/2/1997','Nam','Bắc Giang','0976233109',25,'B7'),('20130011','Phan Đăng Minh',NULL,59,'Viện Kinh tế & Quản lý','22/10/1994','Nam','Bắc Ninh','0976233110',11,'B7'),('20130012','Lê Trung yến',NULL,59,'Viện Sư phạm Kỹ thuật','18/10/1993','Nữ','Lạng Sơn','0976233111',4,'B7'),('20130013','Đặng Văn Nghĩa',NULL,56,'Khoa Lý luận chính trị','20/4/1996','Nữ','Lạng Sơn','0976233112',20,'B7'),('20130014','Tạ Trung yến',NULL,57,'Viện Ngoại ngữ','2/10/1994','Nam','Sơn La','0976233113',17,'B7'),('20130015','Phạm Đăng Hiếu',NULL,59,'Viện Dệt may - Da giầy và Thời trang','10/5/1994','Nữ','Sơn La','0976233114',6,'B7'),('20130016','Hoàng Trọng Linh',NULL,59,'Viện Ngoại ngữ','9/9/1996','Nam','Ninh Bình','0976233115',14,'B7'),('20130017','Lê Thị Nam Anh',NULL,58,'Khoa Giáo dục Quốc phòng','16/4/1994','Nam','Hải Phòng','0976233116',12,'B7'),('20130018','Phan Tuấn Lan',NULL,56,'Viện Sư phạm Kỹ thuật','1/5/1996','Nữ','Hải Phòng','0976233117',23,'B7'),('20130019','Tạ Đức Nghĩa',NULL,57,'Viện Công nghệ Thông tin và Truyền thông','25/9/1995','Nữ','Lào Cai','0976233118',18,'B7'),('20130020','Hoàng Văn Hiếu',NULL,56,'Viện Điện tử - Viễn thông','5/4/1994','Nam','Sơn La','0976233119',18,'B7'),('20130021','Thu Minh Hải Anh',NULL,58,'Viện Điện tử - Viễn thông','27/3/1996','Nữ','Bắc Giang','0976233120',25,'B7'),('20130022','Phạm Trọng yến',NULL,56,'Viện Khoa học và Kỹ thuật Vật liệu','6/9/1997','Nữ','Thanh Hóa','0976233121',30,'B7'),('20130023','Đặng Trung Huyền',NULL,59,'Viện Kỹ thuật Hoá học','30/10/1993','Nam','Nam Định','0976233122',12,'B7'),('20130024','Thu Minh Tuấn',NULL,56,'Viện Sư phạm Kỹ thuật','9/7/1993','Nữ','Ninh Bình','0976233123',21,'B7'),('20130025','Trần Đăng Quỳnh',NULL,56,'Viện Dệt may - Da giầy và Thời trang','28/6/1994','Nữ','Lạng Sơn','0976233124',13,'B7'),('20130026','Lê Minh Hải Anh',NULL,58,'Viện Toán ứng dụng và Tin học','2/9/1993','Nam','Thanh Hóa','0976233125',6,'B7'),('20130027','Tạ Đức Thanh',NULL,56,'Viện Ngoại ngữ','22/1/1993','Nữ','Bắc Ninh','0976233126',24,'B7'),('20130028','Nguyễn Minh Thanh',NULL,58,'Viện Công nghệ Thông tin và Truyền thông','11/1/1995','Nữ','Hải Phòng','0976233127',2,'B7'),('20130029','Nguyễn Đăng Thanh',NULL,57,'Viện Điện tử - Viễn thông','11/4/1993','Nữ','Hải Phòng','0976233128',8,'B7'),('20130030','Trần Văn Thanh',NULL,57,'Viện Điện tử - Viễn thông','23/9/1995','Nữ','Hà Nội','0976233129',17,'B7'),('20130031','Phạm Minh Thanh',NULL,59,'Viện Điện','8/5/1993','Nữ','Bắc Ninh','0976233130',16,'B7'),('20130032','Phạm Tuấn Nam Anh',NULL,56,'Viện Công nghệ Thông tin và Truyền thông','9/8/1993','Nữ','Nam Định','0976233131',17,'B7'),('20130033','Phan Đức yến',NULL,59,'Viện Kỹ thuật Hoá học','7/10/1993','Nam','Lạng Sơn','0976233132',5,'B7'),('20130034','Thu Văn Dũng',NULL,57,'Viện Sư phạm Kỹ thuật','18/1/1993','Nam','Hải Phòng','0976233133',12,'B7'),('20130035','Nguyễn Minh Quỳnh',NULL,58,'Viện Ngoại ngữ','9/3/1995','Nam','Hải Phòng','0976233134',21,'B7'),('20130036','Nguyễn Minh Phương',NULL,59,'Viện Kỹ thuật Hoá học','2/9/1993','Nam','Ninh Bình','0976233135',25,'B7'),('20130037','Nguyễn Văn Dũng',NULL,58,'Viện Sư phạm Kỹ thuật','2/2/1995','Nữ','Nghệ An','0976233136',14,'B7'),('20130038','Lê Đức Hiếu',NULL,59,'Khoa Giáo dục Quốc phòng','2/4/1997','Nam','Lào Cai','0976233137',29,'B7'),('20130039','Hoàng Thị Hiếu',NULL,57,'Khoa Giáo dục Quốc phòng','20/9/1993','Nam','Hải Phòng','0976233138',2,'B7'),('20130040','Phan Trung yến',NULL,57,'Viện Dệt may - Da giầy và Thời trang','10/7/1997','Nam','Lào Cai','0976233139',4,'B7'),('20130041','Lê Trọng Nam',NULL,59,'Viện Toán ứng dụng và Tin học','24/7/1995','Nam','Lào Cai','0976233140',2,'B7'),('20130042','Tạ Trung yến',NULL,58,'Viện Ngoại ngữ','6/4/1995','Nam','Nghệ An','0976233141',21,'B7'),('20130043','Lê Thị Tuấn',NULL,57,'Viện Kinh tế & Quản lý','9/6/1995','Nữ','Thanh Hóa','0976233142',4,'B7'),('20130044','Tạ Đăng Tú',NULL,58,'Viện Điện tử - Viễn thông','24/5/1997','Nữ','Ninh Bình','0976233143',19,'B7'),('20130045','Đặng Đăng Thanh',NULL,56,'Viện Kinh tế & Quản lý','1/4/1994','Nam','Bắc Giang','0976233144',21,'B7'),('20130046','Phan Văn Hải Anh',NULL,58,'Viện Kinh tế & Quản lý','23/6/1995','Nữ','Nghệ An','0976233145',17,'B7'),('20130047','Tạ Minh Tuấn Anh',NULL,58,'Viện Dệt may - Da giầy và Thời trang','2/4/1994','Nam','Hà Tĩnh','0976233146',9,'B7'),('20130048','Thu Đức Tuấn',NULL,57,'Viện Điện tử - Viễn thông','9/3/1993','Nam','Nam Định','0976233147',14,'B7'),('20130049','Đặng Trọng Minh',NULL,59,'Khoa Lý luận chính trị','27/6/1997','Nam','Lào Cai','0976233148',4,'B7'),('20130050','Thu Tuấn Tuấn Anh',NULL,59,'Viện Khoa học và Kỹ thuật Vật liệu','16/7/1993','Nam','Sơn La','0976233149',14,'B7'),('20130051','Phạm Tuấn Nam',NULL,59,'Viện Cơ khí','14/1/1995','Nam','Lào Cai','0976233150',15,'B7'),('20130052','Nguyễn Văn Linh',NULL,57,'Viện Kinh tế & Quản lý','6/4/1997','Nam','Bắc Giang','0976233151',17,'B7'),('20130053','Phan Trung Tuấn',NULL,58,'Viện Toán ứng dụng và Tin học','26/6/1996','Nữ','Bắc Ninh','0976233152',20,'B7'),('20130054','Lê Trung Nam Anh',NULL,56,'Khoa Lý luận chính trị','1/2/1994','Nam','Ninh Bình','0976233153',19,'B7'),('20130055','Đặng Đức Phương',NULL,58,'Viện Khoa học và Kỹ thuật Vật liệu','24/2/1997','Nữ','Hà Nội','0976233154',19,'B7'),('20130056','Tạ Minh Nam',NULL,56,'Viện Ngoại ngữ','19/8/1997','Nữ','Hà Tĩnh','0976233155',2,'B7'),('20130057','Thu Tuấn Dũng',NULL,58,'Viện Toán ứng dụng và Tin học','10/1/1996','Nam','Ninh Bình','0976233156',7,'B7'),('20130058','Phan Đức Quỳnh',NULL,58,'Viện Điện','4/10/1996','Nữ','Sơn La','0976233157',17,'B7'),('20130059','Tạ Tuấn Quỳnh',NULL,57,'Viện Dệt may - Da giầy và Thời trang','24/4/1994','Nữ','Ninh Bình','0976233158',24,'B7'),('20130060','Lê Tuấn Ngọc',NULL,58,'Viện Kỹ thuật Hoá học','3/6/1997','Nữ','Bắc Ninh','0976233159',1,'B7'),('20130061','Thu Đức Hiếu',NULL,59,'Viện Dệt may - Da giầy và Thời trang','18/6/1993','Nam','Hà Nội','0976233160',25,'B7'),('20130062','Lê Đức Tuấn Anh',NULL,56,'Viện Khoa học và Kỹ thuật Vật liệu','16/2/1995','Nam','Lạng Sơn','0976233161',4,'B7'),('20130063','Phan Thị Tuấn',NULL,57,'Viện Ngoại ngữ','17/7/1995','Nữ','Bắc Giang','0976233162',26,'B7'),('20130064','Tạ Tuấn Thanh',NULL,56,'Khoa Lý luận chính trị','20/6/1994','Nam','Sơn La','0976233163',6,'B7'),('20130065','Hoàng Minh yến',NULL,59,'Khoa Lý luận chính trị','16/4/1993','Nữ','Nghệ An','0976233164',14,'B7'),('20130066','Đặng Tuấn Phương Anh',NULL,56,'Khoa Lý luận chính trị','29/5/1993','Nam','Nam Định','0976233165',24,'B7'),('20130067','Đặng Đức Thanh',NULL,57,'Viện Điện tử - Viễn thông','10/9/1997','Nam','Ninh Bình','0976233166',28,'B7'),('20130068','Đặng Tuấn Lan',NULL,59,'Viện Khoa học và Kỹ thuật Vật liệu','26/9/1993','Nữ','Hà Nội','0976233167',6,'B7'),('20130069','Phan Trung Hải Anh',NULL,59,'Khoa Lý luận chính trị','10/8/1994','Nữ','Bắc Ninh','0976233168',27,'B7'),('20130070','Phan Trọng Hiếu',NULL,57,'Khoa Lý luận chính trị','26/11/1993','Nam','Thanh Hóa','0976233169',2,'B7'),('20130071','Thu Thị Thanh',NULL,56,'Viện Cơ khí','27/7/1995','Nữ','Sơn La','0976233170',26,'B7'),('20130072','Tạ Đức Tú',NULL,57,'Viện Cơ khí','27/4/1994','Nam','Hà Tĩnh','0976233171',26,'B7'),('20130073','Tạ Tuấn Hoa',NULL,59,'Viện Sư phạm Kỹ thuật','16/1/1997','Nữ','Sơn La','0976233172',28,'B7'),('20130074','Nguyễn Trung Hiếu',NULL,57,'Viện Ngoại ngữ','16/1/1995','Nữ','Lạng Sơn','0976233173',6,'B7'),('20130075','Đặng Minh Hiếu',NULL,58,'Viện Kỹ thuật Hoá học','15/11/1993','Nam','Bắc Giang','0976233174',10,'B7'),('20130076','Hoàng Minh Quỳnh',NULL,56,'Viện Ngoại ngữ','13/10/1995','Nữ','Bắc Giang','0976233175',23,'B7'),('20130077','Đặng Tuấn yến',NULL,57,'Viện Ngoại ngữ','23/2/1995','Nam','Lào Cai','0976233176',2,'B7'),('20130078','Hoàng Đăng Nam',NULL,59,'Khoa Giáo dục Quốc phòng','17/6/1993','Nam','Lạng Sơn','0976233177',21,'B7'),('20130079','Hoàng Trung yến',NULL,57,'Viện Sư phạm Kỹ thuật','28/1/1994','Nam','Bắc Ninh','0976233178',30,'B7'),('20130080','Trần Văn yến',NULL,57,'Viện Điện tử - Viễn thông','13/3/1994','Nữ','Lào Cai','0976233179',7,'B7'),('20130081','Thu Văn Hoa',NULL,57,'Viện Dệt may - Da giầy và Thời trang','24/1/1993','Nam','Hải Phòng','0976233180',17,'B7'),('20130082','Tạ Văn Quỳnh',NULL,57,'Khoa Lý luận chính trị','15/1/1994','Nữ','Thanh Hóa','0976233181',17,'B7'),('20130083','Hoàng Đức Ngọc',NULL,58,'Viện Công nghệ Thông tin và Truyền thông','14/7/1997','Nam','Nam Định','0976233182',21,'B7'),('20130084','Phạm Tuấn Nam Anh',NULL,59,'Viện Kỹ thuật Hoá học','7/10/1995','Nam','Nghệ An','0976233183',14,'B7'),('20130085','Nguyễn Trọng Nam',NULL,57,'Viện Cơ khí','23/3/1996','Nữ','Hải Phòng','0976233184',11,'B7'),('20130086','Phạm Trọng Hải Anh',NULL,56,'Viện Kỹ thuật Hoá học','5/11/1996','Nữ','Hà Tĩnh','0976233185',4,'B7'),('20130087','Phan Trọng Tú',NULL,59,'Khoa Lý luận chính trị','6/2/1997','Nam','Bắc Ninh','0976233186',14,'B7'),('20130088','Tạ Minh Ngọc',NULL,58,'Viện Ngoại ngữ','5/1/1997','Nữ','Sơn La','0976233187',8,'B7'),('20130089','Đặng Đức Hiếu',NULL,57,'Viện Điện','7/5/1996','Nam','Lào Cai','0976233188',21,'B7'),('20130090','Đặng Thị Huyền',NULL,57,'Viện Công nghệ Thông tin và Truyền thông','15/8/1993','Nữ','Thanh Hóa','0976233189',20,'B7'),('20130091','Nguyễn Đức Quỳnh',NULL,56,'Viện Ngoại ngữ','24/11/1995','Nữ','Hải Phòng','0976233190',9,'B7'),('20130092','Nguyễn Minh Nghĩa',NULL,57,'Viện Điện tử - Viễn thông','11/9/1994','Nam','Hà Nội','0976233191',8,'B7'),('20130093','Nguyễn Tuấn Quỳnh',NULL,59,'Khoa Giáo dục Quốc phòng','29/5/1996','Nam','Lào Cai','0976233192',6,'B7'),('20130094','Phan Đức Hoa',NULL,56,'Viện Điện','17/11/1994','Nam','Thanh Hóa','0976233193',7,'B7'),('20130095','Đặng Trung Nam Anh',NULL,58,'Viện Khoa học và Kỹ thuật Vật liệu','1/4/1995','Nữ','Bắc Ninh','0976233194',17,'B7'),('20130096','Nguyễn Đức Nghĩa',NULL,59,'Viện Dệt may - Da giầy và Thời trang','3/2/1996','Nam','Hà Nội','0976233195',18,'B7'),('20130097','Hoàng Tuấn Minh',NULL,58,'Viện Cơ khí','15/10/1993','Nữ','Sơn La','0976233196',6,'B7'),('20130098','Thu Minh yến',NULL,56,'Khoa Giáo dục Quốc phòng','1/9/1993','Nam','Hà Tĩnh','0976233197',29,'B7'),('20130099','Phan Minh Phương Anh',NULL,58,'Viện Kinh tế & Quản lý','13/10/1997','Nữ','Bắc Ninh','0976233198',7,'B7'),('20130100','Tạ Trọng Dũng',NULL,59,'Viện Khoa học và Kỹ thuật Vật liệu','6/7/1994','Nữ','Nghệ An','0976233199',13,'B7'),('20134459','Vũ Đức Tùng','',58,'Điện Tử Viễn Thông','22/05/1995','nam','Hải Dương','0987580129',11,'B7'),('20140001','Đặng Đăng Nam Anh',NULL,57,'Viện Công nghệ Thông tin và Truyền thông','18/10/1997','Nữ','Sơn La','0976233100',12,'B7'),('20140002','Đặng Trọng Huyền',NULL,59,'Viện Kinh tế & Quản lý','7/2/1993','Nữ','Bắc Ninh','0976233101',24,'B7'),('20140003','Tạ Tuấn yến',NULL,58,'Viện Khoa học và Kỹ thuật Vật liệu','20/10/1997','Nữ','Lạng Sơn','0976233102',6,'B7'),('20140004','Thu Văn Lan',NULL,57,'Viện Sư phạm Kỹ thuật','7/2/1997','Nữ','Nam Định','0976233103',9,'B7'),('20140005','Trần Trung Tuấn',NULL,57,'Viện Dệt may - Da giầy và Thời trang','18/6/1996','Nam','Hải Phòng','0976233104',17,'B7'),('20140006','Nguyễn Thị Ngọc',NULL,57,'Viện Sư phạm Kỹ thuật','16/2/1993','Nam','Hà Nội','0976233105',2,'B7'),('20140007','Đặng Trọng Hải Anh',NULL,56,'Viện Kỹ thuật Hoá học','3/4/1995','Nam','Sơn La','0976233106',26,'B7'),('20140008','Thu Đăng Huyền',NULL,58,'Viện Khoa học và Kỹ thuật Vật liệu','5/3/1995','Nam','Nam Định','0976233107',24,'B7'),('20140009','Trần Minh Tuấn Anh',NULL,58,'Khoa Lý luận chính trị','17/11/1995','Nam','Sơn La','0976233108',13,'B7'),('20140010','Tạ Thị Minh',NULL,59,'Viện Dệt may - Da giầy và Thời trang','2/10/1996','Nữ','Bắc Ninh','0976233109',30,'B7'),('20140011','Phạm Đức Phương Anh',NULL,58,'Viện Sư phạm Kỹ thuật','11/11/1997','Nữ','Ninh Bình','0976233110',21,'B7'),('20140012','Lê Tuấn Ngọc',NULL,57,'Viện Điện','13/7/1995','Nam','Bắc Giang','0976233111',10,'B7'),('20140013','Lê Đức Lan',NULL,56,'Viện Cơ khí','3/5/1993','Nữ','Bắc Ninh','0976233112',23,'B7'),('20140014','Đặng Thị Lan',NULL,56,'Khoa Giáo dục Quốc phòng','21/5/1997','Nữ','Lạng Sơn','0976233113',24,'B7'),('20140015','Phạm Minh Hoa',NULL,56,'Viện Công nghệ Thông tin và Truyền thông','30/4/1997','Nam','Thanh Hóa','0976233114',15,'B7'),('20140016','Nguyễn Minh yến',NULL,56,'Khoa Lý luận chính trị','14/7/1994','Nữ','Hà Tĩnh','0976233115',9,'B7'),('20140017','Đặng Tuấn Dũng',NULL,58,'Viện Điện','9/1/1993','Nam','Thanh Hóa','0976233116',25,'B7'),('20140018','Phan Đăng Lan',NULL,58,'Khoa Lý luận chính trị','17/9/1995','Nữ','Lạng Sơn','0976233117',27,'B7'),('20140019','Đặng Trung Hải Anh',NULL,57,'Viện Công nghệ Thông tin và Truyền thông','14/4/1996','Nam','Hà Tĩnh','0976233118',8,'B7'),('20140020','Phạm Văn Dũng',NULL,57,'Viện Ngoại ngữ','4/8/1995','Nam','Sơn La','0976233119',2,'B7'),('20140021','Lê Thị Tuấn',NULL,58,'Viện Toán ứng dụng và Tin học','5/3/1993','Nữ','Hà Tĩnh','0976233120',10,'B7'),('20140022','Trần Trung Dũng',NULL,56,'Khoa Giáo dục Quốc phòng','7/8/1997','Nữ','Ninh Bình','0976233121',20,'B7'),('20140023','Phạm Tuấn Quỳnh',NULL,56,'Viện Điện tử - Viễn thông','14/1/1993','Nữ','Nghệ An','0976233122',21,'B7'),('20140024','Lê Thị Thanh',NULL,56,'Viện Cơ khí','11/6/1994','Nam','Hà Nội','0976233123',18,'B7'),('20140025','Tạ Trọng Hoa',NULL,57,'Viện Sư phạm Kỹ thuật','4/11/1993','Nam','Nghệ An','0976233124',14,'B7'),('20140026','Hoàng Tuấn Huyền',NULL,57,'Viện Khoa học và Kỹ thuật Vật liệu','2/4/1994','Nữ','Hà Tĩnh','0976233125',13,'B7'),('20140027','Phan Thị Nam Anh',NULL,59,'Viện Ngoại ngữ','27/4/1995','Nữ','Hà Nội','0976233126',3,'B7'),('20140028','Thu Minh Nam Anh',NULL,59,'Viện Điện tử - Viễn thông','1/2/1995','Nữ','Thanh Hóa','0976233127',1,'B7'),('20140029','Phan Văn Nam',NULL,58,'Viện Khoa học và Kỹ thuật Vật liệu','23/7/1993','Nữ','Sơn La','0976233128',12,'B7'),('20140030','Đặng Đăng Minh',NULL,56,'Viện Điện','30/1/1993','Nam','Bắc Ninh','0976233129',14,'B7'),('20140031','Thu Đăng Nghĩa',NULL,57,'Viện Ngoại ngữ','27/10/1994','Nam','Thanh Hóa','0976233130',27,'B7'),('20140032','Phạm Trọng Quỳnh',NULL,57,'Khoa Giáo dục Quốc phòng','19/10/1995','Nữ','Ninh Bình','0976233131',25,'B7'),('20140033','Nguyễn Đăng Ngọc',NULL,58,'Viện Kỹ thuật Hoá học','24/5/1996','Nữ','Hà Tĩnh','0976233132',29,'B7'),('20140034','Lê Thị Nam Anh',NULL,57,'Viện Khoa học và Kỹ thuật Vật liệu','9/8/1997','Nữ','Hà Nội','0976233133',19,'B7'),('20140035','Đặng Đăng Ngọc',NULL,57,'Viện Khoa học và Kỹ thuật Vật liệu','4/9/1994','Nam','Sơn La','0976233134',26,'B7'),('20140036','Phạm Trung Quỳnh',NULL,58,'Khoa Lý luận chính trị','19/1/1997','Nam','Ninh Bình','0976233135',3,'B7'),('20140037','Đặng Văn Tú',NULL,57,'Viện Dệt may - Da giầy và Thời trang','14/5/1996','Nam','Ninh Bình','0976233136',4,'B7'),('20140038','Thu Thị Linh',NULL,57,'Viện Điện tử - Viễn thông','15/4/1997','Nam','Lào Cai','0976233137',18,'B7'),('20140039','Nguyễn Trọng Tuấn',NULL,57,'Viện Dệt may - Da giầy và Thời trang','28/11/1993','Nữ','Nam Định','0976233138',10,'B7'),('20140040','Tạ Tuấn Dũng',NULL,59,'Viện Khoa học và Kỹ thuật Vật liệu','16/11/1995','Nam','Thanh Hóa','0976233139',1,'B7'),('20140041','Đặng Văn Ngọc',NULL,58,'Viện Sư phạm Kỹ thuật','2/11/1997','Nam','Hà Nội','0976233140',1,'B7'),('20140042','Tạ Thị Tuấn Anh',NULL,59,'Viện Điện tử - Viễn thông','5/7/1996','Nam','Thanh Hóa','0976233141',9,'B7'),('20140043','Trần Trọng yến',NULL,57,'Khoa Lý luận chính trị','16/1/1994','Nam','Ninh Bình','0976233142',9,'B7'),('20140044','Thu Thị Nam Anh',NULL,59,'Viện Dệt may - Da giầy và Thời trang','23/7/1997','Nam','Bắc Ninh','0976233143',22,'B7'),('20140045','Phạm Trung Ngọc',NULL,57,'Viện Dệt may - Da giầy và Thời trang','14/4/1993','Nữ','Ninh Bình','0976233144',4,'B7'),('20140046','Nguyễn Tuấn Phương',NULL,57,'Viện Cơ khí','4/6/1996','Nữ','Bắc Ninh','0976233145',20,'B7'),('20140047','Hoàng Đăng Hoa',NULL,57,'Khoa Giáo dục Quốc phòng','4/2/1994','Nam','Lào Cai','0976233146',18,'B7'),('20140048','Đặng Trung Tuấn',NULL,58,'Viện Khoa học và Kỹ thuật Vật liệu','17/4/1997','Nữ','Sơn La','0976233147',3,'B7'),('20140049','Nguyễn Đức Nam',NULL,56,'Viện Khoa học và Kỹ thuật Vật liệu','25/11/1995','Nam','Lạng Sơn','0976233148',16,'B7'),('20140050','Tạ Minh Nam Anh',NULL,59,'Viện Ngoại ngữ','24/7/1994','Nữ','Bắc Giang','0976233149',2,'B7'),('20140051','Phan Trọng Quỳnh',NULL,56,'Viện Cơ khí','24/5/1997','Nữ','Nam Định','0976233150',26,'B7'),('20140052','Nguyễn Minh Huyền',NULL,58,'Viện Dệt may - Da giầy và Thời trang','24/11/1996','Nữ','Hà Tĩnh','0976233151',15,'B7'),('20140053','Trần Trọng Quỳnh',NULL,59,'Viện Cơ khí','1/9/1997','Nam','Thanh Hóa','0976233152',14,'B7'),('20140054','Trần Tuấn Nam',NULL,56,'Viện Ngoại ngữ','3/6/1997','Nữ','Nghệ An','0976233153',14,'B7'),('20140055','Phạm Minh Nghĩa',NULL,57,'Viện Điện','10/11/1993','Nữ','Lạng Sơn','0976233154',30,'B7'),('20140056','Tạ Đăng yến',NULL,57,'Khoa Lý luận chính trị','19/4/1997','Nữ','Nam Định','0976233155',4,'B7'),('20140057','Trần Đăng Tú',NULL,59,'Viện Cơ khí','3/9/1997','Nữ','Hải Phòng','0976233156',19,'B7'),('20140058','Lê Đức Linh',NULL,58,'Viện Công nghệ Thông tin và Truyền thông','3/10/1993','Nam','Hà Tĩnh','0976233157',22,'B7'),('20140059','Trần Đức Tuấn',NULL,58,'Viện Dệt may - Da giầy và Thời trang','24/2/1993','Nữ','Hà Tĩnh','0976233158',2,'B7'),('20140060','Đặng Đức Lan',NULL,59,'Viện Sư phạm Kỹ thuật','14/9/1997','Nữ','Hà Tĩnh','0976233159',6,'B7'),('20140061','Phạm Tuấn Phương Anh',NULL,56,'Khoa Lý luận chính trị','9/4/1997','Nam','Bắc Ninh','0976233160',7,'B7'),('20140062','Lê Đức Phương Anh',NULL,59,'Viện Toán ứng dụng và Tin học','8/1/1994','Nữ','Nghệ An','0976233161',13,'B7'),('20140063','Trần Đức Tuấn Anh',NULL,58,'Viện Kỹ thuật Hoá học','9/1/1994','Nữ','Bắc Ninh','0976233162',8,'B7'),('20140064','Đặng Đăng Dũng',NULL,59,'Viện Toán ứng dụng và Tin học','10/7/1997','Nữ','Lạng Sơn','0976233163',20,'B7'),('20140065','Đặng Đức Nam Anh',NULL,59,'Viện Điện','15/7/1997','Nữ','Nghệ An','0976233164',9,'B7'),('20140066','Hoàng Trọng Quỳnh',NULL,57,'Viện Kỹ thuật Hoá học','26/3/1996','Nữ','Ninh Bình','0976233165',9,'B7'),('20140067','Tạ Đức Dũng',NULL,57,'Viện Kỹ thuật Hoá học','12/9/1993','Nữ','Hải Phòng','0976233166',10,'B7'),('20140068','Hoàng Đức Nam Anh',NULL,59,'Viện Sư phạm Kỹ thuật','7/1/1994','Nữ','Nam Định','0976233167',21,'B7'),('20140069','Nguyễn Văn Dũng',NULL,56,'Viện Sư phạm Kỹ thuật','27/11/1994','Nữ','Thanh Hóa','0976233168',18,'B7'),('20140070','Phạm Thị Hoa',NULL,57,'Viện Điện tử - Viễn thông','26/10/1997','Nam','Bắc Ninh','0976233169',25,'B7'),('20140071','Hoàng Trung Tuấn Anh',NULL,59,'Viện Kỹ thuật Hoá học','24/10/1996','Nữ','Hà Nội','0976233170',3,'B7'),('20140072','Đặng Trung Phương',NULL,56,'Viện Điện','6/2/1995','Nữ','Sơn La','0976233171',3,'B7'),('20140073','Đặng Đức Minh',NULL,57,'Viện Điện','13/1/1995','Nam','Lạng Sơn','0976233172',6,'B7'),('20140074','Phạm Minh yến',NULL,56,'Viện Điện tử - Viễn thông','10/11/1996','Nữ','Hải Phòng','0976233173',5,'B7'),('20140075','Nguyễn Văn Ngọc',NULL,59,'Viện Ngoại ngữ','14/1/1996','Nam','Ninh Bình','0976233174',3,'B7'),('20140076','Nguyễn Tuấn Linh',NULL,57,'Viện Kinh tế & Quản lý','8/10/1995','Nữ','Nam Định','0976233175',16,'B7'),('20140077','Đặng Trọng Tú',NULL,59,'Viện Ngoại ngữ','2/3/1994','Nữ','Hà Nội','0976233176',24,'B7'),('20140078','Phạm Tuấn Tuấn Anh',NULL,56,'Viện Ngoại ngữ','10/5/1997','Nữ','Bắc Ninh','0976233177',23,'B7'),('20140079','Phạm Tuấn Ngọc',NULL,56,'Viện Dệt may - Da giầy và Thời trang','24/2/1996','Nữ','Lào Cai','0976233178',22,'B7'),('20140080','Thu Trung Nam',NULL,58,'Khoa Giáo dục Quốc phòng','9/10/1996','Nam','Bắc Ninh','0976233179',13,'B7'),('20140081','Thu Minh Nam',NULL,57,'Viện Khoa học và Kỹ thuật Vật liệu','4/5/1997','Nam','Sơn La','0976233180',13,'B7'),('20140082','Phan Trung Hiếu',NULL,59,'Viện Công nghệ Thông tin và Truyền thông','30/6/1997','Nam','Bắc Ninh','0976233181',21,'B7'),('20140083','Thu Tuấn Huyền',NULL,56,'Viện Kinh tế & Quản lý','16/6/1997','Nữ','Hải Phòng','0976233182',26,'B7'),('20140084','Đặng Trung Lan',NULL,56,'Viện Dệt may - Da giầy và Thời trang','2/9/1997','Nữ','Lạng Sơn','0976233183',25,'B7'),('20140085','Hoàng Thị Quỳnh',NULL,56,'Viện Điện tử - Viễn thông','15/6/1996','Nữ','Thanh Hóa','0976233184',8,'B7'),('20140086','Phan Trung Nghĩa',NULL,59,'Viện Kỹ thuật Hoá học','21/1/1997','Nữ','Hà Tĩnh','0976233185',24,'B7'),('20140087','Thu Đăng Tuấn Anh',NULL,59,'Viện Khoa học và Kỹ thuật Vật liệu','23/10/1993','Nữ','Nghệ An','0976233186',18,'B7'),('20140088','Trần Văn Hải Anh',NULL,56,'Viện Công nghệ Thông tin và Truyền thông','9/3/1994','Nam','Lào Cai','0976233187',3,'B7'),('20140089','Lê Minh Lan',NULL,58,'Viện Cơ khí','22/1/1997','Nữ','Bắc Giang','0976233188',17,'B7'),('20140090','Lê Trung Hiếu',NULL,56,'Viện Kỹ thuật Hoá học','11/5/1995','Nữ','Bắc Ninh','0976233189',15,'B7'),('20140091','Phan Đăng Hiếu',NULL,56,'Viện Dệt may - Da giầy và Thời trang','9/9/1994','Nam','Thanh Hóa','0976233190',5,'B7'),('20140092','Phạm Văn Nghĩa',NULL,57,'Viện Kỹ thuật Hoá học','14/11/1996','Nam','Ninh Bình','0976233191',9,'B7'),('20140093','Phạm Đăng yến',NULL,57,'Khoa Giáo dục Quốc phòng','22/11/1995','Nữ','Nam Định','0976233192',29,'B7'),('20140094','Đặng Tuấn Hiếu',NULL,59,'Khoa Giáo dục Quốc phòng','12/6/1997','Nam','Sơn La','0976233193',24,'B7'),('20140095','Lê Tuấn Nghĩa',NULL,56,'Viện Điện tử - Viễn thông','25/3/1993','Nữ','Sơn La','0976233194',12,'B7'),('20140096','Trần Minh Hiếu',NULL,59,'Khoa Lý luận chính trị','28/5/1995','Nữ','Nghệ An','0976233195',13,'B7'),('20140097','Đặng Văn Huyền',NULL,59,'Viện Kinh tế & Quản lý','25/4/1995','Nam','Hải Phòng','0976233196',12,'B7'),('20140098','Hoàng Thị Nghĩa',NULL,56,'Viện Điện','26/1/1993','Nam','Sơn La','0976233197',8,'B7'),('20140099','Lê Trung Phương Anh',NULL,57,'Viện Kỹ thuật Hoá học','11/7/1993','Nam','Hà Nội','0976233198',26,'B7'),('20140100','Lê Trọng Tuấn',NULL,56,'Viện Kỹ thuật Hoá học','2/7/1996','Nữ','Bắc Ninh','0976233199',24,'B7'),('323213143','taafkewof',NULL,44,'cntt','11/11/2011','Nam','hanoi','3243243242',62,'b6');
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

-- Dump completed on 2018-11-11 18:32:47
