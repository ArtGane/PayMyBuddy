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
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_accounts`
--

DROP TABLE IF EXISTS `tb_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_accounts` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `creation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_accounts`
--

LOCK TABLES `tb_accounts` WRITE;
/*!40000 ALTER TABLE `tb_accounts` DISABLE KEYS */;
INSERT INTO `tb_accounts` VALUES (1,0,'2022-12-21 16:15:46'),(2,0,'2022-12-21 16:16:56'),(3,0,'2022-12-21 16:17:24'),(4,0,'2022-12-21 16:18:46'),(5,0,'2022-12-21 16:22:17'),(6,0,'2022-12-21 16:22:51'),(7,0,'2022-12-21 16:24:58');
/*!40000 ALTER TABLE `tb_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_accounts_transactions`
--

DROP TABLE IF EXISTS `tb_accounts_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_accounts_transactions` (
  `account_account_id` int NOT NULL,
  `transactions_id` int NOT NULL,
  KEY `FKn2x1g060krlska9y8nrt7f3r4` (`transactions_id`),
  KEY `FKr7b0y2jbkeilvjvussoiph467` (`account_account_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_accounts_transactions`
--

LOCK TABLES `tb_accounts_transactions` WRITE;
/*!40000 ALTER TABLE `tb_accounts_transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_accounts_transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_transactions`
--

DROP TABLE IF EXISTS `tb_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `creation_date` datetime DEFAULT NULL,
  `transaction_type` int DEFAULT NULL,
  `account_account_id` int DEFAULT NULL,
  `friend_account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq768qx9l2k8l6avuqhdjgqt89` (`account_account_id`),
  KEY `FKl1owq2xkkk51ia2x47abncc09` (`friend_account_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_transactions`
--

LOCK TABLES `tb_transactions` WRITE;
/*!40000 ALTER TABLE `tb_transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_transactions` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `tb_users_friends`
--

DROP TABLE IF EXISTS `tb_users_friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_users_friends` (
  `profile_id` bigint NOT NULL,
  `friends_id` bigint NOT NULL,
  KEY `FKtbvtur9xav6y3orfrc6ndcfwa` (`friends_id`),
  KEY `FKbrhnjkiu4gpibeejcmvp3ad4l` (`profile_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users_friends`
--

LOCK TABLES `tb_users_friends` WRITE;
/*!40000 ALTER TABLE `tb_users_friends` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_users_friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-21 16:27:24
