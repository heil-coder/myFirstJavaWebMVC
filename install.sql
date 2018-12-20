DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES ('admin', 'administrator', 'admin');
