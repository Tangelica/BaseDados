package projeto;

public class Aniversariante {
	private int id_aniversariante;
	private int idade;
	private String nome;
	private String alergia;
	private String data;
	protected Aniversariante(int id_aniversariante, int idade,String nome, String alergia, String data) {
		super();
		this.id_aniversariante = id_aniversariante;
		this.idade = idade;
		this.nome =nome;
		this.alergia = alergia;
		this.data = data;
	}
	protected int getId_aniversariante() {
		return id_aniversariante;
	}
	protected void setId_aniversariante(int id_aniversariante ) {
		this.id_aniversariante = id_aniversariante;
	}
	protected int getIdade() {
			return idade;
	}
	protected void setIdade (int idade) {
		this.idade =idade;
	}
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected String getAlergia() {
		return alergia;
	}
	protected void setAlergia(String alergia) {
		this.alergia = alergia;
	}
	protected String getData() {
		return data;
	}
	protected void setData(String data) {
		this.data = data;
	}
	
}


