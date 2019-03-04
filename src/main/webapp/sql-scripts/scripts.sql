CREATE DATABASE  IF NOT EXISTS `browsergame`;
USE `browsergame`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `user_profile`;

CREATE TABLE `user_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(55) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `last_login` varchar(55) DEFAULT NULL,
  `power_rating` int(45) DEFAULT NULL,
  `spearmen` int(30) DEFAULT NULL,
  `archers` int(30) DEFAULT NULL,
  `heavy_swords` int(30) DEFAULT NULL,
  `silver` int(30) DEFAULT NULL,
  `wood` int(30) DEFAULT NULL,
  `steel` int(30) DEFAULT NULL,
  
  PRIMARY KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



/* TWO */
CREATE DATABASE  IF NOT EXISTS `browsergame`;
USE `browsergame`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(55) UNIQUE,
  `password` varchar(500) DEFAULT NULL,
  `display_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `authority` int(5) DEFAULT NULL,
  `teamname` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `teams`;

CREATE TABLE `teams` (
  `teamname` varchar(55) UNIQUE,
  `founder` varchar(55) DEFAULT,
  
  PRIMARY KEY (`teamname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/* TWO */
CREATE DATABASE  IF NOT EXISTS `browsergame`;
USE `browsergame`; 

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `username` varchar(55) UNIQUE,
  `authority` varchar(45) DEFAULT "ROLE_USER",

  UNIQUE KEY `authorities_idx_1` (`username`, `authority`),

  CONSTRAINT `authorities_ibfk_1`
  FOREIGN KEY (`username`)
  REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

