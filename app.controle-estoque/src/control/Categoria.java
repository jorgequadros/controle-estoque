package control;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private int id;
	private String descricao;
	private List<Categoria> lista = new ArrayList<>();
	
	public Categoria() {}
	
	
	public Categoria(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
		
	public List<Categoria> getLista() {
		return lista;
	}


	public void setLista(int id, String descricao) {
		this.lista.add(new Categoria(id, descricao));
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
}
