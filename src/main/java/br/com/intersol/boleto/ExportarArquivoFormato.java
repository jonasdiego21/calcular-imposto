package br.com.intersol.boleto;

import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

public interface ExportarArquivoFormato {
	public byte[] exportandoPdf(Map<String, Object> parametros, String caminhoRelatorio) throws JRException, SQLException;
}
