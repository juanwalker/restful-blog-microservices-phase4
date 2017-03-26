-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: restful_blog_author
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'admin','admin','admin','admin@benjsicam.me'),(2,'user','Juan','dela Cruz','info@benjsicam.me'),(3,'user29','Benj29','Sicam29','info29@benjsicam.me'),(4,'user28','Benj28','Sicam28','info28@benjsicam.me'),(5,'user2','Benj28','Sicam28','info28@benjsicam.me'),(7,'user28','Benj28','Sicam28','info28@benjsicam.me'),(8,'user28','Benj28','Sicam28','info28@benjsicam.me'),(9,'user28','Benj28','Sicam28','info28@benjsicam.me'),(10,'user2','Benj28','Sicam28','info28@benjsicam.me'),(11,'user2','Benj28','Sicam28','info28@benjsicam.me'),(12,'user2222222222222222','Benj28','Sicam28','info28@benjsicam.me'),(13,'user2222222222222222','Benj28','Sicam28','info28@benjsicam.me'),(14,'user28','Benj28','Sicam28','info28@benjsicam.me'),(15,'user28','Benj28','Sicam28','info28@benjsicam.me'),(16,'user28','Benj28','Sicam28','info28@benjsicam.me'),(17,'user28','Benj28','Sicam28','info28@benjsicam.me'),(18,'user28','Benj28','Sicam28','info28@benjsicam.me'),(19,'user28','Benj28','Sicam28','info28@benjsicam.me'),(20,'user28','Benj28','Sicam28','info28@benjsicam.me');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-23 21:16:39
