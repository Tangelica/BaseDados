package projeto;
import java.util.*;
public class Menu {
	//Vai buscar a classe de ligacao a base de dados
	Connector cn = new Connector();
	//Imprime o menu principal e retorna a opcao escolhida
	protected int menuPrincipal() {
		int op=-1;
		System.out.println("Menu Principal: \n1-Clientes \n2-Locais de Festas \n3-Festas \n4-Atividades \n5-Aniversariantes "
				+ "\n6-Gestao de Preferencias \n7- Gestão de Animadoras \n0-Sair");
		Scanner sc = new Scanner(System.in);
		try {
			op=sc.nextInt();
		}catch(Exception e){
			System.out.println("Tem de inserir um número!");
		} //ver como é com os espaços e enters vazios
		
		return op;
	}
	//Imprime o menu de clientes e retorna a opcao escolhida
	protected int menuClientes() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Clientes: \n1-Adicionar Cliente \n2-Remover Cliente \n3-Alterar dados de um cliente \n4-Listar clientes");
		op=sc.nextInt();
		return op;
	}
	//Imprime o menu de alteracao de dados de clientes e retorna a opcao escolhida
	protected int menuAlterarCliente() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Alterar Dados Cliente: \n1-Nome \n2-Contacto \n3-Email");
		op=sc.nextInt();
		return op;
	}
	//Imprime o menu de adicionar clientes e retorna a opcao escolhida
	protected Cliente adicionarClientes() {
		Cliente c1 = null;
		Scanner sci = new Scanner(System.in);
		Scanner scs = new Scanner(System.in);
		System.out.println("Nome do cliente:");
		String nome=scs.nextLine();
		if (nome.length()!=0) {
			//Vai tentar usar o scanner para ir buscar o NIF. Se tentares colocar texto dá erro e manda-te para a seccao de catch, se meteres um numero continua no try
			try {
				System.out.println("NIF do cliente:");
				int nif=sci.nextInt();
				int verifica_NIF=cn.verificaNIF(nif); //verifica se já existe algum NIF na base de dados igual ao do novo cliente
				if (verifica_NIF==0) {
					try {//se não houver, pede o contacto. Se meteres um contacto válido continua a pedir os restantes dados, se não imprime a mensagem de erro e gera um cliente null.
						System.out.println("Contacto do cliente:");
						int contacto=sci.nextInt();
						System.out.println("Email do cliente:");
						String email=scs.nextLine();
						if (email.length()!=0) {
							c1 = new Cliente(nif,contacto,nome,email); //Gera o Cliente com os dados fornecidos.
						}
					}catch (Exception e) {
						System.out.println("Contacto Invalido!");
					}
					
				}else
					System.out.println("O NIF Fornecido já foi registado!");
				
			}catch (Exception e) {
				System.out.println("NIF Invalido!");
			}
		}
		
		return c1; //Devolve o Cliente criado.
	}
	
	//Imprime o menu de festas e retorna a opcao escolhida
	protected int menuFestas() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Festas: \n1-Adicionar Festas \n2-Remover Festa \n3-Alterar dados de uma festa \n4-Listar festas");
		op=sc.nextInt();
		return op;
	}
	
	//Imprime o menu de adicionar festas e retorna a opcao escolhida
	protected Festa adicionarFestas(){
		int id_festa;
		while (true) {
			Random rand=new Random();
			id_festa=rand.nextInt(1000);
			//adicionar funcao de procura no SQL
			break;
		}
		int id_local=2; //adicionar funcao de procura no SQL
		int id_atividade=3; //adicionar funcao de procura no sql
		boolean entrada;
		boolean pag_final;
		Scanner sci = new Scanner(System.in);
		Scanner scs = new Scanner(System.in);
		System.out.println("Local:");
		String local=scs.nextLine();
		System.out.println("Atividade:");
		String atividade=scs.nextLine();
		System.out.println("NIF do cliente:");
		int nif=sci.nextInt();
		while (true) {
			System.out.println("Pagou entrada:");
			String sinal=scs.nextLine();
			if (sinal.equalsIgnoreCase("Sim")) {
				entrada=true;
				break;
			}	
			if (sinal.equalsIgnoreCase("Nao")) {
				entrada=false;
				break;
			}			
		}
		System.out.println("Dia da festa:");
		int dia_festa=sci.nextInt();
		System.out.println("Mes da Festa:");
		int mes_festa=sci.nextInt();
		System.out.println("Ano da Festa:");
		int ano_festa=sci.nextInt();
		while (true){
			System.out.println("Ja realizou o pagamento final?:");
			String pfinal=scs.nextLine();
			if (pfinal.equalsIgnoreCase("Sim")) {
				pag_final=true;
				break;
			}	
			if (pfinal.equalsIgnoreCase("Nao")) {
				pag_final=false;
				break;
			}
		}
		System.out.println("Descricao do Convite:");
		String convite=scs.nextLine();
		System.out.println("Descricao do Decoracao:");
		String decoracao=scs.nextLine();
		System.out.println("Descricao do Comida:");
		String comida=scs.nextLine();
		System.out.println("Descricao do Tema:");
		String tema=scs.nextLine();
		System.out.println("Descricao do Tema:");
		double preco=sci.nextDouble();
		double preco_contratado = sci.nextDouble();
		Festa f1 = new Festa(id_festa, id_local, id_atividade, nif, entrada, dia_festa, mes_festa, ano_festa, pag_final, convite, decoracao, comida, tema, preco,preco_contratado);
		return f1;
		
	}
	
	//Imprime o menu de locais e retorna a opcao escolhida
	protected int menuLocais() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Clientes: \n1-Adicionar Local \n2-Remover Local \n3-Alterar dados de um local \n4-Listar locais");
		op=sc.nextInt();
		return op;
	}
	
	//Imprime o menu de adicionar locais e retorna a opcao escolhida
	protected Local adicionarLocal() {
		Scanner scs = new Scanner(System.in);
		int id_local;
		String morada;
		String tipo;
		String nome;
		while (true) {
			Random rand=new Random();
			id_local=rand.nextInt(1000);
			//adicionar funcao de procura no SQL
			break;
		}
		while (true) {
			System.out.println("Tipo de Festa:");
			tipo=scs.nextLine();
			if (tipo.equalsIgnoreCase("Sede")) {
				morada="sede";
				nome="sede";
				break;
			}
			else if (tipo.equalsIgnoreCase("Casamento")) {
				System.out.println("Nome da Quinta:");
				nome=scs.nextLine();
				System.out.println("Morada da Festa:");
				morada=scs.nextLine();
				break;
			}
			else if (tipo.equalsIgnoreCase("Particular")) {
				System.out.println("Morada da Festa:");
				morada=scs.nextLine();
				nome="Particular";
				break;
			}
			else
				System.out.println("Tipo de Festa:");
				tipo=scs.nextLine();
		}
		Local l1=new Local(id_local,nome,morada, tipo);
		return l1;
	}
	
	//Imprime o menu de atividades e retorna a opcao escolhida
	protected int menuAtividades() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Clientes: \n1-Adicionar Atividade \n2-Remover Atividade \n3-Alterar dados de uma atividade \n4-Listar atividades");
		op=sc.nextInt();
		return op;
	}
	
	//Imprime o menu de adicionar atividades e retorna a opcao escolhida
	protected Atividade adicionarAtividade() {
		int id_atividade;
		while (true) {
			Random rand=new Random();
			id_atividade=rand.nextInt(1000);
			//adicionar funcao de procura no SQL
			break;
		}
		boolean insuflavel=false;
		boolean magico=false;
		Scanner scs = new Scanner(System.in);
		System.out.println("Jogo a ser feito:");
		String jogo=scs.nextLine();
		
		while(true) {
			System.out.println("Vai ser utilizado o insuflavel ou o magico?");
			String op =scs.nextLine();
			if (op.equalsIgnoreCase("Insuflavel")) {
				insuflavel=true;
				break;
			}
			else if (op.equalsIgnoreCase("Magico")) {
				magico=true;
				break;
			}
			else {
				System.out.println("Vai ser utilizado o insuflavel ou o magico?");
				op =scs.nextLine();
			}
		}
		
		Atividade a1 = new Atividade(id_atividade,jogo,insuflavel,magico);
		return a1;
	}
}
