CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID de post',
  `userId` varchar(20) NOT NULL COMMENT 'ID del usuario',
  `title` varchar(100) NOT NULL COMMENT 'Titulo del post',
  `body` varchar(255) NOT NULL COMMENT 'Cuerpo del post',  
  `created` timestamp NULL DEFAULT current_timestamp() COMMENT 'Fecha de alta',
  
  PRIMARY KEY (`id`)
) engine = InnoDB auto_increment = 4 DEFAULT CHARSET = utf8mb4 COMMENT 'Tabla para administrar posts';