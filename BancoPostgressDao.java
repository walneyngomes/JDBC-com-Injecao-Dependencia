package br.com.injecao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BancoPostgressDao implements BancoDao {
	Connection conn;

	public BancoPostgressDao() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // WALNEY

		String url = "jdbc:postgresql://localhost:5432/BancoPessoa"; // Nome
																			// da
		// base de
		// dados
		String user = "postgres"; // nome do usuário do MySQL
		String password = "123"; // senha do MySQL

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cadastrar(Pessoa pessoa) {
		PreparedStatement st = null;
		try {// WALNEY
			st = conn.prepareStatement("INSERT INTO Pessoa"// WALNEY
					+ "(id_pessoa,nome,cpf )" + "VALUES " + "(?,?,?)");
			st.setLong(1, pessoa.getIdPessoa());
			st.setString(2, pessoa.getName());// WALNEY
			st.setString(3, pessoa.getCpf());// WALNEY

			st.executeQuery();

		} catch (SQLException e) {

		}

	}

	public ArrayList<Pessoa> obterPessoas() {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		Statement stmt;

		try {// WALNEY
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Pessoa ");
			while (rs.next()) { // WALNEY NEGREIROS

				Pessoa pessoa = new Pessoa();
				pessoa.setIdPessoa(rs.getInt("id_pessoa"));
				pessoa.setCpf(rs.getString("cpf"));

				pessoas.add(pessoa);

				// WALNEY
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // WALNEY NEGREIROS
		return null;
	}
}
