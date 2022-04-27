package fr.sg.banque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import fr.sg.banque.model.Client;
import fr.sg.banque.model.Compte;
import fr.sg.banque.repository.CompteRepository;
import fr.sg.banque.service.BanqueService;
import fr.sg.banque.service.BanqueServiceImpl;

@SpringBootTest
public class BanqueServiceTest {

	@Autowired
	private BanqueService banqueService;

	@BeforeEach
	void setUp() {

	}

	@AfterEach
	void tearDown() {

	}

	@Test
	void verser() {
		// GIVEN

		Client alain = new Client("ALAIN");
		banqueService.createClient(alain);

		Compte ca = new Compte(LocalDate.now(), new BigDecimal("100"));
		ca.setClient(alain);
		Compte compteTest = banqueService.createCompte(ca);

		Long numeroCompte = compteTest.getNumeroDeCompte();
		BigDecimal montant = new BigDecimal("500");
		String libelle = "depot DAB";
		
		// WHEN
		BigDecimal solde = banqueService.verser(numeroCompte, montant, libelle);
		
		// THEN
		assertEquals(new BigDecimal("600.00"), solde);
		
	}
	
	@Test
	void retirer() {
		// GIVEN

		Client carole = new Client("CAROLE");
		banqueService.createClient(carole);

		Compte ca = new Compte(LocalDate.now(), new BigDecimal("500"));
		ca.setClient(carole);
		Compte compteTest = banqueService.createCompte(ca);

		Long numeroCompte = compteTest.getNumeroDeCompte();
		BigDecimal montant = new BigDecimal("100");
		String libelle = "retrait DAB";
		
		// WHEN
		BigDecimal solde = banqueService.retirer(numeroCompte, montant, libelle);
		
		// THEN
		assertEquals(new BigDecimal("400.00"), solde);
		
	}
}
