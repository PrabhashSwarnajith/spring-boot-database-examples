
CREATE TABLE `bus_owners` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `buses` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `reg_no` varchar(255) DEFAULT NULL,
                         `owner_id` bigint DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `UK_7ll6o64ao81k0o5bj6h96kvuh` (`reg_no`),
                         KEY `FKkea9e4roh3l0nbtc1veeg0axq` (`owner_id`),
                         KEY `idx_reg_no` (`reg_no`),
                         CONSTRAINT `FKkea9e4roh3l0nbtc1veeg0axq` FOREIGN KEY (`owner_id`) REFERENCES `bus_owners` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `routes` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `route_id` bigint DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `bus_employees` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `employment_type` enum('DRIVER','CONDUCTOR','MECHANIC') DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `bus_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbxtwragjsrd9rdh3rfwp847x0` (`bus_id`),
  KEY `idx_emp_type` (`employment_type`),
  CONSTRAINT `FKbxtwragjsrd9rdh3rfwp847x0` FOREIGN KEY (`bus_id`) REFERENCES `buses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `bus_routes` (
  `bus_id` bigint NOT NULL,
  `route_id` bigint NOT NULL,
  KEY `FKhcnpaxcein4qdyo4ndhaobyp9` (`route_id`),
  KEY `FKkl7smwo01g1dnb0vlfxehnr9u` (`bus_id`),
  CONSTRAINT `FKhcnpaxcein4qdyo4ndhaobyp9` FOREIGN KEY (`route_id`) REFERENCES `routes` (`id`),
  CONSTRAINT `FKkl7smwo01g1dnb0vlfxehnr9u` FOREIGN KEY (`bus_id`) REFERENCES `buses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `buses`
--


