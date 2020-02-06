package br.com.intersol.service;

import static br.com.intersol.util.Constants.INFORMACOES_JA_CADASTRADAS;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intersol.exception.GlobalException;
import br.com.intersol.model.Proprietario;
import br.com.intersol.repository.Proprietarios;

@Service
public class ProprietarioService {

	@Autowired
	private Proprietarios proprietarios;
	
	@Transactional
	public void cadastrar(Proprietario proprietario) {
		Optional<Proprietario> optional = proprietarios.findByNomeIgnoreCase(proprietario.getNome());
		
		if(proprietario.isNovo() && optional.isPresent()) {
			throw new GlobalException(INFORMACOES_JA_CADASTRADAS);
		}
		
		proprietarios.saveAndFlush(proprietario);
	}
	
	@Transactional
	public void excluir(Proprietario proprietario) {
		proprietarios.delete(proprietario);
	}	
}