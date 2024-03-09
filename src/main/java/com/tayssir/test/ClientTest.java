package com.tayssir.test;

import com.tayssir.dao.ClientDao;
import com.tayssir.entities.Client;

public class ClientTest {
	public static void main(String[] args) {
		
//créer un objet client
		Client c = new Client();
		c.setNom("tayssir");
		c.setVille("Nabeul");
		
//ajouter l'objet client à la BD
		ClientDao cltDao = new ClientDao();
		cltDao.ajouter(c);
		
		System.out.println("Appel de la méthode listerTous");
		for (Client cl : cltDao.listerTous())
			System.out.println(cl.getCode() + " " + cl.getNom());
		
		
		System.out.println("Appel de la méthode listerParNom");
		for (Client cl : cltDao.listerParNom("tay"))

			System.out.println(cl.getCode() + " " + cl.getNom());

//tester les autres méthodes de la classe ClientDao
		
		
		// Modifier un client
        c.setVille("manzel temime"); // Modification du nom de la ville
        cltDao.modifier(c);

        // Afficher tous les clients après modification
        System.out.println("Appel de la méthode listerTous après modification");
        for (Client cl : cltDao.listerTous())
            System.out.println(cl.getCode() + " " + cl.getNom() + " - " + cl.getVille());

        // Supprimer un client
        cltDao.supprimer(c);

        // Afficher tous les clients après suppression
        System.out.println("Appel de la méthode listerTous après suppression");
        for (Client cl : cltDao.listerTous())
            System.out.println(cl.getCode() + " " + cl.getNom());
    }
	
}