package org.agoncal.application.cdbookstore.model;

import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.agoncal.application.cdbookstore.model.Artist;

@Entity
public class Musician extends Artist {

	@Column(name = "preferred_instrument")
	private String preferredInstrument;
	
	@ManyToMany
	private Set<CD> cds = new HashSet<>();
 
	public String getPreferredInstrument() {
		return this.preferredInstrument;
	}

	public void setPreferredInstrument(String preferredInstrument) {
		this.preferredInstrument = preferredInstrument;
	}   
	public Set<CD> getCds() {
		return this.cds;
	}

	public void setCds(Set<CD> cds) {
		this.cds = cds;
	}

	@Override
	public String toString() {
		return "Musician [preferredInstrument=" + preferredInstrument + ", cds=" + cds + ", id=" + id + ", version="
				+ version + ", firstName=" + firstName + ", lastName=" + lastName + ", bio=" + bio + ", dateOfBirth="
				+ dateOfBirth + ", age=" + age + "]";
	}
}