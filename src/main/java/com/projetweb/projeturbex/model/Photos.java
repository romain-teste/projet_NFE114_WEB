package com.projetweb.projeturbex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Photos {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  
  private Integer idPhoto;
  private String path;
  private Integer idLieux;
  
  public Integer getidPhoto() {
	  return idPhoto;
  }
  public void setidPhoto(Integer idPhoto) {
	  this.idPhoto = idPhoto;
  }
  
  public String getpath() {
	  return path;
  }
  public void setpath(String path) {
	  this.path = path;
  }
  
  public Integer getidLieux() {
	  return idLieux;
  }
  public void setidLieux(Integer idLieux) {
	  this.idLieux = idLieux;
  }
}
