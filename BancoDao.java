package br.com.injecao;

import java.util.ArrayList;

public interface BancoDao {
	public void cadastrar(Pessoa pessoa);

	public ArrayList<Pessoa> obterPessoas();
}
