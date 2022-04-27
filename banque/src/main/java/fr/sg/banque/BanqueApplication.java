package fr.sg.banque;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.sg.banque.model.Client;
import fr.sg.banque.model.Compte;
import fr.sg.banque.service.BanqueService;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {

	@Autowired
	private BanqueService banqueService;
	
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	//creation client
		
		  Client alain = new Client("ALAIN"); Client carole = new Client("CAROLE");
		  banqueService.createClient(carole); banqueService.createClient(alain);
		  
		  //creation compte pour alain et carole 
		  Compte ca = new Compte(LocalDate.now(), new BigDecimal("100")); 
		  ca.setClient(alain); 
		  Compte cc = new Compte(LocalDate.now(), new BigDecimal("200"));
		  cc.setClient(carole); banqueService.createCompte(cc);
		  banqueService.createCompte(ca);
		 
		
		//operation sur les comptes
		banqueService.verser(3L, new BigDecimal("1000"),"DAB");
		banqueService.verser(4L, new BigDecimal("2000"),"DAB");
		banqueService.retirer(3L, new BigDecimal("300"),"DAB");
		banqueService.retirer(4L, new BigDecimal("400"),"DAB");
		banqueService.virer(3L, 4L, new BigDecimal("150"), "VIREMENT");
		
		banqueService.consulter(3L);  */
	}

}
