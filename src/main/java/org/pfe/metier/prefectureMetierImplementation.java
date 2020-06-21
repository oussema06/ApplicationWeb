package org.pfe.metier;

import java.util.Collection;
import java.util.List;

import org.pfe.dao.paysRepository;
import org.pfe.dao.prefectureRepository;
import org.pfe.entities.pays;
import org.pfe.entities.prefecture;
import org.pfe.entities.sous_prefecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class prefectureMetierImplementation implements  prefectureMetier {
	
	@Autowired
    private prefectureRepository prefectureRepository;
	
	@Autowired
    private paysRepository paysRepository;
    
	@Override
	public prefecture ajoutprefecture(prefecture pf) {
		// TODO Auto-generated method stub
		return prefectureRepository.save(pf);
	}

	@Override
	public List<prefecture> listprefecture() {
		// TODO Auto-generated method stub
		return prefectureRepository.findAll();
	}

	@Override
	public prefecture chargerPrefecture(long code) {
		return prefectureRepository.findOne(code);
	}

	@Override
	@Transactional
	public boolean changerLibelle(long code, String libelle, String nom, long codePays) {
		prefecture P = prefectureRepository.findOne(code);
		pays Py = paysRepository.findOne(codePays);
		P.setLibelle(libelle);
		P.setNom_prefecture(nom);
		P.setPays(Py);
		
		return true;
	}

	@Override
	@Transactional
	public Collection<sous_prefecture> Listsous_prefecture(long code) {
		prefecture P = prefectureRepository.findOne(code);
		return P.getsous_Prefecture();
	}

}
