package pens.ac.id.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pens.ac.id.dao.DaoBidang;
import pens.ac.id.model.Bidang;


@Service
public class ServiceBidang {

	@Autowired
	private DaoBidang daoBidang;
	

	public DaoBidang getDao() {
		return daoBidang;
	}

	public void save(Bidang bidang) {
		daoBidang.save(bidang);
	}

	public boolean update(Bidang bidang) {
		Bidang oldBidang = daoBidang.findOne(bidang.getId());
		if(oldBidang != null){
			oldBidang.setNama(bidang.getNama());
			daoBidang.save(oldBidang);
			return true;
		}
		return false;
	}

	public List<Bidang> getAll() {
		return daoBidang.findAll();
	}

	public Bidang getById(Long bidangId) {
		return daoBidang.findOne(bidangId);
	}

	public void delete(Long bidangId) {
		daoBidang.delete(bidangId);
	}
}
