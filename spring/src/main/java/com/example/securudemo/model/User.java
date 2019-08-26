package com.example.securudemo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//lombok a geçilecek

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	private int active;
	private String roles;
	private String permissions;
	
	
	public User(String username, String password, String roles, String permissions) {
		
		this.username=username;
		this.password=password;
		this.roles=roles;
		this.permissions=permissions;	
		this.active = 1;
	}
	
	protected User() {
		
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getActive() {
        return active;
    }
	
	public void setActivate(int activate) {
		this.active=activate;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public String getPermissions() {
		return permissions;
	}


	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public List<String> getPermissionList(){
		if(this.permissions.length()>0) {
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<>();
	}
	
	public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
	
	
}
