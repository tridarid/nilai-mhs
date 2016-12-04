package pens.ac.id.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pens.ac.id.dao.DaoNilai;
import pens.ac.id.model.Nilai;

import java.util.List;

/**
 * Created by indratir on 23/11/16.
 */
@Service
public class ServiceNilai {
    @Autowired
    private DaoNilai daoNilai;

    public DaoNilai getDao() {
        return daoNilai;
    }

    public void save(Nilai nilai){
        daoNilai.save(nilai);
    }

    public boolean update(Nilai nilai){
        Nilai oldNilai = daoNilai.findOne(nilai.getKode_mk());
        if (oldNilai!=null){
            oldNilai.setNilai(nilai.getNilai());
            daoNilai.save(oldNilai);
            return true;
        }
        return false;
    }

    public List<Nilai> getAll(){
        return daoNilai.findAll();
    }

    public Nilai getById(Long nilaiId){
        return daoNilai.findOne(nilaiId);
    }

    public void delete(Long nilaiId){
        daoNilai.delete(nilaiId);
    }
}
