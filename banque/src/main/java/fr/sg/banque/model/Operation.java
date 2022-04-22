package fr.sg.banque.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Operation implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeOperation;
	private LocalDate date;
	private BigDecimal montant;
	private String libelle;
	@ManyToOne
	private Compte compte;
	public Operation() {
		
	}
	public Operation(String typeOperation, LocalDate date, BigDecimal montant) {
		super();
		this.typeOperation = typeOperation;
		this.date = date;
		this.montant = montant;
	}
	
	
}
