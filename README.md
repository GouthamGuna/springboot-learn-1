# Spring-Boot-Basics-File-Upload :

    * IDE Spring Tool Suite 4, Version: 4.14.0, Build Id: 202203131612.
    
    * Spring Boot :: (v2.4.5)
    
    * SQLyog MYSQL GUI Version: 12.4.3.
    
    * Postman v9.15.2.

	* project setup which will be required throughout this series. We will be creating a Maven project with minimum dependencies added to the pom.xml for getting Spring up and running. 

# Product System 🔧
	
	* spring-boot-web.
	
	* spring-boot-security.
	
	* spring-boot-test.
	
	* spring-security-test.
	
	* spring-boot-thymeleaf.
	
	* spring-session-core.
	
	* mysql-connector-java.
	
	* spring-boot-maven-plugin.
	
#  SQL Table Queries:

		CREATE TABLE `document` (
		  `id` bigint(20) NOT NULL AUTO_INCREMENT,
		  `content` mediumblob,
		  `name` varchar(215) NOT NULL,
		  `size` bigint(20) NOT NULL,
		  `upload_time` datetime DEFAULT NULL,
		  PRIMARY KEY (`id`),
		  UNIQUE KEY `UK_36vs45u76s1n950kwxfa5lyhc` (`name`)
		) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1
		
		CREATE TABLE `spring_session` (
		  `PRIMARY_ID` char(36) NOT NULL,
		  `SESSION_ID` char(36) NOT NULL,
		  `CREATION_TIME` bigint(20) NOT NULL,
		  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
		  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
		  `EXPIRY_TIME` bigint(20) NOT NULL,
		  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
		  PRIMARY KEY (`PRIMARY_ID`),
		  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
		  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
		  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
		) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC
		
		CREATE TABLE `spring_session_attributes` (
	    `SESSION_PRIMARY_ID` char(36) NOT NULL,
	    `ATTRIBUTE_NAME` varchar(200) NOT NULL,
	    `ATTRIBUTE_BYTES` blob NOT NULL,
	  	 PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
	 	 CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES   		`spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
		) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC