package com.astropay.mapper;

import java.util.List;

/**
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
public interface AbstractMapper<D, E> {

	E toEntity(D dto);

	D toDomain(E entity);

	List<E> toEntity(List<D> dtoList);

	List<D> toDomain(List<E> entityList);
}