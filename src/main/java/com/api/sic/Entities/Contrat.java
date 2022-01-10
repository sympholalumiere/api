package com.api.sic.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "contrat",schema = "public")
public class Contrat  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "contrat_id", nullable = false, updatable = false)
    private int contrat_id;
	
	@NonNull
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne( cascade = CascadeType.ALL )
 @JoinColumn(name = "user_id", nullable = false )
 private User id;

	@NonNull
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne( cascade = CascadeType.ALL )
@JoinColumn(name = "local_id", nullable = false )
private Local local_id;
	
	@Column(name = "date_ent", unique=true, insertable=true, updatable=true, nullable=false)
    private String date_ent;

    

	@Column(name = "montant_mensuel", insertable=true, updatable=true, nullable=false)
    private String montant_mensuel;
	
	
	public Contrat() {
		
	}
	
	
	public int getContrat_id() {
		return contrat_id;
	}
	public void setContrat_id(int contrat_id) {
		this.contrat_id = contrat_id;
	}
	public User getId() {
		return id;
	}
	public void setId(User id) {
		this.id = id;
	}
	public Local getLocal_id() {
		return local_id;
	}
	public void setLocal_id(Local local_id) {
		this.local_id = local_id;
	}
	public String getDate_ent() {
		return date_ent;
	}
	public void setDate_ent(String date_ent) {
		this.date_ent = date_ent;
	}
	public String getMontant_mensuel() {
		return montant_mensuel;
	}
	public void setMontant_mensuel(String montant_mensuel) {
		this.montant_mensuel = montant_mensuel;
	}


	public Contrat(int contrat_id, User id, Local local_id, String date_ent, String montant_mensuel) {
		super();
		this.contrat_id = contrat_id;
		this.id = id;
		this.local_id = local_id;
		this.date_ent = date_ent;
		this.montant_mensuel = montant_mensuel;
	}


	@Override
	public String toString() {
		return "Contrat [contrat_id=" + contrat_id + ", id=" + id + ", local_id=" + local_id + ", date_ent=" + date_ent
				+ ", montant_mensuel=" + montant_mensuel + "]";
	}
	
	
	
}


