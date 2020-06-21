package org.pfe.dao;

import org.pfe.entities.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface utilisateurRepository extends JpaRepository<utilisateur, Long> {

}
