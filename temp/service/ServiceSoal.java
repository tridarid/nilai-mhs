package pens.ac.id.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pens.ac.id.dao.DaoSoal;
import pens.ac.id.model.Bidang;
import pens.ac.id.model.Soal;
import pens.ac.id.model.Tingkat;


@Service
public class ServiceSoal {

	@Autowired
	private DaoSoal daoSoal;
	
	@Autowired
	private ServiceBidang serviceBidang;
	
	@Autowired
	private ServiceTingkat serviceTingkat;
	
	
	public void save(Soal soal) throws Exception {
		Bidang bidang = serviceBidang.getById(soal.getBidang().getId());
		if(bidang==null){
			throw new Exception(String.format("bidang id %d tidak tidak ditemukan", soal.getBidang().getId()));
		}
		
		Tingkat tingkat = serviceTingkat.getById(soal.getTingkat().getId());
		
		if(tingkat==null){
			throw new Exception(String.format("tingkat id %d tidak tidak ditemukan", soal.getTingkat().getId()));
		}
		
		Soal newSoal = new Soal();
//		newSoal.setTingkatId(soal.getTingkatId());
//		newSoal.setBidangId(soal.getBidangId());
		newSoal.setBidang(bidang);
		newSoal.setTingkat(tingkat);
		newSoal.setTextSoal(soal.getTextSoal());
		daoSoal.save(newSoal);
	}

	public boolean update(Soal soal) throws Exception {
		Bidang bidang = serviceBidang.getById(soal.getBidang().getId());
		if(bidang==null){
			throw new Exception(String.format("bidang id %d tidak tidak ditemukan", soal.getBidang().getId()));
		}
		
		Tingkat tingkat = serviceTingkat.getById(soal.getTingkat().getId());
		
		if(tingkat==null){
			throw new Exception(String.format("tingkat id %d tidak tidak ditemukan", soal.getTingkat().getId()));
		}
		
		Soal newSoal = daoSoal.findOne(soal.getId());
		if(newSoal != null){
//			newSoal.setTingkatId(soal.getTingkatId());
//			newSoal.setBidangId(soal.getBidangId());
			newSoal.setBidang(bidang);
			newSoal.setTingkat(tingkat);
			newSoal.setTextSoal(soal.getTextSoal());
			daoSoal.save(newSoal);
			return true;
		}
		
		return false;
	}


	public List<Soal> getAll() {		
		return daoSoal.findAll();
	}


	public Soal getById(Long soalId) {
		return daoSoal.findOne(soalId);
	}
	
	public void delete(Long soalId) {
		daoSoal.delete(soalId);
	}

}
