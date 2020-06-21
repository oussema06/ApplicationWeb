package org.pfe.metier;

import java.util.List;

import org.pfe.dao.expression_de_besoinRepository;
import org.pfe.entities.expression_de_besoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class expression_de_besoinMetierImplementation implements  expression_de_besoinMetier {
	
	@Autowired
    private expression_de_besoinRepository expression_de_besoinRepository;
	
	
	@Override
	public expression_de_besoin ajoutexpression_de_besoin(expression_de_besoin ex) {
		// TODO Auto-generated method stub
		return expression_de_besoinRepository.save(ex);
	}

	@Override
	public List<expression_de_besoin> listexpression_de_besoin() {
		// TODO Auto-generated method stub
		return expression_de_besoinRepository.findAll();
	}
	
	
}
