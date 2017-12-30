package projeto;

public class Aniversariante {
	private int id_aniversariante;
	private int idade;
	private String nome;
	private String alergia;
	private int dia_nascimento;
	private int mes_nascimento;
	private int ano_nascimento;
	protected Aniversariante(int id_aniversariante, int idade,String nome, String alergia,
			int dia_nascimento,int mes_nascimento, int ano_nascimento) {
		super();
		this.id_aniversariante = id_aniversariante;
		this.idade = idade;
		this.nome =nome;
		this.alergia = alergia;
		this.dia_nascimento = dia_nascimento;
		this.mes_nascimento = mes_nascimento;
		this.ano_nascimento = ano_nascimento;
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
	protected int getDia_nascimento() {
		return dia_nascimento;
	}
	protected void setDia_nascimento(int dia_nascimento) {
		this.dia_nascimento = dia_nascimento;
	}
	protected int getMes_nascimento() {
		return mes_nascimento;
	}
	protected void setMes_nascimento(int mes_nascimento) {
		this.mes_nascimento = mes_nascimento;
	}
	protected int getAno_nascimento() {
		return ano_nascimento;
	}
	protected void setAno_nascimento(int ano_nascimento) {
		this.ano_nascimento = ano_nascimento;
	}
}


