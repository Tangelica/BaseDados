package projeto;

public class Festa {
	private int id_festa;
	private int id_local;
	private int id_atividade;
	private int nif;
	private boolean entrada;
	private int dia_festa;
	private int mes_festa;
	private int ano_festa;
	private boolean pag_final;
	private String convite;
	private String decoracao;
	private String comida;
	private String tema;
	private double preco;
	protected Festa(int id_festa, int id_local, int id_atividade, int nif, boolean entrada, int dia_festa, int mes_festa,
			int ano_festa, boolean pag_final, String convite, String decoracao, String comida, String tema, double preco) {
		super();
		this.id_festa = id_festa;
		this.id_local = id_local;
		this.id_atividade = id_atividade;
		this.nif = nif;
		this.entrada = entrada;
		this.dia_festa = dia_festa;
		this.mes_festa = mes_festa;
		this.ano_festa = ano_festa;
		this.pag_final = pag_final;
		this.convite = convite;
		this.decoracao = decoracao;
		this.comida = comida;
		this.tema = tema;
		this.preco = preco;
	}
	protected int getId_festa() {
		return id_festa;
	}
	protected void setId_festa(int id_festa) {
		this.id_festa = id_festa;
	}
	protected int getId_local() {
		return id_local;
	}
	protected void setId_local(int id_local) {
		this.id_local = id_local;
	}
	protected int getId_atividade() {
		return id_atividade;
	}
	protected void setId_atividade(int id_atividade) {
		this.id_atividade = id_atividade;
	}
	protected int getNif() {
		return nif;
	}
	protected void setNif(int nif) {
		this.nif = nif;
	}
	protected boolean isEntrada() {
		return entrada;
	}
	protected void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}
	protected int getDia_festa() {
		return dia_festa;
	}
	protected void setDia_festa(int dia_festa) {
		this.dia_festa = dia_festa;
	}
	protected int getMes_festa() {
		return mes_festa;
	}
	protected void setMes_festa(int mes_festa) {
		this.mes_festa = mes_festa;
	}
	protected int getAno_festa() {
		return ano_festa;
	}
	protected void setAno_festa(int ano_festa) {
		this.ano_festa = ano_festa;
	}
	protected boolean getPag_final() {
		return pag_final;
	}
	protected void setPag_final(boolean pag_final) {
		this.pag_final = pag_final;
	}
	protected String getConvite() {
		return convite;
	}
	protected void setConvite(String convite) {
		this.convite = convite;
	}
	protected String getDecoracao() {
		return decoracao;
	}
	protected void setDecoracao(String decoracao) {
		this.decoracao = decoracao;
	}
	protected String getComida() {
		return comida;
	}
	protected void setComida(String comida) {
		this.comida = comida;
	}
	protected String getTema() {
		return tema;
	}
	protected void setTema(String tema) {
		this.tema = tema;
	}
	protected double getPreco() {
		return preco;
	}
	protected void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
