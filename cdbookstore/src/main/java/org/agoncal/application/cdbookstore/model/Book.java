package org.agoncal.application.cdbookstore.model;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@DiscriminatorValue("B")
public class Book extends Item {

	@Column(length = 50)
	private String isbn;
	
	@Column(name = "nb_of_pages")
    @Min(1)
	private Integer nbOfPages;
	
	@Column(name = "publication_date")
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	
	@Enumerated
	private Language language;
	
	@ManyToOne
	private Publisher publisher;
	
	@ManyToOne
	private Category category;
	
	@OneToMany
	private Set<Author> authors = new HashSet<>();
	
	private static final long serialVersionUID = 1L;

	public Book() {
	} 
	
	public Book(String isbn, String title, String description, Float unitCost, Integer nbOfPages, Language language) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.unitCost = unitCost;
		this.nbOfPages = nbOfPages;
		this.language = language;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbOfPages() {
		return this.nbOfPages;
	}

	public void setNbOfPages(Integer nbOfPages) {
		this.nbOfPages = nbOfPages;
	}   
	public Date getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}   
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", nbOfPages=" + nbOfPages + ", publicationDate=" + publicationDate
				+ ", language=" + language + ", id=" + id + ", version=" + version + ", title=" + title
				+ ", description=" + description + ", unitCost=" + unitCost + "]";
	}
}