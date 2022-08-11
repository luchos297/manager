package com.astropay.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "id", columnDefinition = "int")
	private int id;
	
	@Column(name = "userId", columnDefinition = "int")
	private int userId;

	@Column(name = "title", columnDefinition = "varchar")
	private Integer title;
	
	@Column(name = "body", columnDefinition = "varchar")
	private Integer body;
	
	@Column(name = "created", columnDefinition = "datetime")
	private LocalDateTime created;
}
