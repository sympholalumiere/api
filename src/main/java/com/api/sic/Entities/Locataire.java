package com.api.sic.Entities;


//import java.util.Collection;
//import java.util.Set;

import javax.persistence.Column;

//import java.util.Collection;
//import java.util.Set;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import com.api.sic.Entities.Contrat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="locataire",schema = "public")
@Data @NoArgsConstructor @AllArgsConstructor 
public class Locataire   {
	@Id
    @Column(name = "locatid", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locatid;
	private String locatnom;
	private String locatcni;
	private String locattel;
	private String locatproff;
	

	
	                
	   
	
}
