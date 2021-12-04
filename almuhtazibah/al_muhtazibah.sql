-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 24, 2021 at 01:11 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id16013352_al_muhtazibah`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL,
  `product_id` int(100) NOT NULL,
  `product_name` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(250) NOT NULL,
  `size` int(100) NOT NULL,
  `length` int(100) NOT NULL,
  `color` varchar(1000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cart_id`, `product_id`, `product_name`, `price`, `size`, `length`, `color`) VALUES
(6, 104, 'Dhakna Borka', 1750, 51, 54, 'red'),
(8, 103, 'Step Borka', 1850, 38, 42, 'blue'),
(9, 101, 'Step Borka', 1950, 52, 53, 'red');

-- --------------------------------------------------------

--
-- Table structure for table `delivery_system`
--

CREATE TABLE `delivery_system` (
  `Delivery Id` int(11) NOT NULL,
  `Delivery_method` varchar(15) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `Description` varchar(3000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `delivery_system`
--

INSERT INTO `delivery_system` (`Delivery Id`, `Delivery_method`, `Order_id`, `Description`) VALUES
(6, 'Courrier', 24, 'Description: Card Details Are: Card Name:abcd,Card Number: 1234,Card User Name: xyz, Card Expiration Date: 12345,Address: chawkbazar ,chittagong  '),
(7, 'CashOn', 25, 'Description: Bikash Number is 0187523698\r\nDelivery Address:tyhfs'),
(8, 'Courrier', 26, 'Description: Bikash Number is 0187523654\r\nAddress: chittagong '),
(9, 'Courrier', 27, 'Description: Bikash Number is: 1865426  Address: jfyi'),
(10, 'CashOn', 28, 'Description: Bikash Number is: 01865 Delivery Address:fgjfjgg'),
(11, 'CashOn', 29, 'Description: Bikash Number is: 0185634256 Delivery Address:chittagong '),
(12, 'Courrier', 30, 'Description: Bikash Number is: 018543679  Address: Dhaka'),
(13, 'CashOn', 31, 'Description: Bikash Number is: 01853692 Delivery Address:Dhaka ');

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

CREATE TABLE `login_info` (
  `LoginID` int(10) NOT NULL,
  `User_id` int(11) NOT NULL,
  `customer_email` varchar(200) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_info`
--

INSERT INTO `login_info` (`LoginID`, `User_id`, `customer_email`, `password`) VALUES
(1, 2, 'nishat@gmail.com', 'abc2020'),
(2, 3, 'angelpriya@gmail.com', 'xyz2020'),
(3, 2, 'nishat@gmail.com', 'abc2020'),
(4, 1, 'nabila@gmail.com', 'abcdefg'),
(5, 4, 'helloworld@gmail.com', 'helloworld');

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `Order_id` int(11) NOT NULL,
  `User_id` int(11) DEFAULT NULL,
  `PName` varchar(3000) NOT NULL,
  `pprice` varchar(1000) NOT NULL,
  `psize` varchar(3000) NOT NULL,
  `plength` varchar(3000) NOT NULL,
  `pcolor` varchar(3000) NOT NULL,
  `paid` varchar(10) NOT NULL,
  `proof_detail` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`Order_id`, `User_id`, `PName`, `pprice`, `psize`, `plength`, `pcolor`, `paid`, `proof_detail`) VALUES
(24, 25, 'Step Borka,Pearl Borka,', '3700', '52,34,', '35,51,', 'Brown,Pink,', 'Paid', 'hfus78djs'),
(25, 25, 'Step Borka,Pearl Borka,', '3700', '52,34,', '35,51,', 'Brown,Pink,', 'Pending', '75hjf36kj89'),
(26, 25, 'Step Borka,Pearl Borka,', '3700', '52,34,', '35,51,', 'Brown,Pink,', 'Pending', '64fh96gds35g'),
(27, 25, 'Step Borka,', '1950', '41,', '51,', 'Blue,', 'Pending', 'hdg86y'),
(28, 25, 'Step Borka,', '1950', '41,', '51,', 'Blue,', 'Paid', '57hfhko6'),
(29, 25, 'Step Borka,Side Lock Abaya,', '3500', '45,21,', '51,56,', 'White,Brown,', 'Paid', 'tydhs68shs'),
(30, 4, 'Step Borka,Side Lock Abaya,Pearl Borka,', '5350', '45,21,47,', '51,56,42,', 'White,Brown,Pink,', 'Pending', '67yuehsg678'),
(31, 1, 'step Borka,', '1950', '48,', 'Brown,', '51,', 'Paid', '75gh97gf9');

-- --------------------------------------------------------

--
-- Table structure for table `payment_system`
--

CREATE TABLE `payment_system` (
  `payment id` int(11) NOT NULL,
  `Payment_method` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `payment_system`
--

INSERT INTO `payment_system` (`payment id`, `Payment_method`, `Order_id`) VALUES
(1, 'Bkash', 24),
(2, 'Courrier', 25),
(3, 'Bkash', 26),
(4, 'Bkash', 27),
(5, 'Courrier', 28),
(6, 'Courrier', 29),
(7, 'Bkash', 30),
(8, 'Bikash', 31);

-- --------------------------------------------------------

--
-- Table structure for table `product_details`
--

CREATE TABLE `product_details` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `product_color` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `product_price` int(11) NOT NULL,
  `product_description` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Product_photo` varchar(1000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product_details`
--

INSERT INTO `product_details` (`product_id`, `product_name`, `product_color`, `product_price`, `product_description`, `Product_photo`) VALUES
(1, 'Step Borka', 'red,blue,', 1300, 'Charry Material', 'https://almuhtazibah.000webhostapp.com/product_image/best.jpg\r\n'),
(101, 'step Borka', 'deep merun', 1950, 'Material cherry febrics', 'http://almuhtazibah.000webhostapp.com/product_image/lonh6.jpg'),
(102, 'step Borka', 'Brown', 1850, 'Material cherry febrics', 'http://almuhtazibah.000webhostapp.com/product_image/dubleKoti_Latest.jpg'),
(103, 'Step Borka', 'Dusty pink', 1850, 'Material Cherry fabric', 'http://almuhtazibah.000webhostapp.com/product_image/KhimarSet.jpg'),
(104, 'Dhakna Borka', 'Deep olive', 1750, 'Material Cherry fabric', 'http://almuhtazibah.000webhostapp.com/product_image/double.jpg'),
(105, 'borka', 'brown', 1500, 'Material Cherry fabrics', 'https://almuhtazibah.000webhostapp.com/product_image/borka .jpg'),
(106, 'Gaown borka', 'black, deep brown', 1950, 'Material Cherry fabrics', 'https://almuhtazibah.000webhostapp.com/product_image/Gaown borka .jpg'),
(107, 'long borkha', 'peache', 1800, 'cherry', 'https://almuhtazibah.000webhostapp.com/product_image/long borkha .jpg');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `Review_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `review_value` varchar(100) NOT NULL,
  `comment` varchar(3000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`Review_id`, `User_id`, `review_value`, `comment`) VALUES
(7, 25, '5', 'satisfied '),
(8, 24, '4', 'good\n'),
(9, 25, '4.0', 'satisfied '),
(10, 25, '3.0', 'good'),
(11, 4, '5.0', 'excellent ');

-- --------------------------------------------------------

--
-- Table structure for table `sign_up`
--

CREATE TABLE `sign_up` (
  `User_id` int(11) NOT NULL,
  `Full_name` varchar(15) NOT NULL,
  `customer_email` varchar(200) NOT NULL,
  `Mobile_no` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sign_up`
--

INSERT INTO `sign_up` (`User_id`, `Full_name`, `customer_email`, `Mobile_no`, `password`) VALUES
(1, 'Nabila Ayman', 'nabila@gmail.com', '01867919224', 'abcdefg'),
(2, 'Nishat Sultana', 'nishat@gmail.com', '01645789011', 'abc2020'),
(3, 'Angel priya', 'angelpriya@gmail.com', '01645909090', 'xyz2020'),
(4, 'Hello World', 'helloworld@gmail.com', '01234567810', 'helloworld'),
(5, 'Romjan miya', 'romjanmiya@gmail.com', '01897698765', 'myname'),
(6, 'ishra naznin', 'ishranaznin69@gmail.com', '01842218166', 'ghkeb78bc'),
(7, 'muntahana tazri', 'muntahana455@gmail.com', '01547893255', 'dfcd55ddhj87'),
(12, 'ishra naznin', 'naznin18701069@gmail.com', '56863', '7658ty'),
(24, 'tudg', 'ydj@gmail.com', '88955', 'tydj'),
(25, 'ishra naznin', 'tyy@gmail.com', '5809', 'efh'),
(26, 'ishra naznin', 'gjour@gmail.com', '5388', 'ygdyi'),
(27, 'tushj', 'utaosj@gmail.com', '253484', 'tusiow7'),
(28, 'ishra naznin', 'khd@gmail.com', '3680', 'tyu'),
(29, 'muntahana tazri', 'mintahana@gmail.com', '01853649785', '123'),
(30, 'ysuhdg', 'ushsjh@gmail.com', '67846', 'yshbd'),
(31, 'jgb', 'hth@gmail.com', '585', 'yui'),
(32, 'ishra naznin', 'yeue@gmail.com', '6495', 'baje'),
(34, 'urydh', 'ssy@gmail.com', '6485', 'dhd'),
(35, 'ueye', 'tioh@gmail.com', '6580', 'twuu'),
(36, 'abc', 'abc@gmail.com', '012345678', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `delivery_system`
--
ALTER TABLE `delivery_system`
  ADD PRIMARY KEY (`Delivery Id`),
  ADD KEY `Order_id` (`Order_id`);

--
-- Indexes for table `login_info`
--
ALTER TABLE `login_info`
  ADD PRIMARY KEY (`LoginID`),
  ADD KEY `User_id` (`User_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`Order_id`),
  ADD KEY `User_id` (`User_id`);

--
-- Indexes for table `payment_system`
--
ALTER TABLE `payment_system`
  ADD PRIMARY KEY (`payment id`),
  ADD KEY `Order_id` (`Order_id`);

--
-- Indexes for table `product_details`
--
ALTER TABLE `product_details`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`Review_id`),
  ADD KEY `User_id` (`User_id`);

--
-- Indexes for table `sign_up`
--
ALTER TABLE `sign_up`
  ADD PRIMARY KEY (`User_id`,`customer_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `delivery_system`
--
ALTER TABLE `delivery_system`
  MODIFY `Delivery Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `login_info`
--
ALTER TABLE `login_info`
  MODIFY `LoginID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `Order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `payment_system`
--
ALTER TABLE `payment_system`
  MODIFY `payment id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `product_details`
--
ALTER TABLE `product_details`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `Review_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `sign_up`
--
ALTER TABLE `sign_up`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product_details` (`product_id`);

--
-- Constraints for table `delivery_system`
--
ALTER TABLE `delivery_system`
  ADD CONSTRAINT `delivery_system_ibfk_1` FOREIGN KEY (`Order_id`) REFERENCES `order_details` (`Order_id`);

--
-- Constraints for table `login_info`
--
ALTER TABLE `login_info`
  ADD CONSTRAINT `login_info_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `sign_up` (`User_id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `sign_up` (`User_id`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `sign_up` (`User_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
