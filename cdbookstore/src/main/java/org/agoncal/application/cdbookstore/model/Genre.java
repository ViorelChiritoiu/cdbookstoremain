package org.agoncal.application.cdbookstore.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Genre implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Version
    @Column(name = "version")
	private int version;
	
	@Column(length = 100)
    @NotNull
    @Size(max = 100)
	private String name;
	
	private static final long serialVersionUID = 1L;
  
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", version=" + version + ", name=" + name + "]";
	}
}