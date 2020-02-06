package br.com.intersol.repository.helper.proprietario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.intersol.model.Proprietario;
import br.com.intersol.repository.filter.ProprietarioFilter;

public interface ProprietariosQueries {
	public Page<Proprietario> filtrar(ProprietarioFilter filtro, Pageable pageable);
}