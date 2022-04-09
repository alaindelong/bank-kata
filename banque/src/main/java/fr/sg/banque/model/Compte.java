package fr.sg.banque.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Compte {

	private String numeroDeCompte;
	private Date dateDeCreation;
    private BigDecimal solde;
    private List<Operation> operations; 
}

