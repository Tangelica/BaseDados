package projeto;

import java.util.*;

public class Executar {

	public static void main(String[] args) {
		//Vamos criar um menu para podemos aceder as suas funcoes
		Menu m = new Menu();
		//esta variavel vai servir de controlo para termos o menu principal sempre aberto ate alguem dar instrucao para fechar
		boolean menu=true;
		//Criamos a ligacao a classe que faz as ligacoes a base de dados
		Connector c= new Connector();
		//Criamos um scanner para inteiros e um para strings. (Tecnicamente nao precisavas, mas de experiencia costuma dar asneira se nao fizeres)
		Scanner scs = new Scanner(System.in);
		Scanner sci = new Scanner(System.in);
		//este ciclo faz entao com que o menu principal fique aberto enquanto a variavel esteja definida como true
		while (menu==true) {
			int opcao_principal=m.menuPrincipal(); //guarda a tua escolha do menu principal
			switch (opcao_principal) { //este switch funciona como o if e o else if, vai testar a ver qual o valor da tua variavel, neste caso opcao_principal, e conforme o valor dela escolhe o case. Se ela tiver valor 3, executa o case 3, se nao escolher nenhuma opcao valida cai no default.
			case 1 :  //Menu Clientes
				int opcao_clientes=m.menuClientes(); //chama o menu de clientes.
				switch (opcao_clientes) {
				case 1: //Adicionar Cliente
					Cliente cl=m.adicionarClientes(); //chama a funcao de adicionar um cliente
					if (cl!= null) { //garante que foi gerado um cliente com todos os dados.
						int nif =cl.getNif(); //usas os gets para ir buscar a informacao do cliente.
						int contacto =cl.getContacto();
						String nome = cl.getNome();
						String email =cl.getEmail();
						c.insereCliente(nome, nif, contacto, email); //utiliza a classe de ligacao a BD para inserir o cliente na BD
					}
					break;
				case 2: //Apagar Cliente
					System.out.println("Nome do Cliente a apagar: ");
					String nome_eliminar=scs.nextLine();
					int nif_eliminar=c.procuraNIF(nome_eliminar); //Verifica se o Nome do cliente fornecido consta na base de dados.
					if (nif_eliminar==0) //Se a variavel for 0 o cliente nao existe
						System.out.println("Cliente nao existe");
					else if (nif_eliminar==-1) //se for -1 existiu um erro na procura na BD
						System.out.println("Erro!");
					else
						c.eliminaCliente(nif_eliminar); //caso contrario a variavel tem o valor do NIF a eliminar e e chamada a funcao, na classe que liga a BD, que o vai eliminar.
					break;
				case 3: //Alterar dados de cliente
					int opcao_alterar=m.menuAlterarCliente(); //chama o menu de alteracoes no cliente
					String nome_alterar; //estas duas variaveis estao iniciadas aqui pois sao utilizadas varias vezes, caso contrario teria de ter um nome diferente para casa vez que as utilizava e iniciava.
					int nif_alterar; //tenho de ter o nome e o NIF porque faco a pesquisa com base no Nome, para facilitar ao utilizador, mas como a chave primaria e o NIF as pesquisas na BD sao feitas atraves deste. 
					switch (opcao_alterar) {
					case 1: //Alterar Nome
						System.out.println("Nome do Cliente a alterar:");
						nome_alterar=scs.nextLine();
						nif_alterar = c.procuraNIF(nome_alterar); //atraves do nome vai buscar o NIF
						if (nif_alterar!=0) { //se o nome tiver um nif associado pede o novo nome.
							System.out.println("Novo Nome:");
							String novo_nome=scs.nextLine();
							c.alteraNome(nif_alterar, novo_nome);
						}
						else
							System.out.println("O Cliente não existe!");
						break;
					case 2: //Alterar Contacto
						System.out.println("Nome do Cliente a alterar:");
						nome_alterar=scs.nextLine();
						nif_alterar = c.procuraNIF(nome_alterar);
						if (nif_alterar!=0) {
							try {
								System.out.println("Novo Contacto:");
								int novo_contacto=sci.nextInt();
								c.alteraContacto(nif_alterar, novo_contacto);
							}catch(Exception e) {
								System.out.println("Contacto Invalido");
							}
							
						}else
							System.out.println("O Cliente não existe!");
						break;
					case 3: //Alterar Email
						System.out.println("Nome do Cliente a alterar:");
						nome_alterar=scs.nextLine();
						nif_alterar = c.procuraNIF(nome_alterar);
						if (nif_alterar!=0) {
							System.out.println("Novo Email:");
							String novo_email=scs.nextLine();
							c.alteraEmail(nif_alterar, novo_email);
						}else
							System.out.println("O Cliente não existe!");
						break;
					default:
						break;
					}
					break;
				case 4: //Listar
					c.leClientes();
					break;
				case 5:
					System.out.println("Nome do Cliente a Listar:");
					String nome=scs.nextLine();
					c.leClientesNome(nome);
				default:
					break;
				}
				break;
			case 2: //Menu de Locais
				String tipo;
				int id_local;
				int opcao_locais=m.menuLocais(); //chama o menu de locais.
				switch (opcao_locais) {
				case 1: //Adicionar Local
					Local l1 = m.adicionarLocal(); //restricao por causa de adicionar sede!!
					c.insereLocal(l1);
					break;
				case 2: //Remover Local
					System.out.println("Tipo do local a eliminar:");
					tipo=scs.nextLine();
					id_local=c.procuraLocal(tipo);
					c.eliminaLocal(id_local);
					break;
				case 3: //Alterar dados de um local
					int op_alterar;
					System.out.println("Tipo do local a alterar os dados:");
					tipo=scs.nextLine();
					id_local=c.procuraLocal(tipo);
					System.out.println("Que tipo de dados quer alterar?");
					System.out.println("1-Nome \n2-Morada");
					op_alterar=sci.nextInt();
					switch (op_alterar) {
					case 1:
						System.out.println("Novo nome do local:");
						String nome=scs.nextLine();
						c.alteraNomeLocal(id_local, nome);
						break;
					case 2:
						System.out.println("Nova Morada do local:");
						String morada=scs.nextLine();
						c.alteraMoradaLocal(id_local, morada);
						break;
					default:
						break;
					}
					break;
				case 4: // Listar todos
					c.leLocais();
					break;
				case 5: //Listar por tipo 
					System.out.println("Tipo de local a apresentar:");
					tipo=scs.nextLine();
					c.leLocaisTipo(tipo);
					break;
				default:
					System.out.println("Opcao Invalida!");
					break;
				}
				break;			
			case 3:
				int op_festas=m.menuFestas();
				switch(op_festas) {
				case 1: //Adicionar
					Festa f1=m.adicionarFestas();
					c.insereFesta(f1);
					break;
				case 2: //Eliminar
					System.out.println("Nome do cliente em que esta a festa:");
					String nome=scs.nextLine();
					int nif_cliente=c.procuraNIF(nome);
					if (nif_cliente!=0) {
						int id_festa=c.procuraFesta(nif_cliente);
						if (id_festa!=0)
							c.eliminaFesta(id_festa);
					}
					break;
				case 3: //Alterar Dados
					int menu_alterar=m.menuAlterarFesta();
					switch (menu_alterar) {
					case 1: //Adicionar Pagamento Entrada
						break;
					case 2: //Adicionar Pagamento Final
						break;
					case 3: //Alterar Decoracao
						break;
					case 4: //Alterar Convite
						break;
					case 5: //Alterar Tema
						break;
					case 6: //Alterar Comida
						break;
					default:
						break;
					}
					break;
				case 4: //Listar todas
					c.leFestas();
					break;
				default:
					break;
				}
				break;
			case 4: //Menu Atividades
				int op_atividades=m.menuAtividades();
				switch(op_atividades) {
				case 1: //Adicionar 
					Atividade a1=m.adicionarAtividade();
					c.insereAtividade(a1);
					break;
				case 2: //Remover
					break;
				case 3: //Alterar Dados
					break;
				case 4: //Listar Todas
					c.leAtividades();
					break;
				default:
					break;
				}
				break;
			case 5: //Menu Aniversariantes
				int opcao_aniversariantes=m.menuAniversariantes(); //chama o menu de clientes.
				switch (opcao_aniversariantes) {
				case 1: //Adiciona Aniversariante
					Aniversariante an=m.adicionarAniversariantes(); //chama a funcao de adicionar um aniversariante
					if (an!= null) { //garante que foi gerado um aniversariante com todos os dados.
						String nome=an.getNome(); //usas os gets para ir buscar a informacao do aniversariante.
						int idade =an.getIdade();
						String alergia = an.getAlergia();
						int dia= an.getDia_nascimento();
						int mes= an.getMes_nascimento();
						int ano =an.getAno_nascimento();
						//c.insereAniversariante(id_aniversariante, idade, nome,data, alergia); //utiliza a classe de ligacao a BD para inserir o cliente na BD
					}
					break;
				}
				break;
			case 0:
				menu=false;
				break;
			default: 
				System.out.println("Opçao Invalida! \n");
				break;
			}
			break;
		}
		
			

	}

}
