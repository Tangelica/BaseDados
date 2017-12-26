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
			case 1 : 
				int opcao_clientes=m.menuClientes(); //chama o menu de clientes.
				switch (opcao_clientes) {
				case 1:
					Cliente cl=m.adicionarClientes(); //chama a funcao de adicionar um cliente
					if (cl!= null) { //garante que foi gerado um cliente com todos os dados.
						int nif =cl.getNif(); //usas os gets para ir buscar a informacao do cliente.
						int contacto =cl.getContacto();
						String nome = cl.nome;
						String email =cl.getEmail();
						c.insereCliente(nome, nif, contacto, email); //utiliza a classe de ligacao a BD para inserir o cliente na BD
					}
					break;
				case 2:
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
				case 3:
					int opcao_alterar=m.menuAlterarCliente(); //chama o menu de alteracoes no cliente
					String nome_alterar; //estas duas variaveis estao iniciadas aqui pois sao utilizadas varias vezes, caso contrario teria de ter um nome diferente para casa vez que as utilizava e iniciava.
					int nif_alterar; //tenho de ter o nome e o NIF porque faco a pesquisa com base no Nome, para facilitar ao utilizador, mas como a chave primaria e o NIF as pesquisas na BD sao feitas atraves deste. 
					switch (opcao_alterar) {
					case 1:
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
					case 2:
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
					case 3:
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
				case 4:
					c.leClientes();
					break;
				default:
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
		}
		
			

	}

}
