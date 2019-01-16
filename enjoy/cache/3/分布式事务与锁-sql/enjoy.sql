DROP TABLE IF EXISTS `db_lock`;

CREATE TABLE `db_lock` (
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `db_lock` */

INSERT  INTO `db_lock`(`id`) VALUES (3),(4),(5);

/*Table structure for table `log_order` */

DROP TABLE IF EXISTS `log_order`;

CREATE TABLE `log_order` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `trace_id` VARCHAR(32) DEFAULT NULL,
  `msg` VARCHAR(200) DEFAULT NULL,
  `moudle` VARCHAR(20) DEFAULT NULL,
  `class` VARCHAR(50) DEFAULT NULL,
  `method` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `log_order` */

INSERT  INTO `log_order`(`id`,`trace_id`,`msg`,`moudle`,`class`,`method`) VALUES (1,'','traceId:0243a698a3de4ec984a7dca65d549e94 UserServiceImpl：getDetail【执行开始】','user','com.enjoy.service.impl.UserServiceImpl','getDetail'),(2,'','UserDaoImpl:getDetail【执行开始】','user','com.enjoy.dao.impl.UserDaoImpl','getDetail'),(3,'','traceId:0243a698a3de4ec984a7dca65d549e94 OrderServiceImpl：getDetail【执行开始】','user','com.enjoy.service.impl.OrderServiceImpl','getDetail'),(4,'','OrderDaoImpl:getDetail【执行开始】','user','com.enjoy.dao.impl.OrderDaoImpl','getDetail'),(5,'','traceId:f52bbabd9b484640a684aafd74773a9f UserServiceImpl：getDetail【执行开始】','user','com.enjoy.service.impl.UserServiceImpl','getDetail'),(6,'','UserDaoImpl:getDetail【执行开始】','user','com.enjoy.dao.impl.UserDaoImpl','getDetail'),(7,'','traceId:f52bbabd9b484640a684aafd74773a9f OrderServiceImpl：getDetail【执行开始】','user','com.enjoy.service.impl.OrderServiceImpl','getDetail'),(8,'','OrderDaoImpl:getDetail【执行开始】','user','com.enjoy.dao.impl.OrderDaoImpl','getDetail'),(9,'70a1fbac6c4045af8ad73477284c5c94','UserController：index【商品首页处理开始】','product','com.enjoy.controller.ProductController','index'),(10,'70a1fbac6c4045af8ad73477284c5c94','ProductServiceImpl:getDetail【执行开始】','product','com.enjoy.service.impl.ProductServiceImpl','getDetail'),(11,'70a1fbac6c4045af8ad73477284c5c94','ProductDaoImpl:getDetail【执行开始】','product','com.enjoy.dao.impl.ProductDaoImpl','getDetail'),(12,'2f20b35b714a4c4d8eca5d4fed4e500f','UserController：index【商品首页处理开始】','product','com.enjoy.controller.ProductController','index'),(13,'2f20b35b714a4c4d8eca5d4fed4e500f','ProductServiceImpl:getDetail【执行开始】','product','com.enjoy.service.impl.ProductServiceImpl','getDetail'),(14,'2f20b35b714a4c4d8eca5d4fed4e500f','ProductDaoImpl:getDetail【执行开始】','product','com.enjoy.dao.impl.ProductDaoImpl','getDetail');

/*Table structure for table `tcc_fly_order` */

DROP TABLE IF EXISTS `tcc_fly_order`;

CREATE TABLE `tcc_fly_order` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bus_id` VARCHAR(50) DEFAULT NULL,
  `idcard` VARCHAR(20) DEFAULT NULL,
  `status` INT(10) UNSIGNED DEFAULT '0',
  `money` INT(10) UNSIGNED DEFAULT NULL,
  `frozen` INT(10) UNSIGNED DEFAULT '0',
  `remark` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tcc_fly_order` */

INSERT  INTO `tcc_fly_order`(`id`,`bus_id`,`idcard`,`status`,`money`,`frozen`,`remark`) VALUES (1,'0','123232323',1,500,0,'国航'),(2,'0','123232323',1,500,0,'国航'),(3,'0','123232323',1,500,0,'国航'),(4,'0','23434343434',1,500,0,'国航'),(5,'fee00a46-0893-4b4d-a00a-c759c9f6ae55','1111111',1,500,0,'国航'),(6,'adbd9407-94e8-4cd1-b1e3-6f7b55fb8514','44545',0,500,0,'国航');

/*Table structure for table `TCC_TRANSACTION_ENJOY` */

DROP TABLE IF EXISTS `TCC_TRANSACTION_ENJOY`;

CREATE TABLE `TCC_TRANSACTION_ENJOY` (
  `TRANSACTION_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DOMAIN` VARCHAR(100) DEFAULT NULL,
  `GLOBAL_TX_ID` VARBINARY(32) NOT NULL,
  `BRANCH_QUALIFIER` VARBINARY(32) NOT NULL,
  `CONTENT` VARBINARY(8000) DEFAULT NULL,
  `STATUS` INT(11) DEFAULT NULL,
  `TRANSACTION_TYPE` INT(11) DEFAULT NULL,
  `RETRIED_COUNT` INT(11) DEFAULT NULL,
  `CREATE_TIME` DATETIME DEFAULT NULL,
  `LAST_UPDATE_TIME` DATETIME DEFAULT NULL,
  `VERSION` INT(11) DEFAULT NULL,
  `IS_DELETE` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`TRANSACTION_ID`),
  UNIQUE KEY `UX_TX_BQ` (`GLOBAL_TX_ID`,`BRANCH_QUALIFIER`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


