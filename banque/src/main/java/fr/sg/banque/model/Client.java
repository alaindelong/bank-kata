package fr.sg.banque.model;

import java.util.List;

import lombok.Data;

@Data
public class Client {
	
	private String nom;
	private List<Compte> comptes;
}
