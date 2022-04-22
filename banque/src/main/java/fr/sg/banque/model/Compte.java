package fr.sg.banque.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Compte implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long numeroDeCompte;
	private LocalDate dateDeCreation;
    private BigDecimal solde;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;
    public Compte() {
    	
    }
	public Compte(LocalDate dateDeCreation, BigDecimal solde) {
		this.dateDeCreation = dateDeCreation;
		this.solde = solde;
	} 
    
}

