package com.projetweb.projeturbex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Commentaires {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  
  private Integer idCom;
  private Integer idLieu;
  private String texteCom;
  private boolean visibility;
  
  public Integer getidCom() {
	  return idCom;
  }
  public void setid(Integer idCom) {
	  this.idCom = idCom;
  }
  
  public Integer getidLieu() {
	  return idLieu;
  }
  public void setidLieu(Integer idLieu) {
	  this.idLieu = idLieu;
  }
  
  public String gettexteCom() {
	  return texteCom;
  }
  public void settexteCom(String texteCom) {
	  this.texteCom = texteCom;
  }
	public boolean getVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

  
}
