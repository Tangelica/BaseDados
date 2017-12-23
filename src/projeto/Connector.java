package projeto;

import java.sql.*;

public class Connector {
	private static String username = "2014198300";
	private static String password = "miau1234";
	
	private static String connectionString = "jdbc:mysql://delta.deec.uc.pt:3306/bd_2014198300";
	private static Connection connection;
	private static Statement command;

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
				System.out.println("Nome: "+nome+"        NIF: "+nif); // meter isto bonito
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
	
	protected int procuraNIF(String Nome) {
		try {
			int nif=0;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from CLIENTES Where NOME='"+Nome+"'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			if (rs.next()==true)
				nif=rs.getInt("NIF");
			return nif;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	protected int verificaNIF(int nif) {
		try {
			int ver=0;
			connection= DriverManager.getConnection(connectionString,username,password);
			command= connection.createStatement();
			
			String query1 = "Select * from CLIENTES Where NIF='"+nif+"'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			if (rs.next()==true)
				ver=1;
			return ver;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
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
