package org.pfe.metier;

import java.util.Collection;
import java.util.List;

import org.pfe.dao.sous_prefectureRepository;
import org.pfe.dao.prefectureRepository;
import org.pfe.entities.canton;
import org.pfe.entities.prefecture;
import org.pfe.entities.sous_prefecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class sous_prefectureMetierImplementation implements  sous_prefectureMetier {
	
	@Autowired
    private sous_prefectureRepository sous_prefectureRepository;
	
	@Autowired
    private prefectureRepository prefectureRepository;
    
	@Override
	public sous_prefecture ajoutsous_prefecture(sous_prefecture spf) {
		// TODO Auto-generated method stub
		return sous_prefectureRepository.save(spf);
	}

	@Override
	public List<sous_prefecture> listsous_prefecture() {
		// TODO Auto-generated method stub
		return sous_prefectureRepository.findAll();
	}
	
	@Override
	public sous_prefecture chargerSous_prefecture(long code) {
		return sous_prefectureRepository.findOne(code);
	}

	@Override
	@Transactional
	public boolean changerLibelle(long code, String libelle, String nom, long codePrefecture) {
		sous_prefecture Sp = sous_prefectureRepository.findOne(code);
		prefecture P = prefectureRepository.findOne(codePrefecture);
		Sp.setLibelle(libelle);
		Sp.setNom_sous_prefecture(nom);
		Sp.setPrefecture(P);
		
		return true;
		
	}

	@Override
	@Transactional
	public boolean changerPrefecture(long codeSp, long codeP) {
		sous_prefecture C = sous_prefectureRepository.findOne(codeSp);
		C.setPrefecture(prefectureRepository.findOne(codeP));
		return true;
	}

	@Override
	@Transactional
	public Collection<canton> Listcanton(long code) {
		sous_prefecture S = sous_prefectureRepository.findOne(code);
		return S.getcanton();
	}

}
