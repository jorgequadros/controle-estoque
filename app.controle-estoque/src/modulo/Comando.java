package modulo;

import java.io.IOException;
import java.sql.SQLException;

import control.CategoriaDAO;

public class Comando {
	
	private static final Comando instancia = new Comando();
	private String acao;
	private enum TipoOperacao{
		ALTERAR, CADASTRAR,EXCLUIR, CANCELAR, OK;
	}
	
	public static Comando getInstancia() {
		return instancia;
	}
	
	public String obterComando(String texto, String id, String descricao) throws IOException, SQLException {
		CategoriaDAO categoria = new CategoriaDAO();
		TipoOperacao operacao = detectaOperacao(texto);
		String resultado = "";
		
		if(operacao == TipoOperacao.ALTERAR) {
			
			acao="UPDATE";
		}else if(operacao == TipoOperacao.EXCLUIR) {
			
			acao="DELETE";
		}else if(operacao == TipoOperacao.CADASTRAR) {
			acao = "INSERT";
		}else if(operacao == TipoOperacao.OK) {
			if(acao=="INSERT") {
				categoria.inserirRegistro(descricao);
				
			}else if(acao=="UPDATE") {

			}else if(acao=="DELETE") {
				
			}
			resultado = "Operação realizada!!";
			
		}else if(operacao == TipoOperacao.CANCELAR) {
			resultado ="Operação Cancelada!!";
		}

		return resultado;
	}
	
	private TipoOperacao detectaOperacao(String texto) {
		switch (texto) {
			case "Alterar":
				return TipoOperacao.ALTERAR;
			case "Excluir":
				return TipoOperacao.EXCLUIR;
			case "Cadastrar":
				return TipoOperacao.CADASTRAR;
			case "Ok":
				return TipoOperacao.OK;
			case "Cancelar":
				return TipoOperacao.CANCELAR;
		}
		return null;
	}
}
