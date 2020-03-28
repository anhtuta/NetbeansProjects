-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: qlsv_db
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
-- Table structure for table `academicstaff`
--

DROP TABLE IF EXISTS `academicstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `academicstaff` (
  `id` char(10) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Mã số giáo vụ',
  `name` varchar(35) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên của giáo vụ',
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academicstaff`
--

LOCK TABLES `academicstaff` WRITE;
/*!40000 ALTER TABLE `academicstaff` DISABLE KEYS */;
INSERT INTO `academicstaff` VALUES ('att','Anhtu','1','1995-11-11','Nam',NULL,NULL),('huytq','Quang Huy','123','1995-11-11','Pê đê',NULL,NULL),('nguyenbk','Trung Nguyên','123','1995-11-11','Nam',NULL,NULL),('toantvt','Thanh Toàn','123','1995-11-11','Bê đê',NULL,NULL);
/*!40000 ALTER TABLE `academicstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `availableterm`
--

DROP TABLE IF EXISTS `availableterm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `availableterm` (
  `term` smallint(6) NOT NULL,
  PRIMARY KEY (`term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availableterm`
--

LOCK TABLES `availableterm` WRITE;
/*!40000 ALTER TABLE `availableterm` DISABLE KEYS */;
INSERT INTO `availableterm` VALUES (20151),(20152),(20153),(20161),(20162),(20163),(20171),(20172);
/*!40000 ALTER TABLE `availableterm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL COMMENT 'Mã lớp học',
  `Subject_id` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `term` smallint(6) NOT NULL COMMENT 'Học kỳ',
  `dayOfWeek` tinyint(4) NOT NULL COMMENT 'Ngày học trong tuần',
  `time` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Giờ học trong ngày',
  `week` varchar(25) CHARACTER SET utf8 NOT NULL COMMENT 'Các tuần học',
  `room` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Phòng học',
  `courseType` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT 'Loại lớp học (LT, BT, TH)',
  `note` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `maxNum` int(11) DEFAULT NULL,
  `registeredNum` int(11) DEFAULT '0',
  `Teacher_id` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'GV dạy',
  PRIMARY KEY (`id`,`dayOfWeek`),
  KEY `MaHP_c_idx` (`Subject_id`),
  KEY `Lecturer_c_idx` (`Teacher_id`),
  CONSTRAINT `Lecturer_c` FOREIGN KEY (`Teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MaHP_c` FOREIGN KEY (`Subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (80000,'ET4230',20161,2,'6h45 - 9h15','2-9, 11-18','TC-201','LT+BT',NULL,NULL,NULL,2,'thanhnh'),(80001,'ET4230',20161,3,'6h45 - 9h15','2-9, 11-18','TC-201','LT+BT',NULL,NULL,NULL,0,'thanhnh'),(80002,'ET4230',20161,5,'9h20 - 11h50','2-9, 11-18','TC-202','LT+BT',NULL,NULL,NULL,0,'nampn'),(80003,'ET4290',20161,2,'9h20 - 11h50','2-9, 11-18','TC-204','LT+BT',NULL,NULL,NULL,1,'vupx'),(80004,'ET4290',20161,3,'9h20 - 11h50','2-9, 11-18','TC-205','LT+BT',NULL,NULL,NULL,0,'cuongvl'),(80005,'ET4340',20161,4,'6h45 - 10h5','2-9, 11-18','TC-305','LT+BT',NULL,NULL,NULL,1,'minhnd'),(80006,'ET4360',20161,2,'9h20 - 11h50','2-9, 11-18','TC-309','LT+BT',NULL,NULL,NULL,0,'nampn'),(80007,'IT3010',20161,3,'12h30 - 15h50','2-9, 11-18','TC-308','LT+BT',NULL,NULL,NULL,1,'hiepnd'),(80008,'IT3010',20161,4,'14h5 - 17h35','2-9, 11-18','TC-306','LT+BT',NULL,NULL,NULL,1,'trungtt'),(80009,'IT3650',20161,3,'9h20 - 11h50','2-9, 11-18','B1-403','TH',NULL,NULL,NULL,1,'tungbt'),(80009,'IT3650',20161,6,'6h45 - 9h15','2-9, 11-18','B1-403','TH',NULL,NULL,NULL,1,'tungbt'),(80010,'IT3650',20161,2,'12h30 - 15h','2-9, 11-18','B1-402','TH',NULL,NULL,NULL,1,'hiepnd'),(80010,'IT3650',20161,5,'12h30 - 15h','2-9, 11-18','B1-402','TH',NULL,NULL,NULL,1,'hiepnd'),(80011,'IT4895',20161,2,'6h45 - 9h15','2-9, 11-18','TC-506','LT+BT',NULL,NULL,NULL,0,'khoattq'),(80012,'IT4895',20161,6,'9h20 - 11h50','2-9, 11-18','TC-507','LT+BT',NULL,NULL,NULL,1,'khoattq'),(85001,'ET4230',20162,2,'6h45 - 9h15','22, 25-31, 33-40','TC-502','LT+BT',NULL,NULL,NULL,1,'thanhnh'),(85002,'ET4230',20162,3,'9h20 - 11h50','22, 25-31, 33-40','TC-501','LT+BT',NULL,NULL,NULL,0,'nampn'),(85003,'IT4895',20162,4,'9h20 - 11h50','22, 25-31, 33-40','TC-505','LT+BT',NULL,NULL,NULL,1,'trungtt'),(85004,'IT4895',20162,6,'9h20 - 11h50','22, 25-31, 33-40','TC-207','LT+BT',NULL,NULL,NULL,1,'tungbt'),(85005,'IT3010',20162,2,'8h30 - 11h50','22, 25-31, 33-40','TC-201','LT+BT',NULL,NULL,NULL,0,'hiepnd'),(85006,'IT3010',20162,2,'12h30 - 15h50','22, 25-31, 33-40','TC-202','LT+BT',NULL,NULL,NULL,1,'thanhnh'),(85007,'IT3010',20162,4,'12h30 - 15h50','22, 25-31, 33-40','TC-205','LT+BT',NULL,NULL,NULL,1,'khoattq'),(90001,'ET4060',20171,2,'9h20 - 11h','2-9, 11-18','TC-201','LT+BT',NULL,'Kết thúc đăng ký',100,8,'nampn'),(90001,'ET4060',20171,5,'6h45 - 8h30','2-9, 11-18','TC-201','LT+BT',NULL,'Kết thúc đăng ký',80,8,'nampn'),(90002,'ET4060',20171,3,'12h30 - 14h5','2-9, 11-18','TC-209','LT+BT',NULL,'Kết thúc đăng ký',80,0,'binhnt'),(90002,'ET4060',20171,6,'12h30 - 14h5','2-9, 11-18','TC-209','LT+BT',NULL,'Kết thúc đăng ký',70,0,'binhnt'),(90003,'ET5020',20171,0,'Không có lịch học','2-9, 11-18','','DA',NULL,'Kết thúc đăng ký',60,1,NULL),(90004,'ET4340',20171,5,'8h30 - 11h50','2-9, 11-18','TC-308','LT+BT',NULL,'Kết thúc đăng ký',70,1,'vupx'),(90005,'MI1110',20171,2,'6h45 - 9h15','2-9, 11-18','D5-103','LT+BT',NULL,'Kết thúc đăng ký',50,0,'trungtt'),(90005,'MI1110',20171,5,'6h45 - 8h30','2-9, 11-18','D5-103','LT+BT',NULL,'Kết thúc đăng ký',40,0,'trungtt'),(90006,'MI1110',20171,3,'9h20 - 11h50','2-9, 11-18','D5-101','LT+BT',NULL,'Kết thúc đăng ký',100,0,'tungbt'),(90006,'MI1110',20171,6,'9h20 - 11h','2-9, 11-18','D5-101','LT+BT',NULL,'Kết thúc đăng ký',120,0,'tungbt'),(90007,'MI1110',20171,4,'12h30 - 15h','2-9, 11-18','D5-401','LT+BT',NULL,'Kết thúc đăng ký',120,0,'trungtt'),(90007,'MI1110',20171,6,'12h30 - 14h5','2-9, 11-18','D5-401','LT+BT',NULL,'Kết thúc đăng ký',100,0,'trungtt'),(90008,'MI1120',20171,2,'12h30 - 14h5','2-9, 11-18','D5-101','LT+BT',NULL,'Kết thúc đăng ký',90,0,'tungbt'),(90008,'MI1120',20171,3,'12h30 - 14h5','2-9, 11-18','D5-101','LT+BT',NULL,'Kết thúc đăng ký',80,0,'tungbt'),(90009,'MI1120',20171,4,'12h30 - 15h50','2-9, 11-18','D3-201','LT+BT',NULL,'Kết thúc đăng ký',89,0,'vupx'),(90010,'MI1120',20171,5,'12h30 - 15h50','2-9, 11-18','D3-201','LT+BT',NULL,'Kết thúc đăng ký',93,0,'vupx'),(90011,'MI1120',20171,3,'6h45 - 10h5','2-9, 11-18','D3-202','LT+BT',NULL,'Kết thúc đăng ký',100,0,'trungtt'),(90012,'MI1120',20171,6,'12h30 - 15h50','2-9, 11-18','D3-202','LT+BT',NULL,'Kết thúc đăng ký',120,0,'vupx'),(90013,'MI1130',20171,2,'6h45 - 10h5','2-9, 11-18','D3-205','LT+BT',NULL,'Kết thúc đăng ký',123,0,'vupx'),(90014,'MI1130',20171,3,'12h30 - 15h50','2-9, 11-18','D3-205','LT+BT',NULL,'Kết thúc đăng ký',111,0,'tungbt'),(90015,'MI1130',20171,4,'12h30 - 15h50','2-9, 11-18','D3-206','LT+BT',NULL,'Kết thúc đăng ký',121,0,'binhnt'),(90016,'MI1140',20171,2,'6h45 - 9h20','2-9, 11-18','D3-209','LT+BT',NULL,'Kết thúc đăng ký',110,0,'binhnt'),(90016,'MI1140',20171,5,'6h45 - 8h30','2-9, 11-18','D3-209','LT+BT','BK2.4, 2.5, 2.6, 2.7 K62S','Kết thúc đăng ký',121,0,'binhnt'),(90017,'MI1140',20171,3,'6h45 - 9h20','2-9, 11-18','D5-101','LT+BT','BK2.18, 2.19, 2.20, 2.21 K62S','Kết thúc đăng ký',122,0,'tungbt'),(90017,'MI1140',20171,4,'6h45 - 8h30','2-9, 11-18','D5-102','LT+BT','BK2.14, 2.15, 2.16, 2.17 K62S','Kết thúc đăng ký',80,0,'vupx'),(90018,'IT3090',20171,2,'12h30 - 15h50','2-9, 11-18','D5-105','LT+BT','Công nghệ thông tin K61C','Kết thúc đăng ký',90,0,'vupx'),(90019,'IT3090',20171,5,'12h30 - 15h50','2-9, 11-18','D5-107','LT+BT','Công nghệ thông tin K61C','Kết thúc đăng ký',44,0,'vupx'),(90020,'IT3090',20171,6,'12h30 - 15h50','2-9, 11-18','D5-109','LT+BT','Công nghệ thông tin K61C','Kết thúc đăng ký',44,3,'nampn'),(90021,'IT3020',20171,2,'6h45 - 10h5','2-9, 11-18','TC-201','LT+BT','Công nghệ thông tin K60S','Kết thúc đăng ký',111,0,'tungbt'),(90022,'IT3020',20171,3,'8h20 - 11h50','2-9, 11-18','TC-205','LT+BT','Công nghệ thông tin K60S','Kết thúc đăng ký',120,0,'tungbt'),(90023,'IT3020',20171,6,'6h45 - 10h5','2-9, 11-18','TC-209','LT+BT','Công nghệ thông tin K60S','Kết thúc đăng ký',100,0,'hiepnd'),(90024,'ET4310',20171,3,'12h30 - 15h','2-9, 11-18','TC-309','LT+BT','KTTT K58C','Kết thúc đăng ký',80,0,'nampn'),(90025,'ET4310',20171,6,'6h45 - 9h15','2-9, 11-18','TC-301','LT+BT','KTTT K58C','Kết thúc đăng ký',80,0,'nampn'),(90026,'IT3670',20171,2,'8h20 - 11h50','2-9, 11-18','B1-403','TH','Lớp hợp tác Samsung 01','Kết thúc đăng ký',40,0,'tungbt'),(90026,'IT3670',20171,5,'8h20 - 11h50','2-9, 11-18','B1-403','TH','Lớp hợp tác Samsung 02','Kết thúc đăng ký',40,0,'tungbt');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Course_AFTER_INSERT AFTER INSERT ON `course` FOR EACH ROW
BEGIN
    UPDATE coursecount
    SET numOfCourse = numOfCourse + 1
    WHERE coursecount.Faculty_id IN (
		SELECT sub.Faculty_id
        FROM subject AS sub
        WHERE sub.id = NEW.Subject_id)
	AND coursecount.term = NEW.term;
    
    UPDATE coursecount
    SET numOfCourse = numOfCourse + 1
    WHERE coursecount.Faculty_id = 0
	AND coursecount.term = NEW.term;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Course_AFTER_UPDATE AFTER UPDATE ON `course` FOR EACH ROW
BEGIN
    UPDATE coursecount
    SET numOfCourse = numOfCourse + 1
    WHERE coursecount.Faculty_id IN (
		SELECT sub.Faculty_id
        FROM subject AS sub
        WHERE sub.id = NEW.Subject_id)
	AND coursecount.term = NEW.term;
    
    UPDATE coursecount
    SET numOfCourse = numOfCourse - 1
    WHERE coursecount.Faculty_id IN (
		SELECT sub.Faculty_id
        FROM subject AS sub
        WHERE sub.id = OLD.Subject_id)
	AND coursecount.term = OLD.term;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Course_AFTER_DELETE AFTER DELETE ON `course` FOR EACH ROW
BEGIN
    UPDATE coursecount
    SET numOfCourse = numOfCourse - 1
    WHERE coursecount.Faculty_id IN (
		SELECT sub.Faculty_id
        FROM subject AS sub
        WHERE sub.id = OLD.Subject_id)
	AND coursecount.term = OLD.term;
    
    UPDATE coursecount
    SET numOfCourse = numOfCourse - 1
    WHERE coursecount.Faculty_id = 0
	AND coursecount.term = OLD.term;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `coursecount`
--

DROP TABLE IF EXISTS `coursecount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursecount` (
  `term` int(11) NOT NULL,
  `Faculty_id` tinyint(4) NOT NULL COMMENT 'nếu = 0 nghĩa là tất cả các khoa trong trường',
  `numOfCourse` int(11) DEFAULT NULL COMMENT 'Số lượng lớp học',
  PRIMARY KEY (`term`,`Faculty_id`),
  KEY `MaKhoa_idx` (`Faculty_id`),
  CONSTRAINT `MaKhoa_cc` FOREIGN KEY (`Faculty_id`) REFERENCES `faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursecount`
--

LOCK TABLES `coursecount` WRITE;
/*!40000 ALTER TABLE `coursecount` DISABLE KEYS */;
INSERT INTO `coursecount` VALUES (20171,0,35),(20171,1,8),(20171,2,8),(20171,4,19);
/*!40000 ALTER TABLE `coursecount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpa`
--

DROP TABLE IF EXISTS `cpa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cpa` (
  `Student_id` int(11) NOT NULL,
  `term` smallint(6) NOT NULL,
  `credits` tinyint(4) NOT NULL COMMENT 'Số tín chỉ học trong 1 kỳ',
  `accumulatedCredits` smallint(6) NOT NULL COMMENT 'Tổng số tín chỉ tích lũy từ đầu năm tới học kỳ đó',
  `GPA` float(3,2) NOT NULL,
  `CPA` float(3,2) NOT NULL,
  PRIMARY KEY (`Student_id`,`term`),
  CONSTRAINT `MaSV` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpa`
--

LOCK TABLES `cpa` WRITE;
/*!40000 ALTER TABLE `cpa` DISABLE KEYS */;
INSERT INTO `cpa` VALUES (20134509,20161,15,100,2.11,2.22),(20134509,20162,17,117,2.13,2.21),(20134509,20163,8,125,2.10,2.19),(20134509,20171,15,140,2.23,2.20);
/*!40000 ALTER TABLE `cpa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` tinyint(4) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên bộ môn (trong 1 khoa)',
  `Faculty_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `MaKhoa_d_idx` (`Faculty_id`),
  CONSTRAINT `MaKhoa_d` FOREIGN KEY (`Faculty_id`) REFERENCES `faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (11,'Khoa học máy tính',1),(12,'Hệ thống thông tin',1),(13,'CNPM',1),(14,'Kỹ thuật máy tính',1),(21,'KTĐT - KTMT',2),(22,'KTTT',2),(23,'KTYS',2),(24,'KTHK VT',2);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examschedule`
--

DROP TABLE IF EXISTS `examschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examschedule` (
  `id` smallint(6) NOT NULL COMMENT 'Mã lớp thi',
  `Course_id` int(11) NOT NULL COMMENT 'Mã lớp học',
  `room` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Phòng thi',
  `kip` tinyint(4) NOT NULL COMMENT 'Kíp thi',
  `day` date NOT NULL COMMENT 'Ngày thi (yyyy/MM/dd)',
  PRIMARY KEY (`id`),
  KEY `MaLopHoc_es_idx` (`Course_id`),
  CONSTRAINT `MaLopHoc_es` FOREIGN KEY (`Course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examschedule`
--

LOCK TABLES `examschedule` WRITE;
/*!40000 ALTER TABLE `examschedule` DISABLE KEYS */;
INSERT INTO `examschedule` VALUES (1,90001,'D5-103',1,'2017-12-10'),(2,90004,'TC-201',2,'2017-12-11'),(3,90002,'TC-201',1,'2017-12-10'),(5,90005,'D5-201',1,'2017-12-02'),(6,90006,'D5-205',1,'2017-12-01'),(7,90007,'D5-203',1,'2017-12-01'),(8,90013,'D3-203',3,'2017-12-03'),(9,90014,'D3-205',3,'2017-12-03'),(10,90015,'D3-209',3,'2017-12-03'),(11,80000,'D3-209',1,'2016-12-05'),(12,80008,'D3-207',2,'2016-12-03'),(13,80010,'D3-201',3,'2016-12-01'),(14,80012,'D3-203',4,'2016-12-09');
/*!40000 ALTER TABLE `examschedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `id` tinyint(4) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên khoa/viện',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (0,'All (tất cả)'),(1,'Công nghệ thông tin'),(2,'ĐTVT'),(3,'Tự động hóa'),(4,'Toán tin ứng dụng');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee`
--

DROP TABLE IF EXISTS `fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee` (
  `Student_id` int(11) NOT NULL,
  `term` smallint(6) NOT NULL,
  `numOfCredit` tinyint(4) NOT NULL COMMENT 'số tín chỉ bình thường',
  `extraNumOfCredit` tinyint(4) NOT NULL COMMENT 'số lượng tín chỉ đb (x1.5)',
  `creditFee` int(11) NOT NULL COMMENT 'giá mỗi tín chỉ',
  `extraFee` int(11) NOT NULL COMMENT 'Phụ phý',
  `total` int(11) NOT NULL COMMENT 'tổng học phí',
  PRIMARY KEY (`Student_id`,`term`),
  CONSTRAINT `MSSV_f` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee`
--

LOCK TABLES `fee` WRITE;
/*!40000 ALTER TABLE `fee` DISABLE KEYS */;
INSERT INTO `fee` VALUES (20134509,20161,20,0,200,0,4000),(20134509,20162,17,6,300,490,8290),(20134509,20171,14,0,300,500,4700);
/*!40000 ALTER TABLE `fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scoreboard`
--

DROP TABLE IF EXISTS `scoreboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scoreboard` (
  `Student_id` int(11) NOT NULL,
  `Course_id` int(11) NOT NULL,
  `processScore` float(3,1) DEFAULT '-1.0',
  `finalScore` float(3,1) DEFAULT '-1.0',
  `overall` float(3,1) DEFAULT '-1.0',
  `letterScore` varchar(2) CHARACTER SET utf8 DEFAULT 'F',
  PRIMARY KEY (`Student_id`,`Course_id`),
  KEY `MaLopHoc_idx` (`Course_id`),
  CONSTRAINT `MSSV` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MaLopHoc` FOREIGN KEY (`Course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scoreboard`
--

LOCK TABLES `scoreboard` WRITE;
/*!40000 ALTER TABLE `scoreboard` DISABLE KEYS */;
INSERT INTO `scoreboard` VALUES (20131000,80000,-1.0,-1.0,-1.0,'F'),(20131000,80008,-1.0,-1.0,-1.0,'F'),(20131000,80010,-1.0,-1.0,-1.0,'F'),(20131000,80012,-1.0,-1.0,-1.0,'F'),(20131000,85004,8.0,8.0,8.0,'B+'),(20131000,85007,4.0,4.0,4.0,'D'),(20131000,90001,6.0,4.0,4.6,'D'),(20131000,90020,-1.0,-1.0,-1.0,'F'),(20131001,90001,7.0,9.0,8.4,'B+'),(20131002,90001,-1.0,-1.0,-1.0,'F'),(20131003,90001,-1.0,-1.0,-1.0,'F'),(20131004,90001,-1.0,-1.0,-1.0,'F'),(20134509,80000,7.0,7.0,7.0,'B'),(20134509,80003,8.5,8.5,8.5,'A'),(20134509,80005,6.0,7.0,6.3,'C+'),(20134509,80007,7.0,5.0,5.8,'C'),(20134509,80009,10.0,10.0,10.0,'A+'),(20134509,85001,9.0,2.0,0.0,'F'),(20134509,85003,5.0,8.0,6.8,'C+'),(20134509,85006,3.0,3.0,0.0,'F'),(20134509,90001,-1.0,-1.0,-1.0,'F'),(20134509,90003,-1.0,-1.0,-1.0,'F'),(20134509,90004,-1.0,-1.0,-1.0,'F'),(20134510,90020,-1.0,-1.0,-1.0,'F'),(20134511,90020,-1.0,-1.0,-1.0,'F'),(20134513,90001,-1.0,-1.0,-1.0,'F'),(20134515,90001,-1.0,-1.0,-1.0,'F');
/*!40000 ALTER TABLE `scoreboard` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ScoreBoard_AFTER_INSERT AFTER INSERT ON `scoreboard` FOR EACH ROW
BEGIN
	UPDATE course SET registeredNum = registeredNum + 1 WHERE id = NEW.Course_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ScoreBoard_AFTER_UPDATE AFTER UPDATE ON `scoreboard` FOR EACH ROW
BEGIN
	UPDATE course SET registeredNum = registeredNum + 1 WHERE id = NEW.Course_id;
    UPDATE course SET registeredNum = registeredNum - 1 WHERE id = OLD.Course_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ScoreBoard_AFTER_DELETE AFTER DELETE ON `scoreboard` FOR EACH ROW
BEGIN
	UPDATE course SET registeredNum = registeredNum - 1 WHERE id = OLD.Course_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `educationProgram` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'chương trình đầo tạo (Cử nhân đtvt,...)',
  `heHoc` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Hệ học (CĐ, ĐH, Cao học...)',
  `status` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'trạng thái (Học, đã tốt nghiệp...)',
  `sex` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'giới tính',
  `address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo` longblob,
  `SVClass_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emai_s_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `MaLopSV_idx` (`SVClass_id`),
  CONSTRAINT `MaLopSV` FOREIGN KEY (`SVClass_id`) REFERENCES `svclass` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (20131000,'Nguyên bk','123','1995-01-01','Công nghệ thông tin - 2013','Cao học','Học','Bê đê','Hanoi','nguyenbk@gmail.com','0987643521',NULL,30458),(20131001,'Thanh Toàn','123','1995-01-02','Điện tử truyền thông - 2013','Đại học','Học','Bê đê','BG','toannoob@yahoo.com','0129132323',NULL,30458),(20131002,'Trần Quang Huy','123',NULL,NULL,NULL,NULL,NULL,'HN',NULL,NULL,NULL,30558),(20131003,'Phan Việt','123',NULL,NULL,NULL,NULL,NULL,'HN',NULL,NULL,NULL,30558),(20131004,'Bùi Duy Thông','123',NULL,NULL,NULL,NULL,NULL,'HCM',NULL,NULL,NULL,30558),(20134509,'Tạ Anh Tú','1','1995-11-05','Điện tử truyền thông - 2013','Đại học','Học','Nam','Ha Noi','taanhtu95@gmail.com','0974999999',NULL,30458),(20134510,'Sanji Nguyễn','123',NULL,NULL,NULL,NULL,NULL,'Cà Mau',NULL,NULL,NULL,121061),(20134511,'Monkey D.Luffy','123',NULL,NULL,NULL,NULL,NULL,'West Blue',NULL,NULL,NULL,121061),(20134513,'Nami','123',NULL,NULL,NULL,NULL,NULL,'Kyoto',NULL,NULL,NULL,121061),(20134515,'Portgas D.Ace','123',NULL,NULL,NULL,NULL,NULL,'East Blue',NULL,NULL,NULL,121061),(20134516,'Giang','123',NULL,NULL,NULL,NULL,NULL,'Đéo biết :v',NULL,NULL,NULL,30458),(20134517,'Huy gà','123',NULL,NULL,NULL,NULL,NULL,'Vô gia cư',NULL,NULL,NULL,30458);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Student_AFTER_INSERT AFTER INSERT ON `student` FOR EACH ROW
BEGIN
    UPDATE svclass SET numOfStudent = numOfStudent + 1 WHERE id = NEW.SVClass_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Student_AFTER_UPDATE AFTER UPDATE ON `student` FOR EACH ROW
BEGIN
	UPDATE svclass SET numOfStudent = numOfStudent + 1 WHERE id = NEW.SVClass_id;
    UPDATE svclass SET numOfStudent = numOfStudent - 1 WHERE id = OLD.SVClass_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Student_AFTER_DELETE AFTER DELETE ON `student` FOR EACH ROW
BEGIN
	UPDATE svclass SET numOfStudent = numOfStudent - 1 WHERE id = OLD.SVClass_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `id` char(10) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Mã học phần',
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `credit` tinyint(4) NOT NULL COMMENT 'số tín chỉ',
  `feeCredit` float(2,1) NOT NULL COMMENT 'tín chỉ học phý',
  `weight` float(2,1) NOT NULL DEFAULT '0.7' COMMENT 'trọng số (VD: 0.7)',
  `teachingWeight` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT 'khối lượng giảng dạy (VD: 3-1-0-6)',
  `Faculty_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `MaKhoa_sj_idx` (`Faculty_id`),
  CONSTRAINT `MaKhoa_sj` FOREIGN KEY (`Faculty_id`) REFERENCES `faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES ('ET4060','Phân tích và thiết kế hướng đối tượng',3,4.0,0.7,'3-1-0-6',2),('ET4230','Mạng máy tính',3,4.0,0.7,'3-0-1-6',2),('ET4290','Hệ điều hành',2,3.0,0.7,'2-1-0-4',2),('ET4310','Thông tin quang',3,4.0,0.7,'3-0-1-6',2),('ET4340','VLSI',3,5.0,0.7,'3-1-0-6',2),('ET4360','Thiết kế hệ nhúng',2,3.0,0.7,'2-1-0-4',2),('ET4430','Lập trình nâng cao',2,3.0,0.6,'2-1-0-4',2),('ET5020','Đồ án thiết kế III',3,6.0,0.7,'0-0-6-6',2),('IT3010','CTDL và giải thuật',3,4.5,0.7,'3-1-0-6',1),('IT3020','Toán rời rạc',3,5.0,0.7,'3-1-0-6',1),('IT3030','Kiến trúc máy tính',3,4.0,0.7,'3-1-0-6',1),('IT3090','Cơ sở dữ liệu',3,4.0,0.7,'3-1-0-6',1),('IT3650','Lập trình Java',3,6.0,0.7,'0-0-6-6',1),('IT3670','Lập trình ứng dụng Tizen ',3,5.0,0.7,'0-0-4-8',1),('IT4040','Trí tuệ nhân tạo',4,4.0,0.7,'3-1-0-6',1),('IT4895','CN web tiên tiến',2,3.0,0.7,'2-1-0-4',1),('MI1110','Giải tích I',4,5.0,0.7,'3-2-0-8',4),('MI1120','Giải tích II',3,4.0,0.7,'2-2-0-6',4),('MI1130','Giải tích III',3,4.0,0.7,'2-2-0-6',4),('MI1140','Đại số',4,5.0,0.7,'3-2-0-8',4);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Subject_AFTER_INSERT AFTER INSERT ON `subject` FOR EACH ROW
BEGIN
    UPDATE subjectcount
    SET numOfSubject = numOfSubject + 1
    WHERE subjectcount.Faculty_id = NEW.Faculty_id;
    
    UPDATE subjectcount
    SET numOfSubject = numOfSubject + 1
    WHERE subjectcount.Faculty_id = 0;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Subject_AFTER_UPDATE AFTER UPDATE ON `subject` FOR EACH ROW
BEGIN
    UPDATE subjectcount
    SET numOfSubject = numOfSubject + 1
    WHERE subjectcount.Faculty_id = NEW.Faculty_id;
    
    UPDATE subjectcount
    SET numOfSubject = numOfSubject - 1
    WHERE subjectcount.Faculty_id = OLD.Faculty_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Subject_AFTER_DELETE AFTER DELETE ON `subject` FOR EACH ROW
BEGIN
    UPDATE subjectcount
    SET numOfSubject = numOfSubject - 1
    WHERE subjectcount.Faculty_id = OLD.Faculty_id;
    
    UPDATE subjectcount
    SET numOfSubject = numOfSubject - 1
    WHERE subjectcount.Faculty_id = 0;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `subjectcount`
--

DROP TABLE IF EXISTS `subjectcount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjectcount` (
  `Faculty_id` tinyint(4) NOT NULL,
  `numOfSubject` int(11) DEFAULT NULL COMMENT 'số lượng học phần',
  PRIMARY KEY (`Faculty_id`),
  CONSTRAINT `MaKhoa_cs` FOREIGN KEY (`Faculty_id`) REFERENCES `faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectcount`
--

LOCK TABLES `subjectcount` WRITE;
/*!40000 ALTER TABLE `subjectcount` DISABLE KEYS */;
INSERT INTO `subjectcount` VALUES (0,20),(1,8),(2,8),(4,4);
/*!40000 ALTER TABLE `subjectcount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `svclass`
--

DROP TABLE IF EXISTS `svclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `svclass` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `numOfStudent` int(11) NOT NULL,
  `monitor_id` int(11) DEFAULT NULL,
  `Teacher_id` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Faculty_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `LopTruong_svc_idx` (`monitor_id`),
  KEY `GVChuNhiem_svc_idx` (`Teacher_id`),
  KEY `Khoa_svc_idx` (`Faculty_id`),
  CONSTRAINT `GVChuNhiem_svc` FOREIGN KEY (`Teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Khoa_svc` FOREIGN KEY (`Faculty_id`) REFERENCES `faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `LopTruong_svc` FOREIGN KEY (`monitor_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `svclass`
--

LOCK TABLES `svclass` WRITE;
/*!40000 ALTER TABLE `svclass` DISABLE KEYS */;
INSERT INTO `svclass` VALUES (30358,'ĐTTT 03 - K58',0,NULL,NULL,2),(30458,'ĐTTT 04 - K58',5,NULL,NULL,2),(30558,'ĐTTT 05 - K58',3,NULL,NULL,2),(110560,'CNTT1.05 - K60',0,NULL,NULL,1),(121061,'CNTT2.10 - K61',4,NULL,NULL,1);
/*!40000 ALTER TABLE `svclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Department_id` tinyint(4) NOT NULL,
  `workplace` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `website` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo` blob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `MaBoMon_t_idx` (`Department_id`),
  CONSTRAINT `MaBoMon_t` FOREIGN KEY (`Department_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('binhnt','Nguyễn Thanh Bình','123','1975-04-30',NULL,'binhnt1974@gmail.com','0923992',21,'C9 - 401','binhnguyen.com.vn',NULL),('chuyennt','Nguyễn Thành Chuyên','123','1975-04-22',NULL,'chuyennt@hust.edu.vn','093232189',22,'C9 - 402','chuyennt.com.vn',NULL),('cuongvl','Võ Lê Cường','123','1975-04-22',NULL,'cuongvl@hust.edu.vn','093232992',21,'C9 - 403','cuongvl.set.edu.vn',NULL),('hiepnd','Nguyễn Duy Hiệp','123','1975-04-12',NULL,'hiepnd@gmail.com','4243243242',11,'C9 - 404','soict.edu.vn/~hiepnd',NULL),('khoattq','Thân Quang Khoát','123','1975-04-11',NULL,'khoattq@hust.edu.vn','432532432',12,'B1 - 702','is.hust.edu.vn/~khoattq',NULL),('minhnd','Nguyễn Đức Minh','123','1975-04-12',NULL,'minh@yahoo.com','324324324',21,'B1 - 703','minhnd.set.edu.vn',NULL),('nampn','Phạm Ngọc Nam','1','1975-04-03',NULL,'nampn@gmail.com','08987675',21,'B1 - 701','set.hust.edu.vn/~nampn',NULL),('thanhnh','Nguyễn Hữu Thanh','123','1975-04-05',NULL,'thanhnh@hust.set.com','086855678',22,'B1 - 909','thanh.com',NULL),('trungtt','Trịnh Thành Trung','123','1975-04-15',NULL,'trung.it@gmail.com','0973534534',13,'B1 - 1702','trungtt.com.vn',NULL),('tungbt','Bùi Trọng Tùng','123','1975-04-03',NULL,'tung@yahoo.com','09867543242',12,'D5 - 701','tungbt.com.cn',NULL),('vupx','Phan Xuân Vũ','123','1975-04-30',NULL,'vu@gmail.com','096756343',21,'D5 - 704','vupx.com.jp',NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-11 18:43:42
