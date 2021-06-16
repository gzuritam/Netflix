package com.netflix.rest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Season.
 */
@Entity
@Table(name = "SEASONS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Season {
	
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
	@Column(name = "NAME", length = 20)
	@NotNull
	private String name;
	
	/** The tv show. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TV_SHOW_ID", referencedColumnName = "id")
	private TvShow tvShow;
	
	/** The chapters. */
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "season")
	private List<Chapter> chapters;

}
