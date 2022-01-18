package com.api.sic.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "local",schema = "public")
@Data @NoArgsConstructor @AllArgsConstructor 
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "locid", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locid;
	@ManyToOne
	private Propriete propid;
  @Column(name = "locnom", insertable=true, updatable=true, nullable=true)
    private String locnom;

    @Column(name = "lieu", insertable=true, updatable=true, nullable=true)
    private String lieu;
    @NotBlank
	@Size(max = 20)
	 @Column(name = "prix", nullable = false, updatable = true)
	private int prix; 
    @NotBlank
  	@Size(max = 20)
  	 @Column(name = "nbrepiece", nullable = false, updatable = true)
  	private int nbrepiece;
    private String img;
	/*
	@OneToMany(mappedBy = "local")
	private Collection<Contrat> contrat;

	@ManyToOne
@JoinColumn(name = "propid", nullable = false )
private Propriete propriete;
    */

}
