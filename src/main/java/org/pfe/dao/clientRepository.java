package org.pfe.dao;

import org.pfe.entities.client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepository extends JpaRepository<client /*entite*/ , Long /*type de la primery key*/ > {

}
