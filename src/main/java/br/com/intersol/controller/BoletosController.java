package br.com.intersol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.intersol.boleto.GerarBoleto;
import br.com.intersol.service.BoletoService;

@RestController
@RequestMapping("/boletos")
public class BoletosController {

	@Autowired
	private GerarBoleto gerarBoleto;
	
	@Autowired
	private BoletoService boletoService;
	
	@GetMapping("/imovel/{codigo}")
	public ResponseEntity<byte[]> gerarRelatorioVendas(@RequestParam Long codigo) throws Exception {
		byte[] relatorio = boletoService.gerarBoletoIptu(codigo);
		
		return gerarBoleto.relatorioEmPdf(relatorio);
	}
}
