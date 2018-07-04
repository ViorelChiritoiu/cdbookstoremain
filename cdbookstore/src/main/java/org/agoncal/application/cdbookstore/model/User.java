package org.agoncal.application.cdbookstore.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.agoncal.application.cdbookstore.util.PasswordUtils;

@Entity
@Table(name = "t_user")
@NamedQueries({
    @NamedQuery(name = User.FIND_BY_EMAIL, query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = User.FIND_BY_UUID, query = "SELECT u FROM User u WHERE u.uuid = :uuid"),
    @NamedQuery(name = User.FIND_BY_LOGIN, query = "SELECT u FROM User u WHERE u.login = :login"),
    @NamedQuery(name = User.FIND_BY_LOGIN_PASSWORD, query = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password"),
    @NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM User u")
})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_EMAIL = "User.findByEmail";
    public static final String FIND_BY_LOGIN = "User.findByLogin";
    public static final String FIND_BY_UUID = "User.findByUUID";
    public static final String FIND_BY_LOGIN_PASSWORD = "User.findByLoginAndPassword";
    public static final String FIND_ALL = "User.findAll";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	private Long id;
    
    @Version
    @Column(name = "version")
	private int version;
    
    @Column(length = 10, nullable = false)
    @NotNull
    @Size(min = 1, max = 10)
	private String login;
    
    @Column(length = 50, name = "first_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
	private String firstName;
    
    @Column(length = 50, name = "last_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
	private String lastName;
    
    @Column
	private String telephone;
    
    @Column
    @NotNull
	private String email;
    
    @Column(length = 256, nullable = false)
    @NotNull
    @Size(min = 1, max = 256)
	private String password;
    
    @Column(length = 256)
    @Size(min = 1, max = 256)
	private String uuid;
    
    @Enumerated
    @Column(name = "user_role")
	private UserRole role;
    
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @Past
	private Date dateOfBirth;
   
    
    @PrePersist
    @PreUpdate
    private void digestPassword() {
        password = PasswordUtils.digestPassword(password);
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
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}   
	public UserRole getRole() {
		return this.role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", version=" + version + ", login=" + login + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", telephone=" + telephone + ", email=" + email + ", password=" + password
				+ ", uuid=" + uuid + ", role=" + role + ", dateOfBirth=" + dateOfBirth + "]";
	}
}