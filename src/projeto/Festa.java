package projeto;

public class Festa {
	private int id_festa;
	private int id_local;
	private int id_atividade;
	private int nif;
	private int entrada;
	private String data_entrada;
	private int pag_final;
	private String convite;
	private String decoracao;
	private String comida;
	private String tema;
	private double preco;
	private double preco_contratado;
	private String data_festa;
	protected Festa(int id_festa, int id_local, int id_atividade, int nif, int entrada, String data_entrada, int pag_final, String convite, String decoracao, String comida, String tema, double preco, double preco_contratado,String data_festa) {
		super();
		this.id_festa = id_festa;
		this.id_local = id_local;
		this.id_atividade = id_atividade;
		this.nif = nif;
		this.entrada = entrada;
		this.data_entrada = data_entrada;
		this.pag_final = pag_final;
		this.convite = convite;
		this.decoracao = decoracao;
		this.comida = comida;
		this.tema = tema;
		this.preco = preco;
		this.preco_contratado=preco_contratado;
		this.data_festa=data_festa;
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
	protected int isEntrada() {
		return entrada;
	}
	
	protected int getEntrada() {
		return entrada;
	}
	protected void setEntrada(int entrada) {
		this.entrada = entrada;
	}

	protected String getDataEntrada() {
		return data_entrada;
	}
	protected void setDataEntrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}
	protected double getPreco_contratado() {
		return preco_contratado;
	}
	protected void setPreco_contratado(double preco_contratado) {
		this.preco_contratado = preco_contratado;
	}
	protected int getPag_final() {
		return pag_final;
	}
	protected void setPag_final(int pag_final) {
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
	public String getData_festa() {
		return data_festa;
	}
	public void setData_festa(String data_festa) {
		this.data_festa = data_festa;
	}
	
	
}
