DROP TABLE IF EXISTS `dbpoc`.`tb_client` ;

CREATE TABLE  IF NOT EXISTS `dbpoc`.`tb_client`  (
  `client_guest_id` int NOT NULL AUTO_INCREMENT,
  `client_guest_email` varchar(255) DEFAULT NULL,
  `client_guest_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_guest_id`)
) ENGINE=InnoDB;



DROP TABLE IF EXISTS `dbpoc`.`tb_product` ;

CREATE TABLE  IF NOT EXISTS `dbpoc`.`tb_product` (
  `purchase_item` int NOT NULL AUTO_INCREMENT,
  `productbrand` varchar(255) NOT NULL,
  `productdescription` varchar(255) NOT NULL,
  `productexpirationdate` datetime NOT NULL,
  `productname` varchar(255) NOT NULL,
  `productprice` double NOT NULL,
  `productquantity` int NOT NULL,
  `clientguest_purchase_item_id` int DEFAULT NULL,
  PRIMARY KEY (`purchase_item`),
  KEY `FK15dvpp5f1ql6s2jnu6c4pg54i` (`clientguest_purchase_item_id`),
  CONSTRAINT `FK15dvpp5f1ql6s2jnu6c4pg54i` FOREIGN KEY (`clientguest_purchase_item_id`) REFERENCES `tb_client` (`client_guest_id`)
) ENGINE=InnoDB;