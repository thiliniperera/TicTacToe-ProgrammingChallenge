-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2014 at 10:15 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tictactoe`
--

-- --------------------------------------------------------

--
-- Table structure for table `stat`
--

CREATE TABLE IF NOT EXISTS `stat` (
  `player` varchar(20) NOT NULL,
  `win` int(11) DEFAULT '0',
  `loss` int(11) DEFAULT '0',
  `tie` int(11) DEFAULT '0',
  PRIMARY KEY (`player`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stat`
--

INSERT INTO `stat` (`player`, `win`, `loss`, `tie`) VALUES

('Computer', 4, 0, 0),
('Maryam', 0, 1, 1),
('Nathiesha', 1, 0, 0),
('P1', 2, 3, 1),
('P2', 3, 2, 1),
('Riyafa', 3, 1, 0),
('Sasini', 0, 0, 0),
('Sathya', 4, 4, 3),
('Thamali', 0, 2, 2),
('Thara', 2, 1, 2),


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
