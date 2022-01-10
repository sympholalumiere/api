package com.api.sic.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneFacture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idligneFacture;
	
	@ManyToOne
	private User id;
	
	@ManyToOne
	private Facture facture_id;
	
	public LigneFacture(int idligneFacture, int facture_id, int id) {
		super();
		this.idligneFacture = idligneFacture;
		this.id = new User();
		this.facture_id = new Facture();
		// TODO Auto-generated constructor stub
	}

	public LigneFacture() {

	}

	public int getIdligneFacture() {
		return idligneFacture;
	}

	public void setIdligneFacture(int idligneFacture) {
		this.idligneFacture = idligneFacture;
	}

	public User getId() {
		return id;
	}

	public void setId(User id) {
		this.id = id;
	}

	public Facture getFacture_id() {
		return facture_id;
	}

	public void setFacture_id(Facture facture_id) {
		this.facture_id = facture_id;
	}

	@Override
	public String toString() {
		return "LigneFacture [idligneFacture=" + idligneFacture + ", id=" + id + ", facture_id=" + facture_id + "]";
	}
	
	

}
