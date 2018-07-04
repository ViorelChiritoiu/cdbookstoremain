package org.agoncal.application.cdbookstore.model;

import javax.persistence.*;

@Entity
public class Author extends Artist {

	@Column(name = "preferred_language")
	@Convert(converter = LanguageConverter.class)
	private Language preferredLanguage;
   
	public Author() {
	}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Language getPreferredLanguage() {
		return this.preferredLanguage;
	}

	public void setPreferredLanguage(Language preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	@Override
	public String toString() {
		return "Author [preferredLanguage=" + preferredLanguage + ", id=" + id + ", version=" + version + ", firstName="
				+ firstName + ", lastName=" + lastName + ", bio=" + bio + ", dateOfBirth=" + dateOfBirth + ", age="
				+ age + "]";
	}
}