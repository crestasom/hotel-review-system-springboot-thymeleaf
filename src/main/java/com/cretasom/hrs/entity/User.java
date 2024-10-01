package com.cretasom.hrs.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7336106826667472215L;
	@Id
	private int id;
	@NotBlank(message = "Name cannot be empty")
	@Pattern(regexp = "^[A-Za-z 0-9]{3,}", message = "Name should be atleast 3 char and only contain letters")

	private String name;
//	@NotBlank(message = "Email is mandatory")
	@Email(message = "Invalid email")
	private String email;
	private String userName;
	private String password;
	private String userRole;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", userRole=" + userRole + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //

		GrantedAuthority auth = new SimpleGrantedAuthority("ROLE_" + userRole.toUpperCase());
		return Arrays.asList(auth);
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

}
