package com.astropay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad de Post
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity implements Serializable {

	private static final long serialVersionUID = 8846671641719923337L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "int")
	private Integer id;
	
	@Column(name = "codigo", columnDefinition = "int")
	private Integer codigo;
	
	@Column(name = "id_user", columnDefinition = "int")
	private Integer userId;

	@Column(name = "title", columnDefinition = "varchar", length = 100)
	private String title;
	
	@Column(name = "body", columnDefinition = "varchar", length = 255)
	private String body;
	
	public PostEntity(Integer codigo, Integer userId, String title, String body) {
		this.codigo = codigo;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
}
