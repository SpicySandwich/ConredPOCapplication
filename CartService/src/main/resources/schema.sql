
DROP TABLE IF EXISTS `dbpoc`.`tb_product` ;

CREATE TABLE  IF NOT EXISTS `dbpoc`.`tb_product` (
  `purchase_item` int NOT NULL AUTO_INCREMENT,
  `productbrand` varchar(255) NOT NULL,
  `productdescription` varchar(255) NOT NULL,
  `productexpirationdate` datetime NOT NULL,
  `productname` varchar(255) NOT NULL,
  `productprice` double NOT NULL,
  `productquantity` int NOT NULL,
  `productemail` varchar(255) NOT NULL,
  PRIMARY KEY (`purchase_item`)
) ENGINE=InnoDB;

