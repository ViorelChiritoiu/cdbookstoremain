package org.agoncal.application.cdbookstore.model;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("I")
@NamedQueries({
    @NamedQuery(name = Item.FIND_TOP_RATED, query = "SELECT i FROM Item i WHERE i.id in :ids"),
    @NamedQuery(name = Item.SEARCH, query = "SELECT i FROM Item i WHERE UPPER(i.title) LIKE :keyword OR UPPER(i.description) LIKE :keyword ORDER BY i.title")

})
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_TOP_RATED = "Item.findTopRated";
    public static final String SEARCH = "Item.search";
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	protected Long id;
	
	@Version
    @Column(name = "version")
	protected int version;
	
	@Column(length = 200)
    @NotNull
    @Size(min = 1, max = 200)
	protected String title;
	
	@Column(length = 10000)
    @Size(min = 1, max = 10000)
	protected String description;
	
	@Column(name = "unit_cost")
    @Min(1)
	protected Float unitCost;
	
	protected Integer rank;
	
	@Column(name = "small_image_url")
	protected String smallImageURL;
	
	@Column(name = "medium_image_url")
	protected String mediumImageURL;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getUnitCost() {
		return this.unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getSmallImageURL() {
		return this.smallImageURL;
	}

	public void setSmallImageURL(String smallImageURL) {
		this.smallImageURL = smallImageURL;
	}

	public String getMediumImageURL() {
		return this.mediumImageURL;
	}

	public void setMediumImageURL(String mediumImageURL) {
		this.mediumImageURL = mediumImageURL;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", version=" + version + ", title=" + title + ", description=" + description
				+ ", unitCost=" + unitCost + ", rank=" + rank + ", smallImageURL=" + smallImageURL + ", mediumImageURL="
				+ mediumImageURL + "]";
	}
}