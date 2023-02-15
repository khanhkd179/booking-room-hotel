-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: simplehotelmanagement
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `booked_room`
--

DROP TABLE IF EXISTS `booked_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booked_room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `booking_id` int DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_room_idx` (`room_id`),
  KEY `FK_booking_idx` (`booking_id`),
  CONSTRAINT `FK_booking` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `FK_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booked_room`
--

LOCK TABLES `booked_room` WRITE;
/*!40000 ALTER TABLE `booked_room` DISABLE KEYS */;
INSERT INTO `booked_room` VALUES (5,'2023-02-17','2023-02-24',200,10,5),(6,'2023-02-17','2023-02-24',200,11,10),(7,'2023-02-17','2023-02-24',100,11,13),(8,'2023-02-24','2023-02-25',120,12,8),(9,'2023-02-24','2023-02-25',200,12,12),(10,'2023-02-17','2023-02-18',120,13,2),(11,'2023-02-17','2023-02-18',200,13,10),(12,'2023-02-17','2023-02-19',100,14,13),(13,'2023-02-17','2023-02-19',200,14,16);
/*!40000 ALTER TABLE `booked_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_day` date NOT NULL,
  `client_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Booking_Client_idx` (`employee_id`),
  KEY `FK_Booking_Client_idx1` (`client_id`),
  CONSTRAINT `FK_Booking_Client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FK_Booking_Employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (10,'2023-02-15',27,2),(11,'2023-02-15',27,2),(12,'2023-02-15',28,2),(13,'2023-02-15',28,2),(14,'2023-02-15',2,1);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `tel` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tel_UNIQUE` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'do huy','dohuy@gmail.com','hanoi','0123456789'),(2,'nam hai','namhai@gmail.com','hanoi','0987654321'),(3,'Khanh','khanh@gmail.com','HN','khanh@gmail.com'),(27,'Khuat Duy Khanh','khuatduykhanh179@gmail.com','HN','0866867900'),(28,'Khuat Duy Khah','sdfsdf','dfsdf','0763012661');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'monkay','123456','Khuat Duy Khanh'),(2,'1','1','Monkay');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Room_Type_idx` (`type_id`),
  CONSTRAINT `FK_Room_Type` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'101',100,1),(2,'102',120,2),(3,'103',150,3),(4,'104',200,4),(5,'105',200,5),(6,'106',200,6),(7,'201',100,1),(8,'202',120,2),(9,'203',150,3),(10,'204',200,4),(11,'205',200,5),(12,'206',200,6),(13,'301',100,1),(14,'302',120,2),(15,'303',150,3),(16,'304',200,4),(17,'305',200,5),(18,'306',200,6);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (2,'Double'),(6,'King'),(4,'Quad'),(5,'Queen'),(1,'Single'),(3,'Triple');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-15 17:20:16
