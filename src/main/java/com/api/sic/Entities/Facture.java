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

@Entity
@Table(name = "facture",schema = "public")
public class Facture implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "facture_id", nullable = false, updatable = false)
    private int facture_id;
	
	@NonNull
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne( cascade = CascadeType.ALL )
@JoinColumn(name = "contrat_id", nullable = false )
private Contrat contrat_id;
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
	
	@Column(name = "date", unique=true, insertable=true, updatable=true, nullable=false)
    private String date;

    

	@Column(name = "statut", insertable=true, updatable=true, nullable=false)
    private String statut;



	public int getFacture_id() {
		return facture_id;
	}



	public void setFacture_id(int facture_id) {
		this.facture_id = facture_id;
	}



	public Contrat getContrat_id() {
		return contrat_id;
	}



	public void setContrat_id(Contrat contrat_id) {
		this.contrat_id = contrat_id;
	}



	public User getId() {
		return id;
	}



	public void setId(User user) {
		this.id = user;
	}



	public Local getLocal_id() {
		return local_id;
	}



	public void setLocal_id(Local local_id) {
		this.local_id = local_id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}



	public Facture() {
		
	}



	public Facture(int facture_id, Contrat contrat_id, User id, Local local_id, String date, String statut) {
		super();
		this.facture_id = facture_id;
		this.contrat_id = contrat_id;
		this.id = new User();
		this.local_id = local_id;
		this.date = date;
		this.statut = statut;
	}



	@Override
	public String toString() {
		return "Facture [facture_id=" + facture_id + ", contrat_id=" + contrat_id + ", id=" + id.toString() + ", local_id="
				+ local_id + ", date=" + date + ", statut=" + statut + "]";
	}



	



	
	
	
	
	
	

}
