package fr.sg.banque.service;

import java.math.BigDecimal;
import java.util.List;

import fr.sg.banque.model.Operation;

public interface BanqueService {

	public void verser(String numeroCompte, BigDecimal montant);
	public void retirer(String numeroCompte, BigDecimal montant);
	public List<Operation> consulter(String numeroCompte);
}
