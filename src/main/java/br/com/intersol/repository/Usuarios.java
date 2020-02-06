package br.com.intersol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.intersol.model.Usuario;
import br.com.intersol.repository.helper.usuario.UsuariosQueries;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByEmailIgnoreCaseAndAtivoTrue(String email);
	List<String> permissoes(Usuario usuario);
	List<Usuario> findAllByOrderByNomeAsc();
}