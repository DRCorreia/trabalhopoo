import java.sql.*;
public class Cadastro {
	static Connection conexao;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		Cliente a = new Cliente("Daniel", 11147744, 999998888);
		Cliente b = new Cliente("Rafael", 11255566, 999999999);
		Cliente c = new Cliente ("Andr�", 11377755, 777775555);
	
		a.Status(a);
		b.Status(b);
		c.Status(c);
		
		conecta();
		System.out.println("Antes de executar");
		/*Inserts na tabela - Se for usar delete os m�todos executa  e insere da classe cliente*//*
		executa("INSERT INTO Cliente(nome, cpf, telefone) VALUES (" + a.getNome() + "," + a.getCpf() + "," + a.getTelefone() + ")");
		executa("INSERT INTO Cliente(nome, cpf, telefone) VALUES (" + b.getNome() + "," + b.getCpf() + "," + b.getTelefone() + ")");
		executa("INSERT INTO Cliente(nome, cpf, telefone) VALUES (" + c.getNome() + "," + c.getCpf() + "," + c.getTelefone() + ")");
		*/
		/*Insere na tabela atrav�s de m�todos*/
		a.insere(a);
		b.insere(b);
		c.insere(c);
		
		System.out.println("Antes de listar Cliente");
		listar_cliente();
		executa("UPDATE Cliente SET nome = 'Joao' WHERE cpf =11147744" );
		executa("DELETE FROM Cliente WHERE cpf = 13777555");
		listar_cliente();
		desconecta();
	}


public static void conecta() {
	String driver = "com.mysql.jdbc.Drivers";//Endere�o da classe do driver que corresponde ao banco de dados(Baixar - baixar conector jdbc mysql) - Aula 10 - 10:15 - https://www.youtube.com/watch?v=HOsdNP7Jutw 
	String url = "jdbc:mysql://localhost:0000/TrabPOO-Av2" ;//Padr�o - Verificar Porta de localhost - Nome do banco
	String login = "root";//Verificar login
	String senha = "";//Verificar senha
	try {
		Class.forName(driver);
		conexao = DriverManager.getConnection(url, login, senha);
		System.out.println("Conex�o Bem Sucedida");
		
	} catch (Exception e) {
		e.printStackTrace();//Nesta linha � impresso o erro!
	}
}


public static void executa(String sql)throws Exception{//OBS : Metodo executa est� sendo repetido nas duas classes !!! 
	Statement st = null;
	st = conexao.createStatement();
	st.executeUpdate(sql);
	}

public static void listar_cliente() throws Exception{
	Statement st;
	st = conexao.createStatement();
	ResultSet rs = st.executeQuery("SELECT cpf, nome, telefone FROM Cliente");
	System.out.println("----------------------------------------");
	while (rs.next()) {
		System.out.println("CPF:" +rs.getString(1) + "Nome: "+ rs.getString(2)+ "Telefone: " + rs.getString(3) );
		}
	}
public static void desconecta() throws Exception{
	conexao.close();
	}
}