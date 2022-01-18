package com.api.sic.Entities;

/*
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
*/
import javax.persistence.Column;

//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="bailleur",schema = "public")
@Data @NoArgsConstructor @AllArgsConstructor
public class Bailleur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bailleurid")
	private int bailleurid;
	private String bailleurnom;
	private int bailleurcni;
	private String bailleurtel ;
	private String bailleurproff ;
	/*@OneToMany(mappedBy = "bailleur")
	private Collection <Propriete> proprietes;
	*/
	
	
}
