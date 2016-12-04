package pens.ac.id.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import pens.ac.id.model.Tingkat;

public interface DaoTingkat extends JpaRepository<Tingkat, Long> {
}