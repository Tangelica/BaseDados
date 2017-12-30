package projeto;

public class Animadora {
	private int nif;
	private String nome;
	private int contacto;
	protected Animadora(int nif, String nome, int contacto) {
		super();
		this.nif = nif;
		this.nome = nome;
		this.contacto = contacto;
	}
	protected int getNIF() {
		return nif;
	}
	protected void setNif(int nif) {
		this.nif = nif;
	}
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected int getContacto() {
		return contacto;
	}
	protected void setContacto(int contacto) {
		this.contacto = contacto;
	}
	

}
