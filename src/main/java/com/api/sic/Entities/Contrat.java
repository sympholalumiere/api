package com.api.sic.Entities;

import java.io.Serializable;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.springframework.lang.NonNull;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "contrat",schema = "public")
@Data @NoArgsConstructor @AllArgsConstructor 
public class Contrat  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contid")
    private int contid;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "locid")
	private Local locid;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "locatid")
	private Locataire locatid;
	@Column(name = "titre", insertable=true, updatable=true, nullable=false)
    private String titre;
	@Column(name = "description", insertable=true, updatable=true, nullable=false)
    private String description;
	@Column(name = "date_entree", unique=true, insertable=true, updatable=true, nullable=false)
    private String date_entree;
	@Column(name = "date_sort", unique=true, insertable=true, updatable=true, nullable=false)
    private String date_sort;
	@Column(name = "montant_mensuel", insertable=true, updatable=true, nullable=false)
    private String montant_mensuel;

	
	/*@NonNull
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne( cascade = CascadeType.ALL )
 @JoinColumn(name = "id", nullable = false )
 private User id;
	@NonNull
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne( cascade = CascadeType.ALL )
@JoinColumn(name = "id_locataire", nullable = false )
private Locataire contrat;

	@NonNull
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne( cascade = CascadeType.ALL )
@JoinColumn(name = "loc_id", nullable = false )
private Local loc_id;
*/
	
	
	
	
	@Override
	public String toString() {
		return "Contrat [contid=" + contid + ", locid=" + locid + ", locatid=" + locatid + ", titre=" + titre
				+ ", description=" + description + ", date_entree=" + date_entree + ", date_sort=" + date_sort
				+ ", montant_mensuel=" + montant_mensuel + "]";
	}
	
	
	

    


	
	
	
	
}


