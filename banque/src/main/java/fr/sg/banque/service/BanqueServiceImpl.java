package fr.sg.banque.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sg.banque.model.Client;
import fr.sg.banque.model.Compte;
import fr.sg.banque.model.Operation;
import fr.sg.banque.repository.ClientRepository;
import fr.sg.banque.repository.CompteRepository;
import fr.sg.banque.repository.OperationRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BanqueServiceImpl implements BanqueService {
	
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public BigDecimal verser(Long numeroCompte, BigDecimal montant, String libelle) {
		Compte compte = compteRepository.findByNumeroDeCompte(numeroCompte);
		if(compte != null) {
			compte.setSolde(compte.getSolde().add(montant));
			Operation operation = new Operation("V", (LocalDate.now()), montant);
			operation.setLibelle(libelle);
			operation.setCompte(compte);
			operationRepository.save(operation);
			return compte.getSolde();
		}else {
			//throw new CompteNotFoundException
			return null;
		}
		
	}

	@Override
	public BigDecimal retirer(Long numeroCompte, BigDecimal montant,String libelle) {
		Compte compte = compteRepository.findByNumeroDeCompte(numeroCompte);
		if(compte != null) {
			if(compte.getSolde().compareTo(montant)>=0) {
			compte.setSolde(compte.getSolde().subtract(montant));
			Operation operation = new Operation("R", (LocalDate.now()), montant);
			operation.setLibelle(libelle);
			operation.setCompte(compte);
			operationRepository.save(operation);
			return compte.getSolde();
			}else {
				//throw new SoldeInsuffisantException
				return null;
			}
		}else {
			//throw new CompteNotFoundException
			return null;
		}
	}

	@Override
	public List<Operation> consulter(Long numeroCompte) {
		Compte compte = compteRepository.findByNumeroDeCompte(numeroCompte);
		if(compte != null) {
			System.out.println("SOLDE: "+compte.getSolde());
			for(Operation o: compte.getOperations()) {
				System.out.println(o.getDate()+" "+o.getLibelle()+" "+o.getTypeOperation()
				+" "+o.getMontant());
			}
			return compte.getOperations();
		}else {
			//throw new CompteNotFoundExceptio
			return null;
		}
		
	}

	@Override
	public void virer(Long numeroCompteDebiteur, Long numeroCompteCrediteur, BigDecimal montant,String libelle) {
		retirer(numeroCompteDebiteur,montant, libelle);
		verser(numeroCompteCrediteur,montant, libelle);	
	}

	@Override
	public Client createClient(Client client) {
		
		return clientRepository.save(client);
	}

	@Override
	public Compte createCompte(Compte compte) {
		
		return compteRepository.save(compte);
	}


}
