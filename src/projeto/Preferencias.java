package projeto;

public class Preferencias {
	private int id_preferencia;
	private String convite;
	private String jogo;
	private String decoracao;
	private String tema;
	private String comida;
	private boolean insuflavel;
	private boolean magico;
	protected Preferencias(int id_preferencia, String convite, String jogo, String decoracao, String tema,
			String comida, boolean insuflavel, boolean magico) {
		super();
		this.id_preferencia = id_preferencia;
		this.convite = convite;
		this.jogo = jogo;
		this.decoracao = decoracao;
		this.tema = tema;
		this.comida = comida;
		this.insuflavel = insuflavel;
		this.magico = magico;
	}
	protected int getId_preferencia() {
		return id_preferencia;
	}
	protected void setId_preferencia(int id_preferencia) {
		this.id_preferencia = id_preferencia ;
	}
	protected String getConvite() {
		return convite;
	}
	protected void setConvite(String convite) {
		this.convite = convite;
	}
	protected String getJogo() {
		return jogo;
	}
	protected void setJogo(String jogo) {
		this.jogo = jogo;
	}
	protected String getDecoracao() {
		return decoracao;
	}
	protected void setDecoracao(String decoracao) {
		this.decoracao = decoracao;
	}
	protected String getTema() {
		return tema;
	}
	protected void setTema(String tema) {
		this.tema = tema;
	}
	protected String getComida() {
		return comida;
	}
	protected void setComida(String comida) {
		this.comida = comida;
	}
	protected boolean getInsuflavel() {
		return insuflavel;
	}
	protected void setInsuflavel(boolean insuflavel) {
		this.insuflavel = insuflavel;
	}
	
	protected boolean getMagico() {
		return magico;
	}
	protected void setMagico(boolean magico) {
		this.magico = magico;
	}
	
}
	


