CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID de post',
  `codigo` bigint(20) NOT NULL COMMENT 'ID del post original',
  `id_user` bigint(20) NOT NULL COMMENT 'ID del usuario',
  `title` varchar(100) NOT NULL COMMENT 'Titulo del post',
  `body` varchar(255) NOT NULL COMMENT 'Cuerpo del post',  
  PRIMARY KEY (`id`)
) engine = InnoDB auto_increment = 1 DEFAULT CHARSET = utf8 COMMENT 'Tabla de posts';

CREATE TABLE `comentario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID de comentario',
  `codigo` bigint(20) NOT NULL COMMENT 'ID del comentario original',
  `name` varchar(100) NOT NULL COMMENT 'Nombre del usuario',
  `email` varchar(100) NOT NULL COMMENT 'Email del usuario',
  `body` varchar(255) NOT NULL COMMENT 'Cuerpo del comentario', 
  `id_post` bigint(20) NOT NULL COMMENT 'ID del comentario',
  PRIMARY KEY (`id`),
  KEY `POST_FK` (`id_post`),
  CONSTRAINT `POST_FK` FOREIGN KEY (`id_post`) REFERENCES `post` (`id`)
) engine = InnoDB auto_increment = 1 DEFAULT CHARSET = utf8 COMMENT 'Tabla de comentarios de un post';

