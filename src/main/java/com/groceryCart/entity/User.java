package com.groceryCart.entity;

import java.util.List;
import java.util.Set;



import jakarta.persistence.*;



@Entity
@Table(name = "users_master")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String username;
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "role")
    private Role role;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_master_Grocery_items",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "grocery_id", referencedColumnName = "itemId")
    )
    private Set<Grocery> groceries;

	public Set<Grocery> getGroceries() {
		return groceries;
	}

	public void setGroceries(Set<Grocery> groceries) {
		this.groceries = groceries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
    
}
