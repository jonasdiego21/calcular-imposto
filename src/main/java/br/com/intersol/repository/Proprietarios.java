package br.com.intersol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.intersol.model.Proprietario;
import br.com.intersol.repository.helper.proprietario.ProprietariosQueries;

@Repository
public interface Proprietarios extends JpaRepository<Proprietario, Long>, ProprietariosQueries {
	public Optional<Proprietario> findByNomeIgnoreCase(String nome);
	public List<Proprietario> findAllByOrderByNomeAsc();
}