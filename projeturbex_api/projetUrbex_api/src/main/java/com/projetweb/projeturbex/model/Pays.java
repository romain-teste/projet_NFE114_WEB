package com.projetweb.projeturbex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pays {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  
  private Integer idPays;
  private String pays;
  
  public Integer getidPays() {
	  return idPays;
  }
  public void setidPays(Integer idPays) {
	  this.idPays = idPays;
  }
  
  public String getpays() {
	  return pays;
  }
  public void setpays(String pays) {
	  this.pays = pays;
  }
	  
}
