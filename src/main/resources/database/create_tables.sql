--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(60) NOT NULL,
  `FIRST_NAME` varchar(45) NOT NULL,
  `MIDDLE_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `EMAIL_ID` varchar(200) NOT NULL,
  `PHONE` varchar(25) NOT NULL,
  `STATUS` tinyint(4) NOT NULL DEFAULT '1',
  `IS_USER_LOCKED` tinyint(1) NOT NULL DEFAULT '0',
  `IS_PWD_EXPIRED` tinyint(1) NOT NULL DEFAULT '0',
  `LAST_LOGIN_AT` datetime NULL DEFAULT NULL,
  `LAST_PASSWORD_CHANGED_AT` datetime DEFAULT NULL,
  `CREATED_ON` datetime NULL DEFAULT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime NULL DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `user_name_UNIQUE` (`USER_NAME`),
  UNIQUE KEY `email_id_UNIQUE` (`EMAIL_ID`),
  UNIQUE KEY `phone_UNIQUE` (`PHONE`)
);

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `NAME` varchar(55) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `LOGO` varchar(255) DEFAULT NULL,
  `SECRET_KEY` varchar(255) NOT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime NULL DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
);


DROP TABLE IF EXISTS `organization_user`;



CREATE TABLE `organization_user` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `ORG_ID` BIGINT NOT NULL,
  `USER_ID` BIGINT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ORG_ID_ORG_USER` FOREIGN KEY (`ORG_ID`) REFERENCES `organization` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USER_ID_ORG_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION

);


----
---- Table structure for table `role`
----


DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(45) NOT NULL,
  `DISPLAY_NAME` varchar(255) NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
--
--
--
----
---- Table structure for table `role`
----
--
DROP TABLE IF EXISTS `organization sites`;

CREATE TABLE `organization_sites` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `ORG_ID` BIGINT NOT NULL,
  `SITE_NAME` varchar(45) NOT NULL,
  `SITE_DISPLAY_NAME` varchar(255) NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
 CONSTRAINT `FK_ORG_ID_ORGANIZATION` FOREIGN KEY (`ORG_ID`) REFERENCES `organization` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION

);
--
--
----
---- Table structure for table `user_role`
----
--
DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `USER_ID` BIGINT NOT NULL,
  `ROLE_ID` BIGINT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `role_fk` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_fk` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
--
--
----
---- Table structure for table `attendance`
----

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `EMAIL_ID` varchar(55) NOT NULL,
  `LOG_IN` datetime DEFAULT NULL,
  `LOG_OUT` datetime DEFAULT NULL,
  `LOG_IN_LAT` varchar(55) DEFAULT NULL,
  `LOG_IN_LAG` varchar(55) DEFAULT NULL,
  `LOG_OUT_LAT` varchar(55) DEFAULT NULL,
  `LOG_OUT_LAG` varchar(55) DEFAULT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime NULL DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
--
--
--
--
--
--
