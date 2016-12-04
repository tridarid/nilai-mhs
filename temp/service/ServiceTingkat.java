package pens.ac.id.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pens.ac.id.dao.DaoTingkat;
import pens.ac.id.model.Tingkat;


@Service
public class ServiceTingkat {

	@Autowired
	private DaoTingkat daoTingkat;
	

	public DaoTingkat getDao() {
		return daoTingkat;
	}

	public void save(Tingkat tingkat) {
		daoTingkat.save(tingkat);
	}

	public boolean update(Tingkat tingkat) {
		Tingkat oldTingkat = daoTingkat.findOne(tingkat.getId());
		if(oldTingkat != null){
			oldTingkat.setNama(tingkat.getNama());
			daoTingkat.save(oldTingkat);
			return true;
		}
		return false;
	}

	public List<Tingkat> getAll() {
		return daoTingkat.findAll();
	}

	public Tingkat getById(Long tingkatId) {
		return daoTingkat.findOne(tingkatId);
	}
	
	public void delete(Long tingkatId) {
		daoTingkat.delete(tingkatId);
	}

}
