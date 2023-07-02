package com.projetweb.projeturbex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrateurs {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  
  private Integer idAdmin;
  private String nomAdmin;
  private String mdpAdmin;
  
  public Integer getidAdmin() {
	  return idAdmin;
  }
  public void setid(Integer idAdmin) {
	  this.idAdmin = idAdmin;
  }
  
  public String getnomAdmin() {
	  return nomAdmin;
  }
  public void setnomAdmin(String nomAdmin) {
	  this.nomAdmin = nomAdmin;
  }
  
  public String getmdpAdmin() {
	  return mdpAdmin;
  }
  public void setmdpAdmin(String mdpAdmin) {
	  this.mdpAdmin = mdpAdmin;
  }
}
