package projeto;

public class Cliente {
	protected int nif;
	protected int contacto;
	protected String nome;
	protected String email;
		
	protected Cliente(int nif, int contacto, String nome, String email) {
		super();
		this.nif = nif;
		this.contacto = contacto;
		this.nome = nome;
		this.email = email;
	}

	protected int getNif() {
		return nif;
	}

	protected void setNif(int nif) {
		this.nif = nif;
	}

	protected int getContacto() {
		return contacto;
	}

	protected void setContacto(int contacto) {
		this.contacto = contacto;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}
	
	
}
