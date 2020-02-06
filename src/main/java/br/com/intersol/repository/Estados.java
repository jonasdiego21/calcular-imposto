package br.com.intersol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.intersol.model.Estado;

@Repository
public interface Estados extends JpaRepository<Estado, Long> {
	public List<Estado> findAllByOrderByNomeAsc();
}