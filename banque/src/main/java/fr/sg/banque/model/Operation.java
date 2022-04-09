package fr.sg.banque.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Operation {

	private String typeOperation;
	private Date date;
	private BigDecimal montant;
}
