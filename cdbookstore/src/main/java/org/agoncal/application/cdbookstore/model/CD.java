package org.agoncal.application.cdbookstore.model;

import java.lang.Integer;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@DiscriminatorValue("C")
public class CD extends Item {

	@Column(name = "nb_of_discs")
	private Integer nbOfDiscs;
	
	@ManyToOne
	private Label label;
	
	@ManyToMany
	private Set<Musician> musicians = new HashSet<>();
	
	@ManyToOne
	private Genre genre;
	
	private static final long serialVersionUID = 1L;
   
	public Integer getNbOfDiscs() {
		return this.nbOfDiscs;
	}

	public void setNbOfDiscs(Integer nbOfDiscs) {
		this.nbOfDiscs = nbOfDiscs;
	}

	public Label getLabel() {
		return this.label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}   
	public Set<Musician> getMusicians() {
		return this.musicians;
	}

	public void setMusicians(Set<Musician> musicians) {
		this.musicians = musicians;
	}   
	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "CD [nbOfDiscs=" + nbOfDiscs + ", label=" + label + ", musicians=" + musicians + ", genre=" + genre
				+ "]";
	}
}