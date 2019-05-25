import java.sql.*;

public class Cliente {
	static Connection conexao;
	private String nome;
	private int cpf;
	private int telefone;
	
	public Cliente(String nome, int cpf, int telefone) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	public void insere(Cliente a) throws Exception
	{
		executa("INSERT INTO Cliente(nome, cpf, telefone) VALUES (" + a.getNome() + "," + a.getCpf() + "," + a.getTelefone() + ")");
	}
	
	public static void executa(String sql)throws Exception{
		Statement st = null;
		st = conexao.createStatement();
		st.executeUpdate(sql);
		}

	public void Status(Cliente a) {
		
		System.out.println("Nome: " + a.getNome() +" Cpf: "+ a.getCpf() + " Telefone: " + a.getTelefone());
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
