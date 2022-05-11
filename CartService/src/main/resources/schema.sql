DROP TABLE IF EXISTS `dbpoc`.`tb_client` ;


CREATE TABLE  IF NOT EXISTS `dbpoc`.`tb_client` (
  `client_guest_id` int NOT NULL AUTO_INCREMENT,
  `client_guest_email` varchar(255) DEFAULT NULL,
  `client_guest_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_guest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

DROP TABLE IF EXISTS `dbpoc`.`tb_product` ;

CREATE TABLE  IF NOT EXISTS `dbpoc`.`tb_product` (
  `purchase_item` int NOT NULL AUTO_INCREMENT,
  `productbrand` varchar(255) NOT NULL,
  `productdescription` varchar(255) NOT NULL,
  `productexpirationdate` datetime NOT NULL,
  `productname` varchar(255) NOT NULL,
  `productprice` double NOT NULL,
  `productquantity` int NOT NULL,
  `fk_clientguestproduct` int DEFAULT NULL,
  PRIMARY KEY (`purchase_item`),
  KEY `FKb2buub936y2nk94ptlvwsgdp2` (`fk_clientguestproduct`),
  CONSTRAINT `FKb2buub936y2nk94ptlvwsgdp2` FOREIGN KEY (`fk_clientguestproduct`) REFERENCES `tb_client` (`client_guest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci