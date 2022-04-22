package fr.sg.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sg.banque.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

	Compte findByNumeroDeCompte(Long numeroDeCompte);
}
