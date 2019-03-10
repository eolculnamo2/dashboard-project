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
  `enabled` tinyint(1) DEFAULT NULL,
  
  
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



SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `dashboard`;

CREATE TABLE `dashboard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(500) DEFAULT NULL,
  `step_status` varchar(45) DEFAULT NULL,
  `scheduled_time` varchar(45) DEFAULT NULL,
  `current_step` int(11) DEFAULT 1,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `pending_issue`;

CREATE TABLE `pending_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `assigned_to` varchar(45) DEFAULT NULL,
  `solved` varchar(45) DEFAULT NULL,
  `dashboard_id` int(11) DEFAULT NULL,
   
  PRIMARY KEY (`id`),
  
  KEY `FK_DASHBOARD_idx` (`dashboard_id`),
  CONSTRAINT `FK_DASHBOARD`
  FOREIGN KEY (`dashboard_id`)
  REFERENCES `dashboard` (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `included_fix` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fix` varchar(500) DEFAULT NULL,
  `dashboard_id_fix` int(11) DEFAULT NULL,
   
  PRIMARY KEY (`id`),
  
  KEY `FK_DASHBOARD_idx` (`dashboard_id_fix`),
  CONSTRAINT `FK_DASHBOARD1`
  FOREIGN KEY (`dashboard_id_fix`)
  REFERENCES `dashboard` (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `deployment_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `note` varchar(500) DEFAULT NULL,
  `dashboard_id_note` int(11) DEFAULT NULL,
   
  PRIMARY KEY (`id`),
  
  KEY `FK_DASHBOARD_idx` (`dashboard_id_note`),
  CONSTRAINT `FK_DASHBOARD2`
  FOREIGN KEY (`dashboard_id_note`)
  REFERENCES `dashboard` (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;