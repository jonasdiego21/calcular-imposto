package br.com.intersol.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intersol.util.ExportarRelatorioPdf;

@Service
public class BoletoService {

	@Autowired
	private ExportarRelatorioPdf exportarRelatorioPdf;
	
	public byte[] gerarBoletoIptu(Long codigo) throws Exception {
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("codigo", codigo);
		
		return exportarRelatorioPdf.exportandoPdf(parametros, "/relatorios/relatorio_boleto_iptu.jasper");
	}
}
