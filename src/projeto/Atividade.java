package projeto;

public class Atividade {
	private int id_atividade;
	private String jogo;
	private int insuflavel;
	private int magico;
	
	public Atividade(int id_atividade, String jogo, int insuflavel, int magico) {
		super();
		this.id_atividade = id_atividade;
		this.jogo = jogo;
		this.insuflavel = insuflavel;
		this.magico = magico;
	}

	public int getId_atividade() {
		return id_atividade;
	}

	public void setId_atividade(int id_atividade) {
		this.id_atividade = id_atividade;
	}

	public String getJogo() {
		return jogo;
	}

	public void setJogo(String jogo) {
		this.jogo = jogo;
	}

	public int getInsuflavel() {
		return insuflavel;
	}

	public void setInsuflavel(int insuflavel) {
		this.insuflavel = insuflavel;
	}

	public int getMagico() {
		return magico;
	}

	public void setMagico(int magico) {
		this.magico = magico;
	}
	
}
