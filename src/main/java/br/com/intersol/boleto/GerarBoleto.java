package br.com.intersol.boleto;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GerarBoleto implements BoletoBancario {

	@Override
	public ResponseEntity<byte[]> relatorioEmPdf(byte[] relatorio) {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE).body(relatorio);
	}
}
