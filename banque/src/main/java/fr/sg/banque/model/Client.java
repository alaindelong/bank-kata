package fr.sg.banque.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Client implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long codeClient;
	private String nom;
	@OneToMany(mappedBy = "client")
	private List<Compte> comptes;
	public Client() {
		
	}
	public Client(String nom) {
		this.nom = nom;
	}
	
}
