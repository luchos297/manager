package com.astropay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Entity
@Table(name = "comentario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioPostEntity implements Serializable {

	private static final long serialVersionUID = 2720869335158530013L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "int")
	private Integer id;
	
	@Column(name = "codigo", columnDefinition = "int")
	private Integer codigo;
	
	@Column(name = "name", columnDefinition = "varchar", length = 100)
	private String name;

	@Column(name = "email", columnDefinition = "varchar", length = 100)
	private String email;
	
	@Column(name = "body", columnDefinition = "varchar", length = 255)
	private String body;
	
	@JoinColumn(name = "id_post", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
    private PostEntity post;
	
	public ComentarioPostEntity(Integer codigo, String name, String email, String body, PostEntity post) {
		this.codigo = codigo;
		this.name = name;
		this.email = email;
		this.body = body;
		this.post = post;
	}
}
