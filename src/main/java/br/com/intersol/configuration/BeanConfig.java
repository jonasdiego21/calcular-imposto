package br.com.intersol.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import br.com.intersol.boleto.BoletoBancario;
import br.com.intersol.boleto.ExportarArquivoFormato;
import br.com.intersol.boleto.GerarBoleto;
import br.com.intersol.util.ExportarRelatorioPdf;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class BeanConfig {

	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		return new SpringSecurityDialect();
	}
	
	@Bean
	public BoletoBancario getBoletoBancario() {
		return new GerarBoleto();
	}
	
	@Bean
	public ExportarArquivoFormato getExportarArquivoFormato() {
		return new ExportarRelatorioPdf();
	}
}