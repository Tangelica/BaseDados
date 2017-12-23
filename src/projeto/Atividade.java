package projeto;

public class Atividade {
	private int id_atividade;
	private String jogo;
	private boolean insuflavel;
	private boolean magico;
	
	public Atividade(int id_atividade, String jogo, boolean insuflavel, boolean magico) {
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

	public boolean isInsuflavel() {
		return insuflavel;
	}

	public void setInsuflavel(boolean insuflavel) {
		this.insuflavel = insuflavel;
	}

	public boolean isMagico() {
		return magico;
	}

	public void setMagico(boolean magico) {
		this.magico = magico;
	}
	
}
