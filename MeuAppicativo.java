package br.com.injecao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeuAppicativo {
	@Autowired
	private BancoDao conexao;

	public MeuAppicativo(BancoDao banco) {
		this.conexao = banco;
	}

	public void Cadastro(Pessoa pessoa) {
		conexao.cadastrar(pessoa);

	}

	public ArrayList obterPessoas() {
		ArrayList lista = conexao.obterPessoas();

		return lista;
	}

}
