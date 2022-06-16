package com.hexaware.jpaassessment.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Mobile")
public class Mobile {
	
	@Id
	@Column(name = "Mobile_Id")
	private int mobileID;
	
	@Column(name = "Mobile_Company")
	private String mobileCompany;
	
	@Column(name = "Mobile_Name")
	private String mobileName;
	
	@OneToMany(mappedBy = "mobile")
	private List<App> apps;
}
