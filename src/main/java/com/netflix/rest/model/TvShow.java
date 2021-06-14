package com.netflix.rest.model;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TvShow implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 20)
	@NotNull
	@JsonIgnore
	private Long id;
	@Column(name = "NAME", unique = true, length = 256)
	@NotNull
	private String name;
	@Column(name = "SHORT_DESC", unique = true, length = 256)
	@NotNull
	private String shortDescription;
	@Column(name = "LONG_DESC", unique = true, length = 2048)
	@NotNull
	private String longDescription;
	@Column(name = "YEAR", unique = true, length = 4)
	@NotNull
	private int year;
	@Column(name = "RECOMMENDED_AGE", unique = true)
	@NotNull
	private int recommendedAge;
	@Column(name = "ADVERTISING", unique = true, length = 256)
	@NotNull
	private String advertising;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id")
	private Category category;

}
