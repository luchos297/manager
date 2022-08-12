package com.astropay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astropay.entity.ComentarioPostEntity;

/**
 * Repositorio de comentarios
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Repository
public interface ComentarioPostRepository extends JpaRepository<ComentarioPostEntity, String> {

}