-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: restful_blog_auth
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
-- Table structure for table `credentials`
--

DROP TABLE IF EXISTS `credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credentials` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credentials`
--

LOCK TABLES `credentials` WRITE;
/*!40000 ALTER TABLE `credentials` DISABLE KEYS */;
INSERT INTO `credentials` VALUES (1,'admin','$2a$10$FFcpaxur8XhBg6toxZMYZeWlWRM9EeBKObcs.y0/AVSB6etKDpgR.'),(2,'user','$2a$10$4nz/lAntXH017MFHPX1R5.m3YEAhVICaJtrQUP87ZvGr1dEIKNyPq'),(3,'user29','$2a$10$jf88f7jeL5O8y3y1GyedYuQYaZgWX/NimWiYHCltZFDchko5h/tcm'),(4,'user28','$2a$10$fjU/NZ3bvWLwqW4qfMqHTOMNmQAOv6/TusVktAffA2sOIflPoQYFe'),(5,'user2','$2a$10$fK9HR4etSW0iyT345o58LOGntyXgy1zP5JrtFh169SmOQtX20t.Ky'),(7,'user28','$2a$10$WGP9LVuidWtx62hA8HSttur3.FAfgWdxkqXzOUAHp6/88GArUwKru'),(8,'user28','$2a$10$5062XNbFF8rC11neD2Xfx.i1F3rNKpwfUhK3ZH9SPbbNV3mtiLhey'),(9,'user28','$2a$10$c8.AxctIHS5NZWqqbgxC4uyo8gESxAAL2UVWMjQnvBpC.fL5aHxXa'),(10,'user2','$2a$10$KDXixCbxoBy377ZUbh/JIuodc2QqANOlZdwsnvrAs94q8AZKKFGf.'),(11,'user2','$2a$10$8rcqWO4NSzlD.aOS79gGZuIS/6nb0vAzzrZV2vlMMVlcilLxoo3fe'),(12,'user2222222222222222','$2a$10$Ne9qspWS38gygBygtBXVIeAYsvXPI73g8JvOpulNDwGLYeWwAap6e'),(13,'user2222222222222222','$2a$10$ZRtBoRzTPAZ6vIDp82bYZ.3ObZj5D0mIgbN1S89wi8SGuUeqb0p3C'),(14,'user28','$2a$10$4az5TSAV/QxAhG5R6dlVduQhQ7jH6PB1L2HAKN8tVAHnXz5Is8wlC'),(15,'user28','$2a$10$JNnzsWPdBKmnuHrJkGALZ.TYaiTPUuPktmgDYWMsru.BuLFJ/x1s2'),(16,'user28','$2a$10$4SHgByhR3inEFcuSmNedDewFh9.Vzh5f51oHXfmqcMYP6Z.gm2Q6G'),(17,'user28','$2a$10$zS5FwFzq.LAimC.lglw/I.ej78RC85ZYujoQLbmqPdnEymMzXSt5G'),(18,'user28','$2a$10$85D5naqQS94Fp55lv0Buae7a4wDw3Cidi.pdi.C2HHa2lqzgb8Idy'),(19,'user28','$2a$10$QsEByfjkZA4ZET.aK03lF.tb/pXQI5PRhU8NoRp7gcZ38hzysolqW'),(20,'user28','$2a$10$2Omp.3uyS3l15R573bYNsuuRA.Jcxako4QmSE8ziGBY35bSmb2dl6');
/*!40000 ALTER TABLE `credentials` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-23 21:14:54
