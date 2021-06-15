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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TV_SHOWS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TvShow   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 20)
	@NotNull
	private Long id;
	@Column(name = "NAME",length = 256)
	@NotNull
	private String name;
	@Column(name = "SHORT_DESC",length = 256)
	@NotNull
	private String shortDescription;
	@Column(name = "LONG_DESC",length = 2048)
	@NotNull
	private String longDescription;
	@Column(name = "YEAR",length = 4)
	@NotNull
	private int year;
	@Column(name = "RECOMMENDED_AGE")
	@NotNull
	private int recommendedAge;
	@Column(name = "ADVERTISING",length = 256)
	@NotNull
	private String advertising;
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id")
	@ManyToMany(mappedBy = "tvShow")
	private List<Category> category;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tvShow")
	private List<Season> seasons;

}
