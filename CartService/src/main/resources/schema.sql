DROP TABLE IF EXISTS `dbpoc`.`tb_client` ;

CREATE TABLE  IF NOT EXISTS `dbpoc`.`tb_client` (
  `client_guest_id` int NOT NULL AUTO_INCREMENT,
  `client_guest_name` varchar(45) NOT NULL,
  `client_guest_email` varchar(45) NOT NULL,
  `purchase_item` int DEFAULT NULL,
  PRIMARY KEY (`client_guest_id`),
  UNIQUE KEY `client_guest_email_UNIQUE` (`client_guest_email`),
  KEY `fk_purchase_item_id_idx` (`purchase_item`),
  CONSTRAINT `fk_purchase_item_id` FOREIGN KEY (`purchase_item`) REFERENCES `tb_product` (`purchase_item`)
);