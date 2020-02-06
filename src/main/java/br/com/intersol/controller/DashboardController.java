package br.com.intersol.controller;

import static br.com.intersol.util.Constants.VIEW_DASHBOARD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.intersol.repository.Imoveis;
import br.com.intersol.repository.Proprietarios;
import br.com.intersol.repository.Usuarios;
import br.com.intersol.security.UsuarioSistema;

@Controller
@RequestMapping("/")
public class DashboardController {

	@Autowired
	private Proprietarios proprietarios;
	
	@Autowired
	private Imoveis imoveis;
	
	@Autowired
	private Usuarios usuarios;
	
	// boletos gerados
	
	@GetMapping
	public ModelAndView index(@AuthenticationPrincipal UsuarioSistema usuarioSistema) {	
		ModelAndView mv = new ModelAndView(VIEW_DASHBOARD);
		mv.addObject("totalProprietarios", proprietarios.count());
		mv.addObject("totalImoveis", imoveis.count());
		mv.addObject("totalUsuarios", usuarios.count());
		//mv.addObject("totalBoletos", boletos.count());
		
		return mv;
	}
}