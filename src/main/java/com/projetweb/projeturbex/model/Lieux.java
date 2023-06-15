package com.projetweb.projeturbex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lieux {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  
  private Integer idLieu;
  private String nomLieu;
  private String localisation;
  private String description;
  private String lieuPays;
  private String lieuRegion;
  private String lieuType;
  private Integer idPays;
  private Integer idAdmin;
  private Integer idRegion;
  private Integer idLieuType;
  
  public Integer getid() {
	  return idLieu;
  }
  public void setid(Integer id) {
	  this.idLieu = id;
  }
  
  public String getnom() {
	  return nomLieu;
  }
  public void setnom(String nom) {
	  this.nomLieu = nom;
  }
  
  public String getloc() {
	  return localisation;
  }
  public void setloc(String localisation) {
	  this.localisation = localisation;
  }
  
  public String getdesc() {
	  return description;
  }
  public void setdesc(String desctiption) {
	  this.description = desctiption;
  }
  
  public Integer getidPays() {
	  return idPays;
  }
  public void setidPays(Integer idPays) {
	  this.idPays = idPays;
  }
  
  public Integer getidAdmin() {
	  return idAdmin;
  }
  public void setidAdmin(Integer idAdmin) {
	  this.idAdmin = idAdmin;
  }
  
  public Integer getidRegion() {
	  return idRegion;
  }
  public void setidRegion(Integer idRegion) {
	  this.idRegion = idRegion;
  }
  
  public Integer getidLieuType() {
	  return idLieuType;
  }
  public void setidLieuType(Integer idLieuType) {
	  this.idLieuType = idLieuType;
  }
  
	public String getLieuPays() {
		return lieuPays;
	}
	public void setLieuPays(String lieu_pays) {
		this.lieuPays = lieu_pays;
	}
	public String getLieuType() {
		return lieuType;
	}
	public void setLieuType(String lieuType) {
		this.lieuType = lieuType;
	}
	public String getLieuRegion() {
		return lieuRegion;
	}
	public void setLieuRegion(String lieuRegion) {
		this.lieuRegion = lieuRegion;
	}
  
}
