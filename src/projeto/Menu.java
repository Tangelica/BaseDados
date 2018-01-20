package projeto;
import java.util.*;
public class Menu {
	//Vai buscar a classe de ligacao a base de dados
	Connector cn = new Connector();
	Data d=new Data();
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
		} //ver como é com os espaços
		
		return op;
	}
	//Imprime o menu de clientes e retorna a opcao escolhida
	protected int menuClientes() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Clientes: \n1-Adicionar Cliente \n2-Remover Cliente \n3-Alterar dados de um cliente \n4-Listar clientes \n5-Listar Clientes por Nome");
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
	
	//Imprime o menu de adicionar FESTAS e retorna a opcao escolhida
	protected Festa adicionarFestas(){
		Scanner sci = new Scanner(System.in);
		Scanner scs = new Scanner(System.in);
		int id_festa;
		while (true) {
			Random rand=new Random();
			id_festa=rand.nextInt(1000);
			if (cn.verificaIDFesta(id_festa)!=1)
				break;
		}
		int id_local;
		System.out.println("Qual o tipo de local onde se vai realizar a festa?");
		System.out.println("Sede \nCasamento \nParticular \nNovo(caso ainda nao esteja inserido na base de dados)");
		String tipo=scs.nextLine();
		if (tipo.equalsIgnoreCase("Novo")){
			Local l1=adicionarLocal();
			cn.insereLocal(l1);
			id_local=l1.getId_local();
		}
		else {
			id_local=cn.procuraLocal(tipo);
		}
		
		int id_atividade=3; //adicionar funcao de procura no sql
		int entrada;
		int pag_final;
		System.out.println("O cliente ja esta na base de dados?");
		String rp=scs.nextLine();
		int nif;
		if (rp.equalsIgnoreCase("Sim")) {
			System.out.println("Nome do cliente:");
			String nome=scs.nextLine();
			nif=cn.procuraNIF(nome);
		}else {
			Cliente c1 = adicionarClientes();
			String nome=c1.getNome();
			nif=c1.getNif();
			int contacto=c1.getContacto();
			String email=c1.getEmail();
			cn.insereCliente(nome, nif, contacto, email);
		}
			
		
		String data_entrada="0000-00-00";
		while (true) {
			System.out.println("Pagou entrada:");
			String sinal=scs.nextLine();
			if (sinal.equalsIgnoreCase("Sim")) {
				entrada=1;
				System.out.println("Dia do pagamento:");
				int diaP=sci.nextInt();
				System.out.println("Mes do pagamento:");
				int mesP=sci.nextInt();
				System.out.println("Ano do pagamento:");
				int anoP=sci.nextInt();
				data_entrada=d.StringData(diaP, mesP, anoP);
				break;
			}else if (sinal.equalsIgnoreCase("Nao")) {
				entrada=0;
				break;
			}else
				System.out.println("Resposta Invalida! Insira Sim/Nao ");
		}
		System.out.println("Dia da festa:");
		int dia_festa=sci.nextInt();
		System.out.println("Mes da Festa:");
		int mes_festa=sci.nextInt();
		System.out.println("Ano da Festa:");
		int ano_festa=sci.nextInt();
		String data_festa=d.StringData(dia_festa, mes_festa, ano_festa);
		
		while (true){
			System.out.println("Ja realizou o pagamento final?:");
			String pfinal=scs.nextLine();
			if (pfinal.equalsIgnoreCase("Sim")) {
				pag_final=1;
				break;
			}else if (pfinal.equalsIgnoreCase("Nao")) {
				pag_final=0;
				break;
			}else
				System.out.println("Resposta Invalida! Insira Sim/Nao ");
		}
		System.out.println("Descricao do Convite:");
		String convite=scs.nextLine();
		System.out.println("Descricao do Decoracao:");
		String decoracao=scs.nextLine();
		System.out.println("Descricao do Comida:");
		String comida=scs.nextLine();
		System.out.println("Descricao do Tema:");
		String tema=scs.nextLine();
		System.out.println("Valor da Festa:");
		double preco=sci.nextDouble();
		System.out.println("Preco Contratado com o Cliente:");
		double preco_contratado = sci.nextDouble();
		Festa f1=new Festa(id_festa, id_local, id_atividade, nif, entrada, data_entrada, pag_final, convite, decoracao, comida, tema, preco, preco_contratado, data_festa);
		return f1;
		
	}
	
	protected int menuAlterarFesta() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Alterar Dados Festa: \n1-Adicionar Pagamento Entrada \n2-Adicionar Pagamento Final \n3-Alterar Decoracao \n4-Alterar Convite \n5-Alterar Tema \n6-Alterar Comida");
		op=sc.nextInt();
		return op;
	}
	
	//Imprime o menu de locais e retorna a opcao escolhida
	protected int menuLocais() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Locais: \n1-Adicionar Local \n2-Remover Local \n3-Alterar dados de um local \n4-Listar todos locais \n5-Listar locais por tipo");
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
		while (true) {  //gera o id de local aleatorio e verifica se ele existe na BD
			Random rand=new Random();
			id_local=rand.nextInt(1000);
			int ver = cn.verificaIDLocal(id_local);
			if (ver!=1)
				break;
		}
		while (true) {
			System.out.println("Tipo de Festa:");
			System.out.println("Sede \nCasamento \nParticular");
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
		}
		Local l1=new Local(id_local,nome,morada, tipo);
		return l1;
	}
	
	//Imprime o menu de atividades e retorna a opcao escolhida
	protected int menuAtividades() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Atividades: \n1-Adicionar Atividade \n2-Remover Atividade \n3-Alterar dados de uma atividade \n4-Listar atividades");
		op=sc.nextInt();
		return op;
	}
	
	//Imprime o menu de adicionar atividades e retorna a opcao escolhida
	protected Atividade adicionarAtividade() {
		int id_atividade;
		while (true) {
			Random rand=new Random();
			id_atividade=rand.nextInt(1000);
			if (cn.verificaIDAtividade(id_atividade)!=1);
				break;
		}
		int insuflavel=0;
		int magico=0;
		Scanner scs = new Scanner(System.in);
		System.out.println("Jogo a ser feito:");
		String jogo=scs.nextLine();
		
		while(true) {
			System.out.println("Vai ser utilizado o insuflavel ou o magico?");
			String op =scs.nextLine();
			if (op.equalsIgnoreCase("Insuflavel")) {
				insuflavel=1;
				break;
			}
			else if (op.equalsIgnoreCase("Magico")) {
				magico=1;
				break;
			}else
				System.out.println("Opcao Invalida");
		}
		
		Atividade a1 = new Atividade(id_atividade,jogo,insuflavel,magico);
		return a1;
	}
	//Imprime o menu de Aniversariantes 
	protected int menuAniversariantes() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Aniversariantes: \n1-Adicionar Aniversariante \n2-Remover Aniversariante \n3-Alterar dados de um Aniversariante  \n4-Listar todos os aniversariantes \n5-Listar Aniversariante por nome ");
		op=sc.nextInt();
		return op;
	}
	
	//Imprime adicionar Aniversariantes
	protected Aniversariante adicionarAniversariantes() {
		Aniversariante an1 = null;
		Scanner sci = new Scanner(System.in);
		Scanner scs = new Scanner(System.in);
		int id_aniversariante;
		while (true) {
			Random rand=new Random();
			id_aniversariante=rand.nextInt(1000);
			//adicionar funcao de procura no SQL
			break;
		}
		System.out.println("Nome do Aniversariante");
		String nome=scs.nextLine();
		System.out.println("Idade do Aniversariante");
		int idade = sci.nextInt();
		System.out.println("Insira possiveis alergias");
		String alergia =scs.nextLine();
		System.out.println("Insira dia de nascimento");
		int dia= sci.nextInt();
		System.out.println("Insira mes de nascimento");
		int mes= sci.nextInt();
		System.out.println("Insira ano de nascimento");
		int ano =sci.nextInt();
		String data_nascimento=d.StringData(dia, mes, ano);
		//acrecentar data
		 an1 = new Aniversariante(id_aniversariante, idade, nome, alergia ,data_nascimento); //criar classe aniversariante
		
		return an1; //Devolve o Aniversariante criado.
		}
	//Alterar parametros ANIVERSARIANTE
	protected int menuAlterarAniversariantes() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Alterar Dados Aniversariante: \n1-Nome");
		op=sc.nextInt();
		return op;
	}
	
	//Listar todos
	//Listar por nome
	//Imprime o menu Gestão de Preferencias
	protected int menuPreferencias() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Gestão de Preferencias: \n1-Adicionar Preferencias \n2-Remover Preferencias \n3-Alterar Preferencias \n4-Listar Preferencias por   ");
		op=sc.nextInt();
		return op;
	}
	//Imprime o menu Gestão de Animadoras
	protected int menuAnimadoras() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Gestão de Animadoras: \n1-Adicionar Animadoras \n2-Remover Animadoras \n3-Alterar dadados de Animadoras \n4-Listar Animadoras por   ");
		op=sc.nextInt();
		return op;
	}
	}