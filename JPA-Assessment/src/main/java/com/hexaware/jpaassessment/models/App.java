package com.hexaware.jpaassessment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "App")
public class App {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "App_Id")
	private int appId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Mobile_Id")
	private Mobile mobile;
	
	@Column(name = "App_Name")
	private String appName;
}
