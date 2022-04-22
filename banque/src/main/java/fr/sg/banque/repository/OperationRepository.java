package fr.sg.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sg.banque.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
