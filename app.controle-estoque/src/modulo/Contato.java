package modulo;

public class Contato {
	private int id;
	private String nome;
	private String TiposContato;

	private String contato;
	
	public Contato(int id, String nome, String contato, String tipoContato) {
		super();
		this.id = id;
		this.nome = nome;
		this.TiposContato = tipoContato;
		this.contato = contato;
	}

	public String getTiposContato() {
		return TiposContato;
	}
	
	public void setTiposContato(String tiposContato) {
		TiposContato = tiposContato;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
}
