package br.com.intersol.util;

public class Constants {

	/* GLOBAL */
	public static final String FORMAT_DATE = "dd/MM/yyyy";
	public static final String FORMAT_TIME = "HH:mm:ss";
	public static final String FORMAT_MOEDA = "#,##0.00";

	public final static String INFORMACOES_SALVAS_SUCESSO = "Informações salvas com sucesso!";
	public final static String INFORMACOES_JA_CADASTRADAS = "Informações já cadastradas!";
	public final static String INFORMACOES_NAO_CADASTRADO = "Informações não cadastrado!";
	public final static String ERRO_SALVAR_INFORMACOES = "Erro ao salvar as informações!";
	
	public final static String INFORMACOES_EXCLUIDAS_SUCESSO = "Informações excluídas com sucesso!";
	public final static String ERRO_EXCLUIR_INFORMACOES = "Erro ao excluir as informações!";
	
	public static final String USUARIO_SENHA_OBRIGATORIA = "A Senha é obrigatória";
	public static final String USUARIO_SENHA_INCORRETOS = "E-mail e/ou Senha estão incorretos!";
	public static final String SENHAS_NAO_CONFEREM = "Senha não conferem!";
	
	public final static String VIEW_LOGIN = "Login";
	public final static String VIEW_DASHBOARD = "dashboard/Dashboard";
	
	/* PROPRIETÁRIO */
	public final static String VIEW_PESQUISAR_PROPRIETARIO = "proprietario/PesquisarProprietario";
	public final static String VIEW_PROPRIETARIO_NOVO = "proprietario/CadastrarProprietario";
	public final static String VIEW_PROPRIETARIO_REDIRECT = "redirect:/proprietarios/novo";
	
	/* IMÓVEL */
	public final static String VIEW_PESQUISAR_IMOVEL = "imovel/PesquisarImovel";
	public final static String VIEW_IMOVEL_NOVO = "imovel/CadastrarImovel";
	public final static String VIEW_IMOVEL_REDIRECT = "redirect:/imoveis/novo";
	
	/* USUÁRIO */
	public final static String VIEW_PESQUISAR_USUARIO = "usuario/PesquisarUsuario";
	public final static String VIEW_USUARIO_NOVO = "usuario/CadastrarUsuario";
	public final static String VIEW_USUARIO_REDIRECT = "redirect:/usuarios/novo";
}
