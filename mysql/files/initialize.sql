

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `groups`(`name`) VALUES
('hoge'),
('piyo'),
('muga');

INSERT INTO `person`(`first_name`, `last_name`, `group_id`) VALUES
('John', 'Smith', 3),
('George', 'Washington', 2),
('Thomas', 'Jefferson', 2),
('Theodore', 'Roosevelt', 2),
('Abraham', 'Lincoln', 2),
('hogehoge', 'banana', 1);
