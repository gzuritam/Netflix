package com.netflix.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Chapter.
 */
@Entity
@Table(name = "CHAPTERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 20)
	@NotNull
	private Long id;
	
	/** The number. */
	@Column(name = "NUMBER")
	@NotNull
	private int number;
	
	/** The name. */
	@Column(name = "NAME", length = 256)
	@NotNull
	private String name;
	
	/** The duration. */
	@Column(name = "DURATION")
	@NotNull
	private int duration;
	
	/** The season. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEASON_ID", referencedColumnName = "id")
	private Season season;

}
