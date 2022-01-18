package com.api.sic.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facture",schema = "public")
@Data @NoArgsConstructor @AllArgsConstructor 
public class Facture implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "factid", nullable = false, updatable = false)
    private int factid;
	
	@NonNull
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne( cascade = CascadeType.ALL )
@JoinColumn(name = "contid", nullable = false )
private Contrat contid;


	@Column(name = "statut", insertable=true, updatable=true, nullable=false)
    private boolean statut;
	
	@Column(name = "date_del", unique=true, insertable=true, updatable=true, nullable=false)
    private String date_del;

 
	

}
