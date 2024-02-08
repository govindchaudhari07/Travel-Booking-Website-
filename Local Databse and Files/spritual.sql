-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travel_db
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `about`
--

DROP TABLE IF EXISTS `about`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `about` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `heading` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `about`
--

LOCK TABLES `about` WRITE;
/*!40000 ALTER TABLE `about` DISABLE KEYS */;
INSERT INTO `about` VALUES (2,'We all live in an age that belongs to the young at heart. Life that is becoming extremely fast, day.','Who We Are?','202210051245-about-img.jpg');
/*!40000 ALTER TABLE `about` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin@123','7822825686','Admin','1234','Admin','Active');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `blog1` varchar(255) DEFAULT NULL,
  `blogimage` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `heading` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (2,'Acres of Diamonds… you’ve read the famous story, or at least had it related to you. A farmer.','202210041610-d3.jpg','2022-10-22','It\'s Classified How To Utilize Free'),(3,'Acres of Diamonds… you’ve read the famous story, or at least had it related to you. A farmer.','202210041611-b1.jpg','2022-10-14','Creative Outdoor Ads'),(4,'Acres of Diamonds… you’ve read the famous story, or at least had it related to you. A farmer.','202210041612-b3.jpg','2022-10-16','Low Cost Advertising'),(7,'Acres of Diamonds… you’ve read the famous story, or at least had it related to you. A farmer.','202210041620-d1.jpg','2022-10-15','It\'s Classified How To Utilize Free');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `book_from` varchar(255) DEFAULT NULL,
  `book_to` varchar(255) DEFAULT NULL,
  `booking_date` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `mobileno` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `persons` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (18,'Agra','Pune','2022-10-19','2022-10-19','7822825686','govind','2','Confirm'),(22,'Agra','Pune','2022-10-14 ','2022-10-19','7822825686','Unmesh','2','Confirm'),(23,'Agra','Pune','2022-10-14 ','2022-10-19','7822825686','Admin','5','Confirm'),(27,'Agra','Pune','2022-10-17 ','2022-10-06','7822825686','govind','5','Completed'),(28,'Agra','Pune','2022-10-17 ','2022-10-06','7822825686','Admin','5','Completed'),(32,'11','Pune','2022-10-18 ','2022-09-28','7822825686','Admin','5','Reject'),(33,'Agra11','Pune','2022-10-18 ','2022-10-07','7822825686','Unmesh','4','New Booking'),(34,'Agra','Pune','2022-10-18 ','2022-10-07','7822825686','govind','4','New Booking'),(35,'Agra','Pune','2022-10-19 ','2022-09-27','7822825686','govind','5','New Booking'),(36,'Agra','Pune','2022-10-19 ','2022-10-08','7822825686','govind','5','New Booking'),(37,'Agra','Pune','2022-10-19 ','2022-10-07','7822825686','govind','1','New Booking'),(38,'Agra','Pune','2022-10-19 ','2022-10-21','7822825686','Admin','4','New Booking'),(39,'Mumbai','Pune','2022-10-19 ','2022-10-28','7822825686','Unmesh','2','Confirm'),(40,'Agra','Pune','2022-10-19 ','2022-10-21','7822825686','Unmesh','2','New Booking'),(41,'Agra','Pune','2022-10-19 ','2022-10-06','7822825686','Admin','2','New Booking'),(42,'Agra','Pune','2022-10-19 ','2022-10-14','7822825686','Admin','1','New Booking'),(43,'Agra','Pune','2022-10-19 ','2022-10-13','7822825686','Admin','5','New Booking'),(44,'Agra','Pune','2022-10-19 ','2022-09-30','7822825686','govind','2','New Booking'),(45,'Mumbai','Pune','2022-10-19 ','2022-10-05','7822825686','govind','2','New Booking'),(46,'Agra','Pune','2022-10-19 ','2022-10-08','7822825686','Admin','2','New Booking'),(47,'Agra','Pune','2022-10-19 ','2022-10-08','7822825686','Unmesh','2','New Booking'),(48,'Agra','Pune','2022-10-19 ','2022-10-14','7822825686','Admin','2','New Booking'),(49,'Agra','Pune','2022-10-19 ','2022-10-19','7822825686','Unmesh','5','New Booking');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination`
--

DROP TABLE IF EXISTS `destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destination` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `destinations` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination`
--

LOCK TABLES `destination` WRITE;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` VALUES (51,'Rajasthan','202210071127-d2.jpg','1000'),(15,'Mumabi','202210031719-th-(1).jpg','800'),(78,'Mumbai','202210191556-hot-deal.jpg','300');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packagefield`
--

DROP TABLE IF EXISTS `packagefield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packagefield` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `extras` varchar(255) DEFAULT NULL,
  `heading` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packagefield`
--

LOCK TABLES `packagefield` WRITE;
/*!40000 ALTER TABLE `packagefield` DISABLE KEYS */;
INSERT INTO `packagefield` VALUES (2,'2022-10-21','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210061507-d1.jpg','500','United staes of America'),(3,'2022-10-15','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210061513-d2.jpg','2000','Maharashtra'),(4,'2022-10-23','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210061513-d3.jpg','3000','India'),(5,'2022-10-27','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210061514-d4.jpg','4000','Maharashtra'),(6,'2022-10-04','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210061514-d5.jpg','5000','Maharashtra'),(7,'2022-11-03','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210061516-d6.jpg','6000','Maharashtra');
/*!40000 ALTER TABLE `packagefield` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testimonial`
--

DROP TABLE IF EXISTS `testimonial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testimonial` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `feedback` varchar(255) DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testimonial`
--

LOCK TABLES `testimonial` WRITE;
/*!40000 ALTER TABLE `testimonial` DISABLE KEYS */;
INSERT INTO `testimonial` VALUES (26,'Do you want to be even more successful? Learn to love 								learning and growth. The more effort you put into improving skills, the bigger the payoff you.','202210191558-c1.jpg','Sonali','4'),(27,'Do you want to be even more successful? Learn to love learning and growth. The more effort you put into improving your skills, the bigger the payoff you.','202210191602-c2.jpg','Govind','5'),(28,'Doyou want to be even more successful? Learn to love 								learning and growth. The more effort you put into improving skills, the bigger the payoff you.','202210191602-c5.jpg','Ajay ','4');
/*!40000 ALTER TABLE `testimonial` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-17 13:00:59
