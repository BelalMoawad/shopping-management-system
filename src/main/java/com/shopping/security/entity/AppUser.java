package com.shopping.security.entity;

import java.util.ArrayList;
import java.util.List;
import com.shopping.base.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sec_users")
public class AppUser extends BaseEntity<Long> {
	
	
	private String firstName;
	
	
	private String lastName;
	
	@Column(unique = true)
	@NotBlank(message = "UserName must not be Empty or NULL")
	private String userName;
	
	@NotBlank(message = "Password must not be Empty or NULL")	
	private String password;
	
	@ManyToMany
	@JoinTable(name="sec_user_roles", 
			   joinColumns = @JoinColumn(name="user_id"), 
			   inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private List<Role> roles = new ArrayList<>();
	
}
