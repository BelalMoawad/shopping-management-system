package com.shopping.security.entity;


import com.shopping.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sec_roles")
public class Role extends BaseEntity<Long> {
	
	@NotBlank(message = "Role Name must not be Empty or NULL")
	private String name;

}
