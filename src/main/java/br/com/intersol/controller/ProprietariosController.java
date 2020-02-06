package br.com.intersol.controller;

import static br.com.intersol.util.Constants.INFORMACOES_SALVAS_SUCESSO;
import static br.com.intersol.util.Constants.VIEW_PESQUISAR_PROPRIETARIO;
import static br.com.intersol.util.Constants.VIEW_PROPRIETARIO_NOVO;
import static br.com.intersol.util.Constants.VIEW_PROPRIETARIO_REDIRECT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.intersol.exception.GlobalException;
import br.com.intersol.model.Proprietario;
import br.com.intersol.repository.Estados;
import br.com.intersol.repository.Proprietarios;
import br.com.intersol.repository.filter.ProprietarioFilter;
import br.com.intersol.service.ProprietarioService;

@Controller
@RequestMapping("/proprietarios")
public class ProprietariosController {

	@Autowired
	private ProprietarioService proprietarioService;
	
	@Autowired
	private Proprietarios proprietarios;
	
	@Autowired
	private Estados estados;
	
	@GetMapping("/novo")
	public ModelAndView novo(Proprietario proprietario) {
		ModelAndView mv = new ModelAndView(VIEW_PROPRIETARIO_NOVO);
		mv.addObject("proprietarios", proprietarios.findAllByOrderByNomeAsc());
		mv.addObject("estados", estados.findAllByOrderByNomeAsc());
		mv.addObject(proprietario);
		
		return mv;
	}
	
	@PostMapping
	public ModelAndView cadastrar(@Valid Proprietario proprietario, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(proprietario);
		}
		
		try {
			proprietarioService.cadastrar(proprietario);
		} catch (GlobalException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(proprietario);		
		}
		
		attributes.addFlashAttribute("successMessage", INFORMACOES_SALVAS_SUCESSO);
		
		return new ModelAndView(VIEW_PROPRIETARIO_REDIRECT);
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Proprietario proprietario) {	
		ModelAndView mv = novo(proprietario);
		mv.addObject(proprietario);
		
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Proprietario proprietario) {
		try {
			proprietarioService.excluir(proprietario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();	
	}
	
	@GetMapping
	public ModelAndView pesquisar(ProprietarioFilter proprietarioFilter, BindingResult result, @PageableDefault(size = 25) Pageable pageable) {
		ModelAndView mv = new ModelAndView(VIEW_PESQUISAR_PROPRIETARIO);
		mv.addObject("proprietarios", proprietarios.findAllByOrderByNomeAsc());
		mv.addObject("estados", estados.findAllByOrderByNomeAsc());
		
		Page<Proprietario> pagina = proprietarios.filtrar(proprietarioFilter, pageable);
		mv.addObject("pagina", pagina);
		
		return mv;
	}
}