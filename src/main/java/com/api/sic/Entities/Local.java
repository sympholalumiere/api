package com.api.sic.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "local",schema = "public")
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "local_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int local_id;
  @Column(name = "designation", insertable=true, updatable=true, nullable=true)
    private String designation;

    @Column(name = "lieu", insertable=true, updatable=true, nullable=true)
    private String lieu;

	

	public int getLocal_id() {
		return local_id;
	}

	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Local(int local_id, String designation, String lieu) {
		super();
		this.local_id = local_id;
		this.designation = designation;
		this.lieu = lieu;
	}

	public Local() {
		
	}

	@Override
	public String toString() {
		return "Local [local_id=" + local_id + ", designation=" + designation + ", lieu=" + lieu + "]";
	}
	
	
    
    

}
