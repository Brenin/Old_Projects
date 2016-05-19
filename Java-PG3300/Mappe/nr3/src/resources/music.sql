-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2015 at 11:45 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `musicdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `music`
--

CREATE TABLE IF NOT EXISTS `music` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `artist` char(30) DEFAULT NULL,
  `song` char(30) DEFAULT NULL,
  `year` char(30) DEFAULT NULL,
  `genre` char(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=67 ;

--
-- Dumping data for table `music`
--

INSERT INTO `music` (`ID`, `artist`, `song`, `year`, `genre`) VALUES
(47, 'U2', 'With or Without You', '1999', 'Rock'),
(48, 'U2', 'Joshua Tree', '1999', 'Rock'),
(49, 'Nickelback', 'How you reming me', '1999', 'Rock'),
(50, 'Aerosmith', 'I don''t wanna miss a thing', '1999', 'Rock'),
(51, 'Miyavi', 'Are you ready to rock', '1999', 'Rock'),
(52, 'Louis Armstrong', 'What a wonderful world', '1999', 'Jazz'),
(53, 'Louis Armstrong', 'When the saints go marching in', '1999', 'Jazz'),
(54, 'Miles Davis', 'So what', '1999', 'Jazz'),
(55, 'Miles Davis', 'Freddie Freeloader', '1999', 'Jazz'),
(56, 'Dizzy Gillespie', 'A night in Tunisia', '1999', 'Jazz'),
(57, 'In Flames', 'Siren Charms', '2014', 'Metal'),
(58, 'In Flames', 'Cloud Connected', '1999', 'Metal'),
(59, 'Amon Amarth', 'With Odin on our side', '1999', 'Metal'),
(60, 'Alice Nine', 'Yami ni Chiru Sakura', '1999', 'Metal'),
(61, 'The Gazette', 'Filth in the Beauty', '1999', 'Metal'),
(62, 'Lady Gaga', 'Born this way', '1999', 'Pop'),
(63, 'Lady Gaga', 'Edge of glory', '1999', 'Pop'),
(64, 'Teatrino', 'Tatta Hitotsu no Omoi', '1999', 'Pop'),
(65, 'Rihanna', 'Under my umbrella', '1999', 'Pop'),
(66, 'Shingeki', 'No Kyojin', '1999', 'Pop');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
