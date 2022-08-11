package com.astropay.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
	
	@Column(name = "user_id", columnDefinition = "varchar", length = 20)
	private Integer userId;

	@Column(name = "title", columnDefinition = "varchar", length = 100)
	private String title;
	
	@Column(name = "body", columnDefinition = "varchar", length = 255)
	private String body;
	
	@Column(name = "created", columnDefinition = "datetime")
	private LocalDateTime created;
}
