package control;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

	private int id;
	private String razaoSocial;
	private String endereco;
	private String cidade;
	private String bairro;
	private int uf;
	private int cep;
	
	public int getUf() {
		return uf;
	}

	public void setUf(int uf) {
		this.uf = uf;
	}
	
	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public int getCep() {
		return cep;
	}

	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	List<Contato> TContato = new ArrayList<>();
	
	public Fornecedor(int id, String razaoSocial, String endereco) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Contato> getTContato() {
		return TContato;
	}

	public void setTContato(Contato tContato) {
		TContato.add(tContato);
	}
	
	public String toString() {
		String msg = String.format("Dados Fornecedor\nId : %d\nNome : %s\nEndereço :%s\nLista Contato\n", this.getId(),this.getRazaoSocial(),this.getEndereco());
		
		for (Contato contato : TContato) {
			msg +=String.format("%s - %s -%s\n", contato.getId(),contato.getNome(),contato.getContato());
		}
		
		return msg;
	}
}
