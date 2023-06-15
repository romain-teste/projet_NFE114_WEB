package com.projetweb.projeturbex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Regions {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  
  private Integer idRegion;
  private String region;
  private Integer idPays;
  
  public Integer getidRegion() {
	  return idRegion;
  }
  public void setidRegion(Integer idRegion) {
	  this.idRegion = idRegion;
  }
  
  public String getregion() {
	  return region;
  }
  public void setregion(String region) {
	  this.region = region;
  }
  
  public Integer getidPays() {
	  return idPays;
  }
  public void setidPays(Integer idPays) {
	  this.idPays = idPays;
  }
}
