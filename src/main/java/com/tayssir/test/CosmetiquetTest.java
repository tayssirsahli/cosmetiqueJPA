package com.tayssir.test;

import com.tayssir.dao.ClientDao;
import com.tayssir.dao.CosmetiqueDao;
import com.tayssir.entities.Cosmetique;

public class CosmetiquetTest {
	public static void main(String[] args) {
		
//créer un objet Cosmetique
		Cosmetique c = new Cosmetique();
		c.setNomCosmetique("svr gel nettoyant");
		c.setPrix(45);
		
		Cosmetique d = new Cosmetique();

		d.setNomCosmetique("parfum");
		d.setPrix(800);
		
//ajouter l'objet à la Cosmetique BD
		CosmetiqueDao cltDao = new CosmetiqueDao();
		cltDao.ajouter(c);
		cltDao.ajouter(d);
		
		System.out.println("Appel de la méthode listerTous");
		for (Cosmetique cl : cltDao.listerTous())
			System.out.println(cl.getIdCosmetique() + " " + cl.getNomCosmetique());
		
		
		System.out.println("Appel de la méthode listerParNom");
		for (Cosmetique cl : cltDao.listerParNom("svr"))

			System.out.println(cl.getIdCosmetique() + " " + cl.getNomCosmetique());

//tester les autres méthodes de la classe CosmetiqueDao
		
		
		// Modifier un Cosmetique
        c.setPrix(49); // Modification le prix
        cltDao.modifier(c);

        // Afficher tous les Cosmetiques après modification
        System.out.println("Appel de la méthode listerTous après modification");
        for (Cosmetique cl : cltDao.listerTous())
            System.out.println(cl.getIdCosmetique() + " " + cl.getNomCosmetique() + " - " + cl.getPrix());

        // Supprimer un client
        cltDao.supprimer(c);

        // Afficher tous les Cosmetiques après suppression
        System.out.println("Appel de la méthode listerTous après suppression");
        for (Cosmetique cl : cltDao.listerTous())
            System.out.println(cl.getIdCosmetique() + " " + cl.getNomCosmetique());
    }
	
}