package com.tayssir.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.tayssir.entities.Cosmetique;
import com.tayssir.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class CosmetiqueDao {
	private EntityManager entityManager = JPAutil.getEntityManager("CosmetiqueJPA");

//méthode ajouter d'une entité à la bd
	public void ajouter(Cosmetique c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);

		tx.commit();
	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Cosmetique c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Cosmetique c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c = entityManager.merge(c); // important
		entityManager.remove(c);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Cosmetique consulter(Cosmetique c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Cosmetique> listerTous() {
		List<Cosmetique> cosmetiques = entityManager.createQuery("select c from Cosmetique c").getResultList();

		return cosmetiques;
	}

//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Cosmetique> listerParNom(String nom) {
		List<Cosmetique> cosmetiques = entityManager.createQuery("select c from Cosmetique c where c.nomCosmetique like :pnom").setParameter("pnom", "%" + nom + "%").getResultList();

		return cosmetiques;
	}
}