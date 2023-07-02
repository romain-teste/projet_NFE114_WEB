package com.projetweb.projeturbex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypeLieux {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  
	  private Integer idTypeLieu;
	  private String nomType;
	  
	  public Integer getidTypeLieu() {
		  return idTypeLieu;
	  }
	  public void setidTypeLieu(Integer idTypeLieu) {
		  this.idTypeLieu = idTypeLieu;
	  }
	  
	  public String getnomType() {
		  return nomType;
	  }
	  public void setnomType(String nomType) {
		  this.nomType = nomType;
	  }
}
