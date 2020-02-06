package br.com.intersol.service;

import static br.com.intersol.util.Constants.INFORMACOES_JA_CADASTRADAS;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intersol.exception.GlobalException;
import br.com.intersol.model.Imovel;
import br.com.intersol.repository.Imoveis;

@Service
public class ImovelService {

	@Autowired
	private Imoveis imoveis;
	
	@Transactional
	public void cadastrar(Imovel imovel) {
		Optional<Imovel> optional = imoveis.findByEnderecoLogradouroIgnoreCase(imovel.getEndereco().getLogradouro());
		
		if(imovel.isNovo() && optional.isPresent()) {
			throw new GlobalException(INFORMACOES_JA_CADASTRADAS);
		}
		
		imoveis.saveAndFlush(imovel);
	}
	
	@Transactional
	public void excluir(Imovel imovel) {
		imoveis.delete(imovel);
	}	
}