package org.pfe.dao;

import org.pfe.entities.facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface factureRepository extends JpaRepository<facture, Long> {

}
