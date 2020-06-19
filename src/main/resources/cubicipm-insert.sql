-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2016 at 06:13 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cubicipm`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(20) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

CREATE TABLE IF NOT EXISTS `candidate` (
  `id` bigint(20) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `resume_location` varchar(255) DEFAULT NULL,
  `skypeId` varchar(255) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `phone_id` bigint(20) DEFAULT NULL,
  `technology_id` bigint(20) NOT NULL,
  `vendor_call_taker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qfut8ruekode092nlkipgl09g` (`email`),
  KEY `FK5q1ksqleh983c18yssyo2dn8l` (`address_id`),
  KEY `FK67dnvuwimwaln1fweso9ahfff` (`phone_id`),
  KEY `FK6qnujh0epj85qu92x8or1kj1y` (`technology_id`),
  KEY `FKkidxejq6hbwqbh8t83hv21cqe` (`vendor_call_taker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`id`, `createdDate`, `dob`, `email`, `first_name`, `flag`, `gender`, `last_name`, `middle_name`, `updatedDate`, `resume_location`, `skypeId`, `address_id`, `phone_id`, `technology_id`, `vendor_call_taker_id`) VALUES
(12, NULL, NULL, 'sanjay@yopmail.com', 'Sanjay', NULL, 'male', 'Khatri', NULL, NULL, 'E:\\apache-tomcat-8.0.28\\tmpFiles', 'fdsfdsf', NULL, 13, 11, 9),
(14, NULL, NULL, 'pradeep@yopmail.com', 'Pradeep', NULL, 'male', 'Basnet', NULL, NULL, 'E:\\apache-tomcat-8.0.28\\tmpFiles', 'tretret', NULL, 15, 11, 9),
(16, NULL, NULL, 'sanjayd@yopmail.com', 'Sanjay', NULL, 'male', 'Dongol', NULL, NULL, 'E:\\apache-tomcat-8.0.28\\tmpFiles', 'fdsfdsfdsf', NULL, 17, 11, 9),
(18, NULL, NULL, 'sunil@yopmail.com', 'Sunil', NULL, 'male', 'Gurung', NULL, NULL, 'E:\\apache-tomcat-8.0.28\\tmpFiles', 'fdsfdsf', NULL, 19, 11, 9),
(20, NULL, NULL, 'surendra@yopmail.com', 'Surendra', NULL, 'male', 'Jnawali', 'Bahadur', NULL, 'E:\\apache-tomcat-8.0.28\\tmpFiles', 'fdfdsf', NULL, 21, 11, 9),
(29, NULL, NULL, 'ram@yopmail.com', 'Ram', NULL, 'male', 'Prasad', 'Bdr', NULL, 'E:\\apache-tomcat-8.0.28\\tmpFiles', '4324324', NULL, 30, 11, 9);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(33),
(33),
(33),
(33),
(33),
(33),
(33),
(33);

-- --------------------------------------------------------

--
-- Table structure for table `interview`
--

