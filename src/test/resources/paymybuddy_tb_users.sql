-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: paymybuddy
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
-- Table structure for table `tb_users`
--

DROP TABLE IF EXISTS `tb_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKntr5lb4lee7dac7lpkeebkjin` (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users`
--

LOCK TABLES `tb_users` WRITE;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
INSERT INTO `tb_users` VALUES (1,'2022-12-21 16:15:47','louis@gmail.fr','Louis','Lapedale','$2a$10$nmmgNyDho37C7Pn6K01KU.KhePsrzNnd4bJzvF1VkhXRtMFDGJYy2',1),(2,'2022-12-21 16:16:56','andrea@gmail.fr','Andréa','Litalrien','$2a$10$bw43cxN71QHqXIR1P0P5z.SgFqOS//M2xBc.I7WUY.kwytvcypsFm',2),(3,'2022-12-21 16:17:24','estelle@gmail.fr','Estelle','Gnouette','$2a$10$SP2ern7.PLZ7Jm.lfk1ba.op0eN8rhMysfZP4QYF5NVc3.LHt78KW',3),(4,'2022-12-21 16:18:46','philou@gmail.fr','Philippe','Philou','$2a$10$rjWcqRgdz9uZsodtGXrqyeIWuHoJHvkdSqoKhDPjI1rUQ5YJGWPsG',4),(5,'2022-12-21 16:22:17','yoan@gmail.fr','Yoan','Yoehanne','$2a$10$H/oYNiCgF1DPOS6Za.Ac8OqBGPEeX8/Zt7.Fr6sewXruYeT5YBfym',5),(6,'2022-12-21 16:22:51','bere@gmail.fr','Bérénice','Ladisparue','$2a$10$KxOei0XDjrHlHePm.O.FnuHZbInGUdQ2BZgLBSB.v84y7eC7IGz1G',6),(7,'2022-12-21 16:24:58','argane@gmail.fr','Admin','Lagoudoune','$2a$10$F1X8GbvNbSktkBRbeElx3ubK0mzy8nZoa7KSGIbdjfwXVPlI7emhi',7);
/*!40000 ALTER TABLE `tb_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-21 16:28:36
