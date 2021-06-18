package com.netflix.rest.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class TvShow.
 */
@Entity
@Table(name = "TV_SHOWS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TvShow   {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 20)
	@NotNull
	private Long id;
	
	/** The name. */
	@Column(name = "NAME",length = 256)
	@NotNull
	private String name;
	
	/** The short description. */
	@Column(name = "SHORT_DESC",length = 256)
	@NotNull
	private String shortDescription;
	
	/** The long description. */
	@Column(name = "LONG_DESC",length = 2048)
	@NotNull
	private String longDescription;
	
	/** The year. */
	@Column(name = "YEAR",length = 4)
	@NotNull
	private int year;
	
	/** The recommended age. */
	@Column(name = "RECOMMENDED_AGE")
	@NotNull
	private int recommendedAge;
	
	/** The advertising. */
	@Column(name = "ADVERTISING",length = 256)
	@NotNull
	private String advertising;
	
	/** The category. */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			  name = "CATEGORY_TVSHOW", 
			  joinColumns = @JoinColumn(name = "TV_SHOW_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	private Set<Category> category;
	
	/** The seasons. */
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "tvShow")
	private Set<Season> seasons;

}
