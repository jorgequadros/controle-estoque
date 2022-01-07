package control;

public class Produtos {

	private int id;
	private String descricao;
	private Fornecedor id_fornecedor;
	private CategoriaDAO id_CategoriaDAO;
	private int qtde;
	private double precoCusto;
	private double precoVenda;
		
	public double getPrecoCusto() {
		return precoCusto;
	}


	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}


	public double getPrecoVenda() {
		return precoVenda;
	}


	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}


	public Produtos(int id, String descricao, int qtde, double precoCusto, double precoVenda) {
		this.id = id;
		this.descricao = descricao;
		this.qtde = qtde;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
	}
	

	public CategoriaDAO getId_CategoriaDAO() {
		return id_CategoriaDAO;
	}



	public void setId_CategoriaDAO(CategoriaDAO id_CategoriaDAO) {
		this.id_CategoriaDAO = id_CategoriaDAO;
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

		public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getprecoCusto() {
		return precoCusto;
	}

	public void setprecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Fornecedor getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(Fornecedor id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	
	public String toString() {
		String msg = String.format("ID : %d\nDescricao : %s\nQtde : %d\nPreco :%.2f\n%s",
				this.getId(),
				this.getDescricao(),
				this.getQtde(),
				this.getprecoCusto(),
				this.id_fornecedor.toString());
		
		return msg;
	}
}
