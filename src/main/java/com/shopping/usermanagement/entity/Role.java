package com.shopping.usermanagement.entity;


import com.shopping.base.entity.BaseEntity;
import jakarta.persistence.Entity;
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
@Table(name = "sec_roles")
public class Role extends BaseEntity<Long> {
	
	private String name;

}
