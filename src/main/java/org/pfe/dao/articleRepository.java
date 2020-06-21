package org.pfe.dao;

import org.pfe.entities.article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface articleRepository extends JpaRepository<article, Long> {

}
