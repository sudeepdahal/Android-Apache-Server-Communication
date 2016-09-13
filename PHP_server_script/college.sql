-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 13, 2016 at 05:36 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `college`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
`id` int(22) NOT NULL,
  `name` varchar(30) NOT NULL,
  `faculty` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` int(22) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `faculty`, `address`, `email`, `phone`) VALUES
(1, 'sudip', 'csit', 'kirtipur', 'sudeep@gmail.com', 9841234),
(2, 'govinda', 'physics', 'dolu', 'govu@hotmail.com', 87856),
(3, '', '', 'address', 'email', 0),
(4, '', '', 'address', 'email', 0),
(5, 'abc', 'it', 'address', 'email', 0),
(6, 'abc', 'it', 'balkhu', 'lal@gmail.com', 98213342),
(7, 'abc', 'it', 'balkhu', 'lal@gmail.com', 98213342),
(8, 'asd', 'asd', 'asd', 'asd', 23),
(9, 'sudeep', 'csit', 'kirti', 'sssss', 9999999),
(10, '', '11', '11', '11', 11),
(11, '', 'ar', 'wea', 'waer', 45),
(12, 'fgsd', 'fdg', 'f', 'gf', 78),
(13, 'abc', 'it', 'balkhu', 'lal@gmail.com', 98213342),
(14, '', '', '', '', 0),
(15, 'applea', 'apple', 'apple', 'apple', 324324);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
MODIFY `id` int(22) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
