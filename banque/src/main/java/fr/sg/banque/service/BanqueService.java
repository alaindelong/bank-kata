package fr.sg.banque.service;

import java.math.BigDecimal;
import java.util.List;

import fr.sg.banque.model.Client;
import fr.sg.banque.model.Compte;
import fr.sg.banque.model.Operation;

public interface BanqueService {

	public BigDecimal verser(Long numeroCompte, BigDecimal montant, String libelle);
	public BigDecimal retirer(Long numeroCompte, BigDecimal montant, String libelle);
	public List<Operation> consulter(Long numeroCompte);
	public void virer(Long numeroCompteDebiteur, Long numeroCompteCrediteur, BigDecimal montant, String libelle);
	public Client createClient(Client client);
	public Compte createCompte(Compte compte);
}
