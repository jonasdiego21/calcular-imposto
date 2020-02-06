package br.com.intersol.repository.helper.imovel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.intersol.model.Imovel;
import br.com.intersol.repository.filter.ImovelFilter;

public interface ImoveisQueries {
	public Page<Imovel> filtrar(ImovelFilter filtro, Pageable pageable);
}