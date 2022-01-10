package com.api.sic.Entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", schema = "public",
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	@NotBlank
	@Size(max = 20)
	private String name;
	@NotBlank
	@Size(max = 20)
	private String lieu_naiss;
	
	@NotBlank
	@Size(max = 20)
	private int numcni;
	@NotBlank
	@Size(max = 20)
	private String tel;

	public User() {
	}
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Set<Role> roles, @NotBlank @Size(max = 20) String name,
			@NotBlank @Size(max = 20) String lieu_naiss, @NotBlank @Size(max = 20) int numcni,
			@NotBlank @Size(max = 20) String tel) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.name = name;
		this.lieu_naiss = lieu_naiss;
		this.numcni = numcni;
		this.tel = tel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLieu_naiss() {
		return lieu_naiss;
	}
	public void setLieu_naiss(String lieu_naiss) {
		this.lieu_naiss = lieu_naiss;
	}
	public int getNumcni() {
		return numcni;
	}
	public void setNumcni(int numcni) {
		this.numcni = numcni;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", roles="
				+ roles + ", name=" + name + ", lieu_naiss=" + lieu_naiss + ", numcni=" + numcni + ", tel=" + tel + "]";
	}
	
	
}