CREATE TABLE IF NOT EXISTS `interview` (
  `id` bigint(20) NOT NULL,
  `client_name` varchar(255) DEFAULT NULL,
  `comment` longtext,
  `flag` varchar(255) DEFAULT NULL,
  `interview_date` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `vendor_name` varchar(255) DEFAULT NULL,
  `candidate` bigint(20) DEFAULT NULL,
  `proxy_id` bigint(20) DEFAULT NULL,
  `sales_representive` bigint(20) DEFAULT NULL,
  `vendor_call_taker` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgtomh2dvdrqludi8akpm4ea8d` (`candidate`),
  KEY `FKghkru1f4idi5b3js37pjknssr` (`proxy_id`),
  KEY `FKr2nauy68bia2wn4lmkhr4436t` (`sales_representive`),
  KEY `FKs8lwu7d03l8h5sbse4ibypg6y` (`vendor_call_taker`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phone`
--

CREATE TABLE IF NOT EXISTS `phone` (
  `id` bigint(20) NOT NULL,
  `area_code` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `prefix_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phone`
--

INSERT INTO `phone` (`id`, `area_code`, `number`, `prefix_value`) VALUES
(4, '324', '3243', '343'),
(6, '432', '3243', '432'),
(8, '432', '3243', '324'),
(10, '987', '7897', '897'),
(13, '432', '7897', '789'),
(15, '787', '8978', '789'),
(17, '890', '9809', '098'),
(19, '787', '8978', '897'),
(21, '434', '3243', '324'),
(23, '878', '8978', '897'),
(25, '432', '8978', '897'),
(27, '898', '3232', '989'),
(30, '989', '0980', '809');

-- --------------------------------------------------------

--
-- Table structure for table `proxy`
--

CREATE TABLE IF NOT EXISTS `proxy` (
  `id` bigint(20) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `skypeId` varchar(255) NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `phone_id` bigint(20) DEFAULT NULL,
  `technology_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_frx0qd1g085w7894v74hhe7nd` (`email`),
  KEY `FKagux8l0eorlt0ww6256m087lv` (`address_id`),
  KEY `FKqq44ertd33lxi7v4pkgdiul38` (`phone_id`),
  KEY `FKahkftl6y8oaawxhrpnq3e7r60` (`technology_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proxy`
--

INSERT INTO `proxy` (`id`, `createdDate`, `dob`, `email`, `first_name`, `flag`, `gender`, `last_name`, `middle_name`, `updatedDate`, `skypeId`, `address_id`, `phone_id`, `technology_id`) VALUES
(24, NULL, NULL, 'simash@yopmail.com', 'Simash', NULL, 'male', 'Pokhrel', NULL, NULL, 'simashu', NULL, 25, 11);

-- --------------------------------------------------------

--
-- Table structure for table `technology`
--

CREATE TABLE IF NOT EXISTS `technology` (
  `id` bigint(20) NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7lsjqbr6g2jexyhbknslswkjc` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `technology`
--

INSERT INTO `technology` (`id`, `flag`, `name`) VALUES
(11, 'ACTIVE', 'Java'),
(28, 'ACTIVE', '.Net');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `phone_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKditu6lr4ek16tkxtdsne0gxib` (`address_id`),
  KEY `FKlq0cckks2hmmyc1mk9g30h44` (`phone_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `createdDate`, `dob`, `email`, `first_name`, `flag`, `gender`, `last_name`, `middle_name`, `updatedDate`, `enable`, `password`, `role`, `username`, `address_id`, `phone_id`) VALUES
(1, '2016-02-22 00:00:00', NULL, 'admin@yopmail.com', 'Admin', NULL, 'm', 'Nimda', 'B', NULL, b'1', '$2a$10$COS90HJLx251atEWVoT04uCr26Auvd63.hJRPfmcgsS0FRYLdhIku', 'ROLE_MASTERADMIN', 'madmin', NULL, NULL),
(3, '2016-03-31 15:53:58', '1979-12-31 18:00:00', 'admin1@yopmail.com', 'Admin', 'ACTIVE', 'm', 'Admin Last', NULL, NULL, NULL, '$2a$10$IS6eT9./NjYC9W6L95Nj4uDeMcz9GxFWAoknOgEPz0iiHjCHHoUUK', 'ROLE_ADMIN', 'admin', NULL, 4),
(5, '2016-03-31 15:54:58', '1979-12-31 18:00:00', 'bc@yopmail.com', 'Komal', 'ACTIVE', 'm', 'Thapa', NULL, NULL, NULL, '$2a$10$eG1xTwQzLl5TImnaIBMydeOnwyshG5yeT1VzYfftsCdQRHNfF1.OS', 'ROLE_BCHECKER', 'Bchecker', NULL, 6),
(7, '2016-03-31 15:56:12', '1979-12-31 18:00:00', 'marketer1@yopmail.com', 'Chandini', 'ACTIVE', 'f', 'Shrestha', NULL, NULL, NULL, '$2a$10$Tn0.GFZE3LMPQKEXtdv/qOSZ8NxVLcs91mwYNi//L7RHktQOo1wtS', 'ROLE_MARKETING', 'Marketer1', NULL, 8),
(9, '2016-03-31 15:57:10', '1984-12-31 18:00:00', 'vc1@yopmail.com', 'Anil', 'ACTIVE', 'm', 'Vaila', NULL, NULL, NULL, '$2a$10$dXFTPMMxT4rjdoJhNBh0D.13jxs/.ClnyByUnjHg8EYAfU4Z8dwNe', 'ROLE_VC', 'Vendor1', NULL, 10),
(22, '2016-03-31 16:31:03', '1988-12-31 18:00:00', 'sharukh@yopmail.com', 'Sharukh', 'ACTIVE', 'm', 'Khan', NULL, NULL, NULL, '$2a$10$n8vUK.7Fuhb4Jsbh2EC1c.Arw24F12fElrXODezfmdIFFksj08RZW', 'ROLE_VC', 'Vendor2', NULL, 23),
(26, '2016-03-31 16:45:15', '1985-01-31 18:00:00', 'marketer2@yopmail.com', 'Marketer', 'ACTIVE', 'm', 'First', NULL, NULL, NULL, '$2a$10$DCx9DBCsN4ColFGaRnXEZuf0OJVTgRwUWg5uVfcFhjf3CqutRofXG', 'ROLE_MARKETING', 'Marketr2', NULL, 27);

-- --------------------------------------------------------

--
-- Table structure for table `user_control`
--

CREATE TABLE IF NOT EXISTS `user_control` (
  `id` int(11) NOT NULL,
  `marketer_id` bigint(20) NOT NULL,
  `vendor_call_taker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrv5bywqsdw8u18j9pdk50gwah` (`marketer_id`),
  KEY `FKtny57bd9icgb70mhfu6w38y89` (`vendor_call_taker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_control`
--

INSERT INTO `user_control` (`id`, `marketer_id`, `vendor_call_taker_id`) VALUES
(31, 7, 22),
(32, 26, 9);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `candidate`
--
ALTER TABLE `candidate`
  ADD CONSTRAINT `FK5q1ksqleh983c18yssyo2dn8l` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FK67dnvuwimwaln1fweso9ahfff` FOREIGN KEY (`phone_id`) REFERENCES `phone` (`id`),
  ADD CONSTRAINT `FK6qnujh0epj85qu92x8or1kj1y` FOREIGN KEY (`technology_id`) REFERENCES `technology` (`id`),
  ADD CONSTRAINT `FKkidxejq6hbwqbh8t83hv21cqe` FOREIGN KEY (`vendor_call_taker_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `interview`
--
ALTER TABLE `interview`
  ADD CONSTRAINT `FKghkru1f4idi5b3js37pjknssr` FOREIGN KEY (`proxy_id`) REFERENCES `proxy` (`id`),
  ADD CONSTRAINT `FKgtomh2dvdrqludi8akpm4ea8d` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`),
  ADD CONSTRAINT `FKr2nauy68bia2wn4lmkhr4436t` FOREIGN KEY (`sales_representive`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKs8lwu7d03l8h5sbse4ibypg6y` FOREIGN KEY (`vendor_call_taker`) REFERENCES `users` (`id`);

--
-- Constraints for table `proxy`
--
ALTER TABLE `proxy`
  ADD CONSTRAINT `FKagux8l0eorlt0ww6256m087lv` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKahkftl6y8oaawxhrpnq3e7r60` FOREIGN KEY (`technology_id`) REFERENCES `technology` (`id`),
  ADD CONSTRAINT `FKqq44ertd33lxi7v4pkgdiul38` FOREIGN KEY (`phone_id`) REFERENCES `phone` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKditu6lr4ek16tkxtdsne0gxib` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKlq0cckks2hmmyc1mk9g30h44` FOREIGN KEY (`phone_id`) REFERENCES `phone` (`id`);

--
-- Constraints for table `user_control`
--
ALTER TABLE `user_control`
  ADD CONSTRAINT `FKrv5bywqsdw8u18j9pdk50gwah` FOREIGN KEY (`marketer_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKtny57bd9icgb70mhfu6w38y89` FOREIGN KEY (`vendor_call_taker_id`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
