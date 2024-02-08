-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 13.233.146.209    Database: spiritualtraveller
-- ------------------------------------------------------
-- Server version	5.7.40-0ubuntu0.18.04.1

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `heading` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `about`
--

LOCK TABLES `about` WRITE;
/*!40000 ALTER TABLE `about` DISABLE KEYS */;
INSERT INTO `about` VALUES (4,'Here, I focus on a range of items and features that we use in life without giving them a second thought.','Who We Are ?','202210171646-about-img.jpg');
/*!40000 ALTER TABLE `about` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin@123','1234567896','Admin','1234','admin','Active');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog1` varchar(255) DEFAULT NULL,
  `blogimage` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `heading` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'Acres of Diamonds… you’ve read the famous story, or at least had it related to you. A farmer.','202210171628-d1.jpg','2022-09-05','Holiday Sea beach Blue Ocean'),(2,'Acres of Diamonds… you’ve read the famous story, or at least had it related to you. A farmer.','202210171629-b1.jpg','2022-07-20','It\'s Classified How To Utilize Free'),(3,'Acres of Diamonds… you’ve read the famous story, or at least had it related to you. A farmer.','202210171629-b3.jpg','2022-05-12','Holiday Sea beach Blue Ocean'),(4,'Acres of Diamonds… you’ve read the famous story, or at least had it related to you. A farmer.','202210171630-d3.jpg','2022-10-21','Holiday Sea beach Blue Ocean');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_from` varchar(255) DEFAULT NULL,
  `book_to` varchar(255) DEFAULT NULL,
  `booking_date` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `mobileno` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `persons` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (21,'Pune','nagpur','2022-11-09 ','2022-11-15','8767676767','Dushyant Lilhare','6','Completed'),(2,'Punedd','Mumbai','','2022-10-20','1234567890','sunita','2','Reject'),(3,'234','45','2022-10-18 ','2022-10-20','1234567890','test','3','New Booking'),(9,'Pune','Nashik ','2022-10-18 ','2022-10-20','7822825686','Govind','6','New Booking'),(10,'Pune','Mumbai','2022-10-18 ','2022-10-19','1234567892','Abc','1','New Booking'),(11,'Pune','Nashik ','2022-10-19 ','2022-10-20','7822825686','Govind','5','New Booking'),(12,'pune','Mumbai','2022-10-19 ','2022-10-22','1234567890','sunita','5','New Booking'),(14,'Nagar','Pune','2022-10-20 ','2022-02-21','1234567890','Test','4','New Booking'),(16,'Nagar','Pune','2022-10-21 ','12022-02-21','1234567890','Test','4','New Booking'),(17,'Nagar','Pune','2022-10-21 ','12022-02-21','1234567890','Test','4','New Booking'),(18,'Pune','Nashik ','2022-10-21 ','2022-10-22','7822825686','Govind','5','New Booking'),(20,'Pune','Mumbai','2022-11-09 ','2022-11-09','1234567890','Abcd','5','New Booking'),(22,'banglore ','chennai','2022-11-09 ','2022-11-20','8767676767','Gaurav Tidke','2','New Booking'),(23,'pune','aurangabad','2022-11-09 ','2022-11-03','1234567899','snehal koravi','6','New Booking');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination`
--

DROP TABLE IF EXISTS `destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `destinations` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination`
--

LOCK TABLES `destination` WRITE;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` VALUES (1,'Nagpur','202210171616-th-(1).jpg','1000'),(2,'Pune','202210171621-th.jpg','800'),(3,'Delhi','202210171622-th-(3).jpg','800');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packagefield`
--

DROP TABLE IF EXISTS `packagefield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packagefield` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `extras` varchar(255) DEFAULT NULL,
  `heading` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packagefield`
--

LOCK TABLES `packagefield` WRITE;
/*!40000 ALTER TABLE `packagefield` DISABLE KEYS */;
INSERT INTO `packagefield` VALUES (1,'2022-10-14','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210171649-d1.jpg','450','India'),(2,'2022-10-29','06 days and 7 nights','All Inclusive','Did not find your Package? ','202210171704-d2.jpg','8000','Maharashtra'),(3,'2022-10-20','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210171705-d3.jpg','400','India'),(4,'2022-12-14','06 days and 7 nights','All Inclusive','It\'s Classified How To Utilize Free','202210171706-d4.jpg','1000','Maharashtra'),(5,'2022-10-28','06 days and 7 nights','All Inclusive','Holiday Sea beach Blue Ocean','202210171706-d5.jpg','650','India'),(6,'2022-10-19','06 days and 7 nights','All Inclusive','It\'s Classified How To Utilize Free','202210171707-d6.jpg','5000','Maharashtra');
/*!40000 ALTER TABLE `packagefield` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testimonial`
--

DROP TABLE IF EXISTS `testimonial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testimonial` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `feedback` varchar(255) DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testimonial`
--

LOCK TABLES `testimonial` WRITE;
/*!40000 ALTER TABLE `testimonial` DISABLE KEYS */;
INSERT INTO `testimonial` VALUES (1,'A purpose is the eternal condition for success. Every 								former smoker can tell you just how hard it is to stop smoking 								cigarettes. However.','202210171624-c2.jpg','Unmesh Chaudhari','5'),(2,'Doyou want to be even more successful? Learn to love 								learning and growth. The more effort you put into improving skills, the bigger the payoff you.','202210171625-c5.jpg','Govind Chaudhari','4'),(3,'A purpose is the eternal condition for success. Every 								former smoker can tell you just how hard it is to stop smoking 								cigarettes. However.','202210171626-user-info.png','Dushyant Lihare','5');
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

-- Dump completed on 2022-11-17 12:36:29
