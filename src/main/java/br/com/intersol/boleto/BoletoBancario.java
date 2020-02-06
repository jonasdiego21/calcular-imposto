package br.com.intersol.boleto;

import org.springframework.http.ResponseEntity;

public interface BoletoBancario {
	public ResponseEntity<byte[]> relatorioEmPdf(byte[] relatorio);
}
