-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2022 at 08:18 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkiran`
--

-- --------------------------------------------------------

--
-- Table structure for table `catatparkir`
--

CREATE TABLE `catatparkir` (
  `id` int(10) NOT NULL,
  `plat_nomor` varchar(11) NOT NULL,
  `jenis` varchar(30) NOT NULL,
  `harga` varchar(30) NOT NULL,
  `masuk` datetime NOT NULL,
  `keluar` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `catatparkir`
--

INSERT INTO `catatparkir` (`id`, `plat_nomor`, `jenis`, `harga`, `masuk`, `keluar`) VALUES
(1, 'AB2850HK', 'null', '100', '2022-06-02 13:52:54', '2022-06-03 13:10:43'),
(5, 'aa', 'null', '1111', '2022-06-03 13:01:14', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `catatparkir`
--
ALTER TABLE `catatparkir`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `catatparkir`
--
ALTER TABLE `catatparkir`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
