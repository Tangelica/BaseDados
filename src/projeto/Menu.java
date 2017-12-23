package projeto;
import java.util.*;
public class Menu {
	Connector cn = new Connector();
	protected int menuPrincipal() {
		int op;
		System.out.println("Menu Principal: \n1-Clientes \n2-Locais de Festas \n3-Festas \n4-Atividades \n5-Aniversariantes "
				+ "\n6-Gestao de Preferencias \n7- Gestão de Animadoras \n0-Sair");
		Scanner sc = new Scanner(System.in);
		op=sc.nextInt();
		return op;
	}
	
	protected int menuClientes() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Clientes: \n1-Adicionar Cliente \n2-Remover Cliente \n3-Alterar dados de um cliente \n4-Listar clientes");
		op=sc.nextInt();
		return op;
	}
	
	protected int menuAlterarCliente() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Alterar Dados Cliente: \n1-Nome \n2-Contacto \n3-Email");
		op=sc.nextInt();
		return op;
	}
	
	protected Cliente adicionarClientes() {
		Cliente c1 = null;
		Scanner sci = new Scanner(System.in);
		Scanner scs = new Scanner(System.in);
		System.out.println("Nome do cliente:");
		String nome=scs.nextLine();
		try {
			System.out.println("NIF do cliente:");
			int nif=sci.nextInt();
			int verifica_NIF=cn.verificaNIF(nif);
			if (verifica_NIF==0) {
				try {
					System.out.println("Contacto do cliente:");
					int contacto=sci.nextInt();
					System.out.println("Email do cliente:");
					String email=scs.nextLine();
					c1 = new Cliente(nif,contacto,nome,email);
				}catch (Exception e) {
					System.out.println("Contacto Invalido!");
				}
				
			}else
				System.out.println("O NIF Fornecido já foi registado!");
			
		}catch (Exception e) {
			System.out.println("NIF Invalido!");
		}
		return c1;
	}
	
	protected int menuFestas() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Festas: \n1-Adicionar Festas \n2-Remover Festa \n3-Alterar dados de uma festa \n4-Listar festas");
		op=sc.nextInt();
		return op;
	}
	
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
		System.out.println("Mês da Festa:");
		int mes_festa=sci.nextInt();
		System.out.println("Ano da Festa:");
		int ano_festa=sci.nextInt();
		while (true){
			System.out.println("Já realizou o pagamento final?:");
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
		Double preco=sci.nextDouble();
		Festa f1 = new Festa(id_festa, id_local, id_atividade, nif, entrada, dia_festa, mes_festa, ano_festa, pag_final, convite, decoracao, comida, tema, preco);
		return f1;
		
	}
	
	
	protected int menuLocais() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Clientes: \n1-Adicionar Local \n2-Remover Local \n3-Alterar dados de um local \n4-Listar locais");
		op=sc.nextInt();
		return op;
	}
	
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
	
	protected int menuAtividades() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Clientes: \n1-Adicionar Atividade \n2-Remover Atividade \n3-Alterar dados de uma atividade \n4-Listar atividades");
		op=sc.nextInt();
		return op;
	}
	
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
