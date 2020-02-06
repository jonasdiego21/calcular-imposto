package br.com.intersol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.intersol.model.Imovel;
import br.com.intersol.repository.helper.imovel.ImoveisQueries;

@Repository
public interface Imoveis extends JpaRepository<Imovel, Long>, ImoveisQueries {
	public Optional<Imovel> findByEnderecoLogradouroIgnoreCase(String logradouro);
	public List<Imovel> findAllByOrderByProprietarioAsc();
}