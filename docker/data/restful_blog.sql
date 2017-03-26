-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: restful_blog
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
  `email` varchar(50) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'info@benjsicam.me','Benj','Sicam','$2a$10$4nz/lAntXH017MFHPX1R5.m3YEAhVICaJtrQUP87ZvGr1dEIKNyPq','admin'),(2,'info@benjsicam.me','Juan','dela Cruz','$2a$10$NtDZRpRKw190x5QR/oNCMuW5Ff6yx4klaw.Qd5PP2/i8DXjZzqHaG','user');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'General'),(2,'News'),(3,'Announcements');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `date` date DEFAULT NULL,
  `author` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `post_author` (`author`),
  CONSTRAINT `post_author` FOREIGN KEY (`author`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus bibendum, lorem sit amet hendrerit consequat, lorem massa pellentesque odio, et dapibus turpis sem ut nibh. Maecenas luctus eros magna. In hac habitasse platea dictumst. Proin nisi nunc, consectetur ac porttitor a, interdum sit amet massa. Phasellus vulputate imperdiet mauris, eu aliquam odio feugiat vel. Duis quis malesuada velit. Ut facilisis sem non ante dapibus tempor. Nulla arcu metus, varius sed laoreet vitae, tempor vel urna. Vestibulum et interdum elit.','2013-05-07',1),(2,'Sed id nunc in nisi pellentesque commodo. Donec malesuada, purus volutpat auctor accumsan, ante arcu scelerisque tellus, eget vulputate eros nisl at dolor. Etiam sit amet risus eget risus sodales tincidunt in ac orci. Curabitur suscipit rhoncus urna. Vestibulum ligula neque, vulputate vel vulputate non, luctus nec massa. Mauris ligula dui, rutrum sed condimentum non, dictum vitae risus. Sed eros ligula, auctor vitae porttitor elementum, iaculis non diam. Nullam euismod fermentum mi at pretium. Sed cursus, elit quis pharetra imperdiet, dolor nisi rhoncus neque, ac laoreet ipsum ligula ut elit. Donec sit amet velit mauris, sed dictum lorem. Vestibulum dignissim convallis mattis. Integer libero erat, rhoncus id interdum ac, vulputate vel justo. Aliquam ac est eu orci tincidunt ullamcorper sed sed sapien.','2013-05-08',1),(3,'Ut neque purus, convallis eget dictum ut, convallis ut nisi. Aenean auctor laoreet lacus, molestie placerat elit tincidunt sed. Pellentesque ullamcorper, mauris vel lacinia elementum, purus lectus porttitor risus, ac pellentesque felis nisi ut diam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nam rutrum metus sit amet ligula sollicitudin tincidunt. Integer rutrum neque sed odio varius ac luctus turpis varius. Aliquam interdum molestie orci, a vulputate mauris viverra et. Curabitur ipsum mi, facilisis vel venenatis et, scelerisque eu augue. Nulla facilisi.','2013-05-09',1),(4,'Nulla id turpis ipsum, sed consequat diam. Morbi pellentesque accumsan ultrices. Quisque est neque, pretium nec placerat id, varius eget turpis. In hac habitasse platea dictumst. Nunc tortor lacus, gravida non tincidunt ut, scelerisque ut velit. Donec porttitor metus non quam pulvinar posuere. Quisque venenatis lectus sit amet leo convallis blandit. Donec a nisl diam. Nunc ac nisi sit amet risus ullamcorper sodales pulvinar ac massa. Morbi adipiscing, lacus pellentesque imperdiet porttitor, elit magna accumsan risus, nec hendrerit odio felis eu enim. Fusce odio lacus, consectetur vel dignissim eu, fringilla nec justo. Phasellus eu nunc metus. Suspendisse potenti. Nam varius libero non mauris aliquet vehicula.','2013-05-10',2),(5,'Curabitur vel massa nec purus dictum dignissim. Nullam aliquam vestibulum risus. Etiam hendrerit justo in dui laoreet laoreet. Donec a dui nulla. Proin sagittis tortor odio, sed faucibus velit. Maecenas a tortor sem, iaculis molestie quam. Donec in enim felis, ac accumsan lorem. Cras tempus, justo sed luctus ullamcorper, purus elit pulvinar lacus, non rutrum quam purus id elit. Duis quis purus ut ligula feugiat cursus sed in arcu. Curabitur blandit, neque ac vestibulum interdum, orci tortor pulvinar purus, quis tincidunt justo nisi eu felis. Integer faucibus rutrum odio, quis dignissim orci pulvinar et. Donec urna eros, faucibus at volutpat vitae, porta id sapien. Vestibulum tempus, risus ullamcorper facilisis tristique, sem ligula cursus neque, a ultricies ante nunc quis sapien. Sed sed erat odio, vel feugiat erat.','2013-05-11',2),(6,'Praesent ac dui risus. Nam in est risus, ultricies accumsan mauris. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus interdum nisi id neque blandit ornare sit amet non arcu. Donec sit amet velit sem. Proin eros nisi, ultrices nec dapibus dictum, laoreet non libero. Nulla facilisi. Duis sit amet elit enim. Nulla tellus nibh, ornare sit amet cursus et, pellentesque vel enim. Aliquam bibendum vehicula lorem ut dictum.','2013-05-12',2);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_category`
--

DROP TABLE IF EXISTS `post_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_category` (
  `post_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`post_id`,`category_id`),
  KEY `post_category_category` (`category_id`),
  KEY `post_category_post` (`post_id`),
  CONSTRAINT `post_category_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `post_category_post` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_category`
--

LOCK TABLES `post_category` WRITE;
/*!40000 ALTER TABLE `post_category` DISABLE KEYS */;
INSERT INTO `post_category` VALUES (1,1),(4,1),(2,2),(5,2),(3,3),(6,3);
/*!40000 ALTER TABLE `post_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-23 21:10:08
