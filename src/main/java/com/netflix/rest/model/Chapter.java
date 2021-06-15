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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CHAPTERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 20)
	@NotNull
	private Long id;
	@Column(name = "NUMBER")
	@NotNull
	private int number;
	@Column(name = "NAME", length = 256)
	@NotNull
	private String name;
	@Column(name = "DURATION")
	@NotNull
	private int duration;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEASON_ID", referencedColumnName = "id")
	private Season season;

}
