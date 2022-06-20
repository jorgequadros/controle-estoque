package modulo;

import javax.swing.JOptionPane;

public class Fornecedor {

	private int id;
	private String razaoSocial;
	private String endereco;
	private String cidade;
	private String bairro;
	private String uf;
	private String cep;
		
	public Fornecedor() {}
	
	public Fornecedor(int id, String razaoSocial, String endereco, String cidade, String bairro, String uf, String cep) {
		setId(id);
		setRazaoSocial(razaoSocial);
		setEndereco(endereco);
		setCidade(cidade);
		setBairro(bairro);
		setUf(uf);
		setCep(cep);
	}

	public String getUf() {
		return uf;
	}

	@SuppressWarnings("unused")
	public void setUf(String uf) {
		if(!uf.isEmpty() && uf!=null) {
			this.uf = uf;
		}else {
			JOptionPane.showMessageDialog(null, "Campo UF não informado!!!");
		}
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
		if(!cidade.isEmpty() && cidade!=null) {
			this.cidade = cidade ;
		}else{
			JOptionPane.showMessageDialog(null, "Campo Cidade não preenchido!!!");
		};
	}

	public void setBairro(String bairro) {
		if(!bairro.isEmpty() && bairro!=null) {
			this.bairro = bairro;
		}else{
			JOptionPane.showMessageDialog(null, "Campo bairro não preenchido!!!");
		};
	}

	public void setCep(String cep) {
		if(!cep.isEmpty() && cep!=null) {
			this.cep = cep;
		}else{
			JOptionPane.showMessageDialog(null, "Campo cep não preenchido!!!");
		};
		
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
		if(!razaoSocial.isEmpty() && razaoSocial!=null) {
			this.razaoSocial = razaoSocial;
		}else {
			JOptionPane.showMessageDialog(null, "Campo Razão Social esta vazio!!");
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if(!endereco.isEmpty()&&endereco!=null) {
			this.endereco = endereco;
		}else {
			JOptionPane.showMessageDialog(null,"Campo endereço está vazio!!");
		}
	}

}
