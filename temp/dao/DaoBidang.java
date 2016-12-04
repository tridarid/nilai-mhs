package pens.ac.id.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import pens.ac.id.model.Bidang;

public interface DaoBidang extends JpaRepository<Bidang, Long> {
}