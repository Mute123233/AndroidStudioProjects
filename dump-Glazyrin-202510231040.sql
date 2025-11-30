-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Glazyrin
-- ------------------------------------------------------
-- Server version	10.11.6-MariaDB-0+deb12u1.astra1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Abonent`
--

DROP TABLE IF EXISTS `Abonent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Abonent` (
  `idAbonent` int(11) NOT NULL AUTO_INCREMENT,
  `idOperator` int(11) DEFAULT NULL,
  `Surname` varchar(100) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Patronymic` varchar(100) DEFAULT NULL,
  `DownloadDate` date DEFAULT NULL,
  `AvailabilityBlocker` int(1) NOT NULL,
  `Debt` varchar(100) DEFAULT NULL,
  `Notes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idAbonent`),
  KEY `Abonent_Operator_FK` (`idOperator`),
  CONSTRAINT `Abonent_Operator_FK` FOREIGN KEY (`idOperator`) REFERENCES `Operator` (`idOperator`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Abonent`
--

LOCK TABLES `Abonent` WRITE;
/*!40000 ALTER TABLE `Abonent` DISABLE KEYS */;
INSERT INTO `Abonent` VALUES
(1,1,'Иванов','Иван','Иванович','2024-01-15',0,'500','Постоянный клиент'),
(2,1,'Петров','Петр','Петрович','2024-02-20',1,'500','Задолженность'),
(3,2,'Сидорова','Анна','Владимировна','2024-03-10',0,'0','Новый клиент'),
(4,2,'Козлов','Дмитрий','Сергеевич','2024-01-25',0,'1500','Корпоративный клиент'),
(5,1,'Николаев','Алексей','Игоревич','2024-04-05',1,'200','Временная блокировка'),
(6,3,'Орлова','Елена','Михайловна','2024-02-28',0,'0','VIP клиент'),
(7,3,'Федоров','Максим','Андреевич','2024-03-15',0,'300','Семейный тариф'),
(8,1,'Григорьева','Ольга','Павловна','2024-01-10',1,'800','Проблемы с оплатой'),
(9,2,'Васильев','Сергей','Николаевич','2024-04-12',0,'0','Активный пользователь'),
(10,3,'Алексеева','Мария','Дмитриевна','2024-03-22',0,'100','Минимальная задолженность'),
(11,1,'asd','asd','asd','2025-10-22',1,'250','asd'),
(12,1,'asd','asd','fa','2025-10-23',1,'500','ss');
/*!40000 ALTER TABLE `Abonent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AbonentServices`
--

DROP TABLE IF EXISTS `AbonentServices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AbonentServices` (
  `idAbonentServices` int(11) NOT NULL AUTO_INCREMENT,
  `idAbonent` int(11) DEFAULT NULL,
  `idServices` int(11) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  PRIMARY KEY (`idAbonentServices`),
  KEY `AbonentServices_Abonent_FK` (`idAbonent`),
  KEY `AbonentServices_Services_FK` (`idServices`),
  CONSTRAINT `AbonentServices_Abonent_FK` FOREIGN KEY (`idAbonent`) REFERENCES `Abonent` (`idAbonent`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `AbonentServices_Services_FK` FOREIGN KEY (`idServices`) REFERENCES `Services` (`idServices`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AbonentServices`
--

LOCK TABLES `AbonentServices` WRITE;
/*!40000 ALTER TABLE `AbonentServices` DISABLE KEYS */;
INSERT INTO `AbonentServices` VALUES
(1,1,1,'2024-01-15','2025-01-15'),
(2,1,2,'2024-01-15','2025-01-15'),
(3,2,1,'2024-02-20','2025-02-20'),
(4,3,3,'2024-03-10','2025-03-10'),
(5,4,1,'2024-01-25','2025-01-25'),
(6,4,2,'2024-01-25','2025-01-25'),
(7,4,3,'2024-01-25','2025-01-25'),
(8,5,1,'2024-04-05','2025-04-05'),
(9,6,2,'2024-02-28','2025-02-28'),
(10,7,1,'2024-03-15','2025-03-15'),
(11,8,3,'2024-01-10','2025-01-10'),
(12,9,1,'2024-04-12','2025-04-12'),
(13,9,2,'2024-04-12','2025-04-12'),
(14,10,1,'2024-03-22','2025-03-22'),
(15,10,3,'2024-03-22','2025-03-22');
/*!40000 ALTER TABLE `AbonentServices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ApplicationType`
--

DROP TABLE IF EXISTS `ApplicationType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ApplicationType` (
  `idApplicationType` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Notes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idApplicationType`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ApplicationType`
--

LOCK TABLES `ApplicationType` WRITE;
/*!40000 ALTER TABLE `ApplicationType` DISABLE KEYS */;
INSERT INTO `ApplicationType` VALUES
(1,'Подключение услуги','Заявка на подключение новой услуги'),
(2,'Отключение услуги','Заявка на отключение услуги'),
(3,'Техническая проблема','Заявка на устранение технических неисправностей'),
(4,'Изменение тарифа','Заявка на смену тарифного плана'),
(5,'Консультация','Консультация по услугам и тарифам');
/*!40000 ALTER TABLE `ApplicationType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Applications`
--

DROP TABLE IF EXISTS `Applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Applications` (
  `idApplication` int(11) NOT NULL AUTO_INCREMENT,
  `idStatus` int(11) DEFAULT NULL,
  `idAbonent` int(11) NOT NULL,
  `idApplicationType` int(11) DEFAULT NULL,
  `ApplicationsDate` date DEFAULT NULL,
  `Note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idApplication`),
  KEY `Applications_Status_FK` (`idStatus`),
  KEY `Applications_Abonent_FK` (`idAbonent`),
  KEY `Applications_ApplicationType_FK` (`idApplicationType`),
  CONSTRAINT `Applications_Abonent_FK` FOREIGN KEY (`idAbonent`) REFERENCES `Abonent` (`idAbonent`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Applications_ApplicationType_FK` FOREIGN KEY (`idApplicationType`) REFERENCES `ApplicationType` (`idApplicationType`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Applications_Status_FK` FOREIGN KEY (`idStatus`) REFERENCES `Status` (`idStatus`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Applications`
--

LOCK TABLES `Applications` WRITE;
/*!40000 ALTER TABLE `Applications` DISABLE KEYS */;
INSERT INTO `Applications` VALUES
(1,1,1,1,'2024-04-01','Подключение интернета 100 Мбит/с'),
(2,2,2,3,'2024-04-02','Пропадает связь в вечернее время'),
(3,1,3,4,'2024-04-03','Смена тарифа на Премиум'),
(4,3,4,2,'2024-04-04','Отключение кабельного ТВ'),
(5,2,5,1,'2024-04-05','Подключение дополнительной услуги'),
(6,1,6,5,'2024-04-06','Консультация по новым тарифам'),
(7,4,7,3,'2024-04-07','Медленная скорость интернета'),
(8,1,8,4,'2024-04-08','Переход на экономный тариф'),
(9,2,9,1,'2024-04-09','Подключение IP-телефонии'),
(10,1,10,3,'2024-04-10','Проблемы с роутером');
/*!40000 ALTER TABLE `Applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipment`
--

DROP TABLE IF EXISTS `Equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipment` (
  `idEquipment` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEquipment`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipment`
--

LOCK TABLES `Equipment` WRITE;
/*!40000 ALTER TABLE `Equipment` DISABLE KEYS */;
INSERT INTO `Equipment` VALUES
(1,'Wi-Fi роутер','router.jpg'),
(2,'Модем','modem.jpg'),
(3,'IP-телефон','ip_phone.jpg'),
(4,'ТВ-приставка','tv_box.jpg'),
(5,'Сетевой коммутатор','switch.jpg');
/*!40000 ALTER TABLE `Equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HomePhone`
--

DROP TABLE IF EXISTS `HomePhone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HomePhone` (
  `idHomePhone` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Type` varchar(100) DEFAULT NULL,
  `idServices` int(11) DEFAULT NULL,
  PRIMARY KEY (`idHomePhone`),
  KEY `HomePhone_Services_FK` (`idServices`),
  CONSTRAINT `HomePhone_Services_FK` FOREIGN KEY (`idServices`) REFERENCES `Services` (`idServices`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HomePhone`
--

LOCK TABLES `HomePhone` WRITE;
/*!40000 ALTER TABLE `HomePhone` DISABLE KEYS */;
INSERT INTO `HomePhone` VALUES
(1,'Базовый телефон','Аналоговый',2),
(2,'Цифровой телефон','Цифровой',2),
(3,'IP-телефон','IP-телефония',2),
(4,'Факс-аппарат','Факс',2),
(5,'Видеотелефон','Видеосвязь',2);
/*!40000 ALTER TABLE `HomePhone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Internet`
--

DROP TABLE IF EXISTS `Internet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Internet` (
  `idInternet` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Type` varchar(100) DEFAULT NULL,
  `idServices` int(11) DEFAULT NULL,
  PRIMARY KEY (`idInternet`),
  KEY `Internet_Services_FK` (`idServices`),
  CONSTRAINT `Internet_Services_FK` FOREIGN KEY (`idServices`) REFERENCES `Services` (`idServices`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Internet`
--

LOCK TABLES `Internet` WRITE;
/*!40000 ALTER TABLE `Internet` DISABLE KEYS */;
INSERT INTO `Internet` VALUES
(1,'Эконом 50 Мбит/с','Проводной',1),
(2,'Стандарт 100 Мбит/с','Проводной',1),
(3,'Премиум 200 Мбит/с','Оптоволокно',1),
(4,'Бизнес 500 Мбит/с','Оптоволокно',1),
(5,'Безлимитный Wi-Fi','Беспроводной',1);
/*!40000 ALTER TABLE `Internet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Operator`
--

DROP TABLE IF EXISTS `Operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Operator` (
  `idOperator` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOperator`),
  KEY `Operator_Users_FK` (`idUser`),
  CONSTRAINT `Operator_Users_FK` FOREIGN KEY (`idUser`) REFERENCES `Users` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Operator`
--

LOCK TABLES `Operator` WRITE;
/*!40000 ALTER TABLE `Operator` DISABLE KEYS */;
INSERT INTO `Operator` VALUES
(1,2),
(2,3),
(3,4),
(4,8);
/*!40000 ALTER TABLE `Operator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Remont`
--

DROP TABLE IF EXISTS `Remont`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Remont` (
  `idRemont` int(11) NOT NULL AUTO_INCREMENT,
  `idEquipment` int(11) DEFAULT NULL,
  `Type` varchar(100) DEFAULT NULL,
  `idTechnician` int(11) DEFAULT NULL,
  `idServices` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRemont`),
  KEY `Remont_Equipment_FK` (`idEquipment`),
  KEY `Remont_Technician_FK` (`idTechnician`),
  KEY `Remont_Services_FK` (`idServices`),
  CONSTRAINT `Remont_Equipment_FK` FOREIGN KEY (`idEquipment`) REFERENCES `Equipment` (`idEquipment`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Remont_Services_FK` FOREIGN KEY (`idServices`) REFERENCES `Services` (`idServices`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Remont_Technician_FK` FOREIGN KEY (`idTechnician`) REFERENCES `Technician` (`idTechnician`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Remont`
--

LOCK TABLES `Remont` WRITE;
/*!40000 ALTER TABLE `Remont` DISABLE KEYS */;
INSERT INTO `Remont` VALUES
(1,1,'Замена роутера',1,1),
(2,2,'Настройка модема',1,1),
(3,3,'Ремонт IP-телефона',1,2),
(4,4,'Обновление прошивки',1,3),
(5,5,'Настройка сети',1,1);
/*!40000 ALTER TABLE `Remont` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Services`
--

DROP TABLE IF EXISTS `Services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Services` (
  `idServices` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Notes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idServices`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Services`
--

LOCK TABLES `Services` WRITE;
/*!40000 ALTER TABLE `Services` DISABLE KEYS */;
INSERT INTO `Services` VALUES
(1,'Интернет','Доступ в интернет'),
(2,'Телефония','Телефонная связь'),
(3,'Телевидение','Кабельное ТВ'),
(4,'Видеонаблюдение','Системы безопасности'),
(5,'Облачное хранилище','Хранение данных');
/*!40000 ALTER TABLE `Services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Status`
--

DROP TABLE IF EXISTS `Status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Status` (
  `idStatus` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Status`
--

LOCK TABLES `Status` WRITE;
/*!40000 ALTER TABLE `Status` DISABLE KEYS */;
INSERT INTO `Status` VALUES
(1,'Новая'),
(2,'В работе'),
(3,'Выполнена'),
(4,'Отклонена'),
(5,'Ожидает');
/*!40000 ALTER TABLE `Status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Supervisor`
--

DROP TABLE IF EXISTS `Supervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Supervisor` (
  `idSupervisor` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSupervisor`),
  KEY `Supervisor_Users_FK` (`idUser`),
  CONSTRAINT `Supervisor_Users_FK` FOREIGN KEY (`idUser`) REFERENCES `Users` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Supervisor`
--

LOCK TABLES `Supervisor` WRITE;
/*!40000 ALTER TABLE `Supervisor` DISABLE KEYS */;
INSERT INTO `Supervisor` VALUES
(1,5);
/*!40000 ALTER TABLE `Supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Technician`
--

DROP TABLE IF EXISTS `Technician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Technician` (
  `idTechnician` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTechnician`),
  KEY `Technician_Users_FK` (`idUser`),
  CONSTRAINT `Technician_Users_FK` FOREIGN KEY (`idUser`) REFERENCES `Users` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Technician`
--

LOCK TABLES `Technician` WRITE;
/*!40000 ALTER TABLE `Technician` DISABLE KEYS */;
INSERT INTO `Technician` VALUES
(1,6);
/*!40000 ALTER TABLE `Technician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Surname` varchar(100) DEFAULT NULL,
  `Patronymic` varchar(100) DEFAULT NULL,
  `SNILS` varchar(65) DEFAULT NULL,
  `PassportData` varchar(65) DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `Phone` varchar(100) DEFAULT NULL,
  `EmploymentDate` date DEFAULT NULL,
  `Login` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `PhotoEquipment` varchar(255) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES
(1,'Админ','Системный','Админович','123-456-789 00','4511123456','1985-01-01','+7 (900) 123-45-67','2020-01-15','admin','admin',NULL,NULL,'Подтвержден'),
(2,'Иван','Петров','Сергеевич','234-567-890 00','4511234567','1990-05-15','+7 (900) 234-56-78','2022-03-01','operator1','12345',NULL,NULL,'Подтвержден'),
(3,'Анна','Сидорова','Владимировна','345-678-901 00','4511345678','1988-08-20','+7 (900) 345-67-89','2022-06-15','operator2','12345',NULL,NULL,'Подтвержден'),
(4,'Дмитрий','Козлов','Игоревич','456-789-012 00','4511456789','1992-12-10','+7 (900) 456-78-90','2023-01-20','operator3','12345',NULL,NULL,'Подтвержден'),
(5,'Елена','Николаева','Алексеевна','567-890-123 00','4511567890','1987-03-25','+7 (900) 567-89-01','2021-09-10','supervisor','12345',NULL,NULL,'Подтвержден'),
(6,'Сергей','Федоров','Михайлович','678-901-234 00','4511678901','1983-07-08','+7 (900) 678-90-12','2020-11-05','technician','12345',NULL,NULL,'Подтвержден'),
(7,'Мария','Орлова','Дмитриевна','789-012-345 00','4511789012','1995-09-30','+7 (900) 789-01-23','2024-02-28','user1','12345',NULL,NULL,'Подтвержден'),
(8,'edasd','Edsa','easdsa','124124','4142','2007-10-28','414214','2025-10-23','123123123','123','user_photo_1761189886852.jpg','27027','Подтвержден');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'Glazyrin'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-23 10:40:17
