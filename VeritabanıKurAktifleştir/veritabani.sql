-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.2.13-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- eczane için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `eczane` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `eczane`;

-- tablo yapısı dökülüyor eczane.ilackayit
CREATE TABLE IF NOT EXISTS `ilackayit` (
  `ilac_no` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ilac_adet` int(11) DEFAULT NULL,
  `ilac_ad` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ilac_fiyat` float DEFAULT NULL,
  `Tarih/Saat` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`ilac_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- eczane.ilackayit: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `ilackayit` DISABLE KEYS */;
INSERT INTO `ilackayit` (`ilac_no`, `ilac_adet`, `ilac_ad`, `ilac_fiyat`, `Tarih/Saat`) VALUES
	('BXG78', 7, 'arvales', 15.55, '2020-05-18 23:33:29'),
	('BXG78CC', 11, 'arvalesSSzz', 44, '2020-05-19 00:49:18'),
	('POR56', 7, 'ferooo', 244.99, '2020-05-18 23:42:55'),
	('sadad', 4, 'baerrkin', 7, '2020-05-19 05:39:56'),
	('wqeqwe', 4, 'qweqwe', 15, '2020-05-19 01:31:14'),
	('X4S9T', 5, 'majezik', 17.99, '2020-05-18 23:33:29'),
	('zzzz', 82, 'tarik', 25, '2020-05-19 00:02:47');
/*!40000 ALTER TABLE `ilackayit` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
