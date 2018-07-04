package org.agoncal.application.cdbookstore.model;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@MappedSuperclass
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected Long id;
	
	@Version
	@Column(name = "version")
	protected int version;
	
	@Column(length = 50, name = "first_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
	protected String firstName;
	
	@Column(length = 50, name = "last_name", nullable = false)
	@NotNull
	@Size(min = 2, max = 50)
	protected String lastName;
	
	@Column(length = 5000)
	@Size(max = 5000)
	protected String bio;
	
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	@Past
	protected Date dateOfBirth;
	
	@Transient
	protected Integer age;
   
	@PostLoad
	private void calculateAge() {
		if (dateOfBirth == null) {
            age = null;
            return;
        }

        Calendar birth = new GregorianCalendar();
        birth.setTime(dateOfBirth);
        Calendar now = new GregorianCalendar();
        now.setTime(new Date());
        int adjust = 0;
        if (now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
            adjust = -1;
        }
        age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
	}
	
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

	public String getFirstName() {
	    return this.firstName;
	}

	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}

	public String getLastName() {
	    return this.lastName;
	}

	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}

	public String getBio() {
	    return this.bio;
	}

	public void setBio(String bio) {
	    this.bio = bio;
	}

	public Date getDateOfBirth() {
	    return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
	    this.dateOfBirth = dateOfBirth;
	}   
	public Integer getAge() {
	    return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", bio=" + bio + ", dateOfBirth=" + dateOfBirth + ", age=" + age + "]";
	}
}