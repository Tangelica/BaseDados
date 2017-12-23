package projeto;

import java.util.*;

public class Executar {

	public static void main(String[] args) {
		Menu m = new Menu();
		boolean menu=true;
		Connector c= new Connector();
		Scanner scs = new Scanner(System.in);
		Scanner sci = new Scanner(System.in);
		while (menu==true) {
			int opcao_principal=m.menuPrincipal();
			switch (opcao_principal) {
			case 1 : 
				int opcao_clientes=m.menuClientes();
				switch (opcao_clientes) {
				case 1:
					Cliente cl=m.adicionarClientes();
					if (cl!= null) {
						int nif =cl.getNif();
						int contacto =cl.getContacto();
						String nome = cl.nome;
						String email =cl.getEmail();
						c.insereCliente(nome, nif, contacto, email);
					}
					break;
				case 2:
					System.out.println("Nome do Cliente a apagar: ");
					String nome_eliminar=scs.nextLine();
					int nif_eliminar=c.procuraNIF(nome_eliminar);
					if (nif_eliminar==0)
						System.out.println("Cliente nao existe");
					else if (nif_eliminar==-1)
						System.out.println("Erro!");
					else
						c.eliminaCliente(nif_eliminar);
					break;
				case 3:
					int opcao_alterar=m.menuAlterarCliente();
					String nome_alterar;
					int nif_alterar;
					switch (opcao_alterar) {
					case 1:
						System.out.println("Nome do Cliente a alterar:");
						nome_alterar=scs.nextLine();
						nif_alterar = c.procuraNIF(nome_alterar);
						if (nif_alterar!=0) {
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
