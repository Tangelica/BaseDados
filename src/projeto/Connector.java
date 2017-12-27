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
			
			System.out.println("Em qual pretende fazer a alteracao?");
			Scanner sci=new Scanner(System.in);
			int op=sci.nextInt();
			
			rs.absolute(op);
			nif=rs.getInt("NIF");

			
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
	
}
