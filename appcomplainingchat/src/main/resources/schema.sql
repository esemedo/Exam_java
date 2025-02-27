DROP TABLE IF EXISTS `message`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int AUTO_INCREMENT PRIMARY KEY,
  `lastname` varchar(255) UNIQUE,
  `firstname`varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `message` (
  `id` int AUTO_INCREMENT PRIMARY KEY,
  `content` text,
  `user_id` int ,
  `date` datetime(6),
  `response` text,
  KEY `FKb3y6etti1cfougkdr0qiiemgv` (`user_id`),
  CONSTRAINT `FKb3y6etti1cfougkdr0qiiemgv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;