DROP TABLE IF EXISTS `dbpoc`.`tb_client` ;

CREATE TABLE  IF NOT EXISTS `dbpoc`.`tb_client` (
  `client_guest_id` int NOT NULL,
  `client_guest_email` varchar(255) DEFAULT NULL,
  `client_guest_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_guest_id`),

);

