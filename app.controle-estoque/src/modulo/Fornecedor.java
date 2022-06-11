package modulo;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

	private int id;
	private String razaoSocial;
	private String endereco;
	private String cidade;
	private String bairro;
	private String uf;
	private String cep;
	List<Contato> TContato = new ArrayList<>();
		
	public Fornecedor() {}
	
	public Fornecedor(int id, String razaoSocial, String endereco, String cidade, String bairro, String uf, String cep) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.uf = uf;
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
