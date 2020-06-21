package org.pfe.metier;

import java.util.Collection;
import java.util.List;

import org.pfe.dao.cantonRepository;
import org.pfe.dao.sous_prefectureRepository;
import org.pfe.entities.canton;
import org.pfe.entities.client;
import org.pfe.entities.sous_prefecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class cantonMetierImplementation implements  cantonMetier {
	
	@Autowired
    private cantonRepository cantonRepository;
	
	@Autowired
    private sous_prefectureRepository sous_prefectureRepository;
    
	@Override
	public canton ajoutcanton(canton ct) {
		// TODO Auto-generated method stub
		return cantonRepository.save(ct);
	}

	@Override
	public List<canton> listcanton() {
		// TODO Auto-generated method stub
		return cantonRepository.findAll();
	}

	@Override
	public canton chargerCanton(long code) {
		return cantonRepository.findOne(code);
	}

	@Override
	@Transactional
	public boolean changerLibelle(long code, String libelle, String nom, long codeSous_prefecture) {
		canton C = cantonRepository.findOne(code);
		sous_prefecture P = sous_prefectureRepository.findOne(codeSous_prefecture);
		C.setLibelle(libelle);
		C.setNom_canton(nom);
		C.setSous_prefecture(P);
		return true;
		
	}

	@Override
	@Transactional
	public boolean changerSous_prefecture(long codeC, long codeSP) {
		canton C = cantonRepository.findOne(codeC);
		C.setSous_prefecture(sous_prefectureRepository.findOne(codeSP));
		return true;
	}

	@Override
	@Transactional
	public Collection<client> Listclient(long code) {
		canton C = cantonRepository.findOne(code);
		return C.getclient();
	}
	
	
}
