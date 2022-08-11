package com.astropay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astropay.entity.PostEntity;

/**
 * Repositorio de posts
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Repository
public interface PostRepository extends JpaRepository<PostEntity, String> {

}