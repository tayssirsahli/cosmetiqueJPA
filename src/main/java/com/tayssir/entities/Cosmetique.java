package com.tayssir.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cosmetique implements Serializable {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idCosmetique;
	private String nomCosmetique;
	private double prix;
	
	
	
	public Long getIdCosmetique() {
		return idCosmetique;
	}
	public void setIdCosmetique(Long idCosmetique) {
		this.idCosmetique = idCosmetique;
	}
	public String getNomCosmetique() {
		return nomCosmetique;
	}
	public void setNomCosmetique(String nomCosmetique) {
		this.nomCosmetique = nomCosmetique;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	
	
	
}