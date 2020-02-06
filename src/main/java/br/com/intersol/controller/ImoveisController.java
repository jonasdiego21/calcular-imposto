package br.com.intersol.controller;

import static br.com.intersol.util.Constants.INFORMACOES_SALVAS_SUCESSO;
import static br.com.intersol.util.Constants.VIEW_IMOVEL_NOVO;
import static br.com.intersol.util.Constants.VIEW_IMOVEL_REDIRECT;
import static br.com.intersol.util.Constants.VIEW_PESQUISAR_IMOVEL;

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
import br.com.intersol.model.Imovel;
import br.com.intersol.repository.Estados;
import br.com.intersol.repository.Imoveis;
import br.com.intersol.repository.Proprietarios;
import br.com.intersol.repository.filter.ImovelFilter;
import br.com.intersol.service.ImovelService;

@Controller
@RequestMapping("/imoveis")
public class ImoveisController {

	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private Imoveis imoveis;
	
	@Autowired
	private Estados estados;
	
	@Autowired
	private Proprietarios proprietarios;
	
	@GetMapping("/novo")
	public ModelAndView novo(Imovel imovel) {
		ModelAndView mv = new ModelAndView(VIEW_IMOVEL_NOVO);
		mv.addObject("imoveis", imoveis.findAllByOrderByProprietarioAsc());
		mv.addObject("estados", estados.findAllByOrderByNomeAsc());
		mv.addObject("proprietarios", proprietarios.findAllByOrderByNomeAsc());
		mv.addObject("areaTotal", imovel.getAreaTotal());
		mv.addObject("valorVenalTotal", imovel.getValorVenalTotal());
		mv.addObject("valorImposto", imovel.getValorImposto());
		mv.addObject(imovel);
		
		return mv;
	}
	
	@PostMapping
	public ModelAndView cadastrar(@Valid Imovel imovel, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(imovel);
		}
		
		try {
			imovelService.cadastrar(imovel);
		} catch (GlobalException e) {
			result.rejectValue("endereco.logradouro", e.getMessage(), e.getMessage());
			return novo(imovel);		
		}
		
		attributes.addFlashAttribute("successMessage", INFORMACOES_SALVAS_SUCESSO);
		
		return new ModelAndView(VIEW_IMOVEL_REDIRECT);
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Imovel imovel) {	
		ModelAndView mv = novo(imovel);
		mv.addObject(imovel);
		
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Imovel imovel) {
		try {
			imovelService.excluir(imovel);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();	
	}
	
	@GetMapping
	public ModelAndView pesquisar(ImovelFilter imovelFilter, BindingResult result, @PageableDefault(size = 25) Pageable pageable) {
		ModelAndView mv = new ModelAndView(VIEW_PESQUISAR_IMOVEL);
		mv.addObject("imovels", imoveis.findAllByOrderByProprietarioAsc());
		mv.addObject("estados", estados.findAllByOrderByNomeAsc());
		mv.addObject("proprietarios", proprietarios.findAllByOrderByNomeAsc());
		
		Page<Imovel> pagina = imoveis.filtrar(imovelFilter, pageable);
		mv.addObject("pagina", pagina);
		
		return mv;
	}
}