package projeto;

public class Local {
	private int id_local;
	private String Nome;
	private String Morada;
	private String Tipo;
	
	protected Local(int id_local, String nome, String morada, String tipo) {
		super();
		this.id_local = id_local;
		Nome = nome;
		Morada = morada;
		Tipo = tipo;
	}

	protected int getId_local() {
		return id_local;
	}

	protected void setId_local(int id_local) {
		this.id_local = id_local;
	}

	protected String getNome() {
		return Nome;
	}

	protected void setNome(String nome) {
		Nome = nome;
	}

	protected String getMorada() {
		return Morada;
	}

	protected void setMorada(String morada) {
		Morada = morada;
	}

	protected String getTipo() {
		return Tipo;
	}

	protected void setTipo(String tipo) {
		Tipo = tipo;
	}
	
}
