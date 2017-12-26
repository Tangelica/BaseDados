package projeto;

public class Cliente {
	//variaveis utilizadas para definir um cliente.
	private int nif;
	private int contacto;
	private String nome;
	private String email;
	
	//construtor da classe - serve para criar um objecto desta classe, neste caso cria clientes.
	protected Cliente(int nif, int contacto, String nome, String email) {
		super();
		this.nif = nif;
		this.contacto = contacto;
		this.nome = nome;
		this.email = email;
	}

	
	//As funcoes do tipo get vao servir para a partir de um cliente tu conseguires aceder aos valores das variaveis caracteristicas. (nif, contacto, ...)
	//As funcoes do tipo set sao para fazer alteracoes ao objecto cliente (eu pus pelo hábito, porque acho que não vamos utilizar no projecto)
	
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
