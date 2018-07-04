package org.agoncal.application.cdbookstore.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Cacheable
@NamedQuery(name = Country.FIND_ALL, query = "SELECT c FROM Country c ORDER BY c.name")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Country.findAll";
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Version
	@Column(name = "version")
	private int version;
	
	@Column(length = 2, name = "iso_code", nullable = false)
    @NotNull
    @Size(min = 2, max = 2)
	private String isoCode;
	
	@Column(length = 80, nullable = false)
    @NotNull
    @Size(min = 2, max = 80)
	private String name;
	
	@Column(length = 80, name = "printable_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 80)
	private String printableName;
	
	@Column(length = 3)
    @NotNull
    @Size(min = 3, max = 3)
	private String iso3;
	
	@Column(length = 3)
    @NotNull
    @Size(min = 3, max = 3)
	private String numcode;
   
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
	public String getIsoCode() {
		return this.isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrintableName() {
		return this.printableName;
	}

	public void setPrintableName(String printableName) {
		this.printableName = printableName;
	}

	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getNumcode() {
		return this.numcode;
	}

	public void setNumcode(String numcode) {
		this.numcode = numcode;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", version=" + version + ", isoCode=" + isoCode + ", name=" + name
				+ ", printableName=" + printableName + ", iso3=" + iso3 + ", numcode=" + numcode + "]";
	}
}