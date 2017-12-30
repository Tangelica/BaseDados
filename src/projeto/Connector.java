package projeto;

import java.sql.*;
import java.util.Scanner;

public class Connector {
	//dados de acesso a BD do MySQL
	private static String username = "2014198300";
	private static String password = "miau1234";
	private static String connectionString = "jdbc:mysql://delta.deec.uc.pt:3306/bd_2014198300";
	private static Connection connection;
	private static Statement command;

	//Vai buscar o nome e o NIF de todos os clientes (quando eu puser isto bonito vai sair com todas as info)
	protected void leClientes() {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "SELECT * From CLIENTES";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				String nome = rs.getString("Nome");
				int nif = rs.getInt("NIF");
				int contacto= rs.getInt("Contacto");
				String email=rs.getString("Email");
				System.out.println("Nome: "+nome+"        NIF: "+nif+"        Contacto:"+contacto+"         email:"+email+"\n"); // meter isto bonito
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void leClientesNome(String Nome) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "SELECT * From CLIENTES Where NOME Like '"+Nome+"%'";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				String nome = rs.getString("Nome");
				int nif = rs.getInt("NIF");
				int contacto= rs.getInt("Contacto");
				String email=rs.getString("Email");
				System.out.println("Nome: "+nome+"        NIF: "+nif+"        Contacto:"+contacto+"         email:"+email+"\n"); // meter isto bonito
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//insere os clientes na base de dados
	protected void insereCliente(String nome,int nif,int contacto, String email) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Insert into CLIENTES (NIF,Contacto,Nome,Email) values ('"+nif+"','"+contacto+"','"+nome+"','"+email+"')";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//elimina um cliente da base de dados
	protected void eliminaCliente(int nif) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Delete from CLIENTES Where NIF='"+nif+"'";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//procura o NIF de um cliente através do seu Nome
	protected int procuraNIF(String Nome) {
		try {
			int nif=0;
			int num=1;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from CLIENTES Where NOME Like '"+Nome+"%'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			
			while (rs.next()) {
				nif = rs.getInt("NIF");
				String nome=rs.getString("NOME");
				System.out.println(num+"   "+nome+"     "+ nif);
				num++;
			}
			rs.beforeFirst();
			if (rs.next()==true) {
				System.out.println("Em qual pretende fazer a alteracao?");
				Scanner sci=new Scanner(System.in);
				int op=sci.nextInt();
				
				rs.absolute(op);
				nif=rs.getInt("NIF");
			}else
				System.out.println("O cliente não existe!");
			return nif;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//verifica se determinado nif existe na base de dados
	protected int verificaNIF(int nif) {
		try {
			int ver=0;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from CLIENTES Where NIF='"+nif+"'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			if (rs.next()==true)
				ver=1; //se o NIF existir na base de dados a variavel ver fica com valor 1, caso contrario mantem o valor 0.
			return ver;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//altera o nome de um cliente associado a um determinado NIF
	protected void alteraNome(int nif, String Nome) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Update CLIENTES Set NOME='"+Nome+"' Where NIF='"+nif+"'";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//altera o contacto de um cliente associado a um determinado NIF
	protected void alteraContacto(int nif, int Contacto) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Update CLIENTES Set CONTACTO='"+Contacto+"' Where NIF='"+nif+"'";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//altera o email de um cliente associado a um determinado NIF
	protected void alteraEmail(int nif, String Email) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Update CLIENTES Set EMAIL='"+Email+"' Where NIF='"+nif+"'";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//LOCAIS
	
	protected int verificaIDLocal(int id_local) {
		try {
			int ver=0;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from LOCAIS Where ID_LOCAL='"+id_local+"'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			if (rs.next()==true)
				ver=1; //se o id do local existir na base de dados a variavel ver fica com valor 1, caso contrario mantem o valor 0.
			return ver;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	protected void insereLocal(Local l1) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			int id=l1.getId_local();
			String nome=l1.getNome();
			String morada=l1.getMorada();
			String tipo=l1.getTipo();
			
			String query1 = "Insert into LOCAIS (ID_LOCAL,NOME,MORADA,TIPO) values ('"+id+"','"+nome+"','"+morada+"','"+tipo+"')";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void eliminaLocal(int id) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Delete from LOCAIS Where ID_LOCAL='"+id+"'";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected int procuraLocal(String tipo) {
		try {
			int id=0;
			int num=1;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from LOCAIS Where TIPO = '"+tipo+"'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			
			while (rs.next()) {
				String morada = rs.getString("MORADA");
				String nome=rs.getString("NOME");
				System.out.println(num+"   "+nome+"     "+ morada);
				num++;
			}
			rs.beforeFirst();

			if (rs.next()==true) {
				System.out.println("Qual o local pretendido?");
				Scanner sci=new Scanner(System.in);
				int op=sci.nextInt();
				
				rs.absolute(op);
				id=rs.getInt("ID_LOCAL");			
			}
			
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	protected void alteraNomeLocal(int id, String Nome) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Update LOCAIS Set NOME='"+Nome+"' Where ID_LOCAL='"+id+"'";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void alteraMoradaLocal(int id, String Morada) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Update LOCAIS Set MORADA='"+Morada+"' Where ID_LOCAL='"+id+"'";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void leLocais() {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "SELECT * From LOCAIS";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				String nome = rs.getString("NOME");
				int id = rs.getInt("ID_LOCAL");
				String tipo= rs.getString("TIPO");
				String morada=rs.getString("MORADA");
				System.out.println("ID: "+id+"        NOME: "+nome+"        tipo:"+tipo+"         morada:"+morada+"\n"); // meter isto bonito
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void leLocaisTipo(String Tipo) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "SELECT * From LOCAIS Where TIPO Like '"+Tipo+"'";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				String nome = rs.getString("NOME");
				int id = rs.getInt("ID_LOCAL");
				String tipo= rs.getString("TIPO");
				String morada=rs.getString("MORADA");
				System.out.println("ID: "+id+"        NOME: "+nome+"        tipo:"+tipo+"         morada:"+morada+"\n"); // meter isto bonito
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Festas
	
	protected int verificaIDFesta(int id_festa) {
		try {
			int ver=0;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from FESTAS Where ID_FESTA='"+id_festa+"'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			if (rs.next()==true)
				ver=1; //se o id do local existir na base de dados a variavel ver fica com valor 1, caso contrario mantem o valor 0.
			return ver;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	protected void insereFesta(Festa f1) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			int id=f1.getId_festa();
			int id_local=f1.getId_local();
			int id_atividade=f1.getId_atividade();
			int nif=f1.getNif();
			int pfinal=f1.getPag_final();
			int pentrada=f1.getEntrada();
			String dataEntrada=f1.getDataEntrada();
			String dataFesta=f1.getData_festa();
			String comida=f1.getComida();
			String tema=f1.getTema();
			String convite=f1.getConvite();
			String decoracao=f1.getDecoracao();
			double preco=f1.getPreco();
			double precoCont=f1.getPreco_contratado();
			
			String query1 = "Insert into FESTAS (ID_FESTA,ID_LOCAL,ID_ATIVIDADE,NIF,PAGAMENTO_ENTRADA,DATA_PAGAMENTO_ENTRADA,DATA_FESTA,PAGAMENTO_FINAL,CONVITE,TEMA,DECORACAO,COMIDA,Preco,Preco_Clientes) values ('"+id+"','"+id_local+"','"+id_atividade+"','"+nif+"','"+pentrada+"','"+dataEntrada+"','"+dataFesta+"','"+pfinal+"','"+convite+"','"+tema+"','"+decoracao+"','"+comida+"','"+preco+"','"+precoCont+"')";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	protected int procuraFesta(int nif) {
		try {
			int id=0;
			int num=1;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from FESTAS Where NIF = '"+nif+"'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			
			while (rs.next()) {
				String id_festa = rs.getString("ID_FESTA");
				double precoC= rs.getDouble("Preco_Clientes");
				String data_festa=rs.getString("DATA_FESTA");
				System.out.println(num+"   ID Festa: "+id_festa+"     Data:"+ data_festa+"       Preco ao Cliente:"+precoC);
				num++;
			}
			rs.beforeFirst();
			if (rs.next()==true) {
				System.out.println("Qual a festa pretendida?");
				Scanner sci=new Scanner(System.in);
				int op=sci.nextInt();
				
				rs.absolute(op);
				id=rs.getInt("ID_FESTA");
			}else
				System.out.println("O cliente não tem nenhuma festa");
			
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	protected void eliminaFesta(int id) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Delete from FESTAS Where ID_FESTA='"+id+"'";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void leFestas() {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "SELECT * From FESTAS Natural join CLIENTES";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				String id_festa = rs.getString("ID_FESTA");
				double precoC= rs.getDouble("Preco_Clientes");
				String data_festa=rs.getString("DATA_FESTA");
				String nome=rs.getString("NOME");
				System.out.println("ID Festa: "+id_festa+"      Nome Cliente:"+nome+"     Data:"+ data_festa+"       Preco ao Cliente:"+precoC);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Atividades
	
	protected int verificaIDAtividade(int id_atividade) {
		try {
			int ver=0;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from ATIVIDADES Where ID_ATIVIDADE='"+id_atividade+"'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			if (rs.next()==true)
				ver=1; //se o id do local existir na base de dados a variavel ver fica com valor 1, caso contrario mantem o valor 0.
			return ver;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	protected void insereAtividade(Atividade a1) {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			int id=a1.getId_atividade();
			int magico=a1.getMagico();
			int insuflavel=a1.getInsuflavel();
			String jogo=a1.getJogo();
			
			String query1 = "Insert into ATIVIDADES (ID_ATIVIDADE,JOGO,INSUFLAVEL,MAGICO) values ('"+id+"','"+jogo+"','"+insuflavel+"','"+magico+"')";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void leAtividades() {
		try {
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "SELECT * From ATIVIDADES";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				String id_atividade = rs.getString("ID_ATIVIDADE");
				String jogo=rs.getString("JOGO");
				String magico="Nao";
				String insuf="Nao";
				if(rs.getInt("MAGICO")==1)
					magico="Sim";
				else if (rs.getInt("INSUFLAVEL")==1)
					insuf="Sim";
				
				System.out.println("ID Atividade: "+id_atividade+"      Jogo:"+jogo+"     Magico:"+ magico+"       Insuflavel:"+insuf);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


