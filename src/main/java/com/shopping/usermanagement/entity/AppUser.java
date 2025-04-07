package com.shopping.usermanagement.entity;

import java.util.ArrayList;
import java.util.List;
import com.shopping.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
	
	private String userName;
		
	private String password;
	
	@ManyToMany()
	@JoinTable(name="sec_user_roles", 
			   joinColumns = @JoinColumn(name="user_id"), 
			   inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private List<Role> roles = new ArrayList<>();
	
}
