package com.api.sic.Entities;


//import java.util.Collection;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="propriete")
@Data @NoArgsConstructor @AllArgsConstructor 
public class Propriete  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propid;
	 @Column(name = "propnom", nullable = false, updatable = true)
	private String propnom;
	 @Column(name = "propville", nullable = false, updatable = true)
	private String propville;
	 @Column(name = "propquartier", nullable = false, updatable = true)
	private String propquartier;
	 @Column(name = "propsecteur", nullable = false, updatable = false)
	private String propsecteur;
	
	/* @OneToMany(mappedBy = "propriete")
	 private Collection<Local> local;
	 */
	 @NonNull
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
@JoinColumn(name = "bailleurid", nullable = false )
private Bailleur bailleur;
	 
	
	 

}

