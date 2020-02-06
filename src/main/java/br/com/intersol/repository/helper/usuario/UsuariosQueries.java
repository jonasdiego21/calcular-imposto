package br.com.intersol.repository.helper.usuario;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.intersol.model.Usuario;
import br.com.intersol.repository.filter.UsuarioFilter;

public interface UsuariosQueries {
	public List<String> permissoes(Usuario usuario);
	public Page<Usuario> filtrar(UsuarioFilter filtro, Pageable pageable);
}