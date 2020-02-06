package br.com.intersol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.intersol.model.Grupo;

@Repository
public interface Grupos extends JpaRepository<Grupo, Long> {

}