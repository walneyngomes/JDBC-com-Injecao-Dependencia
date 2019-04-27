package br.com.injecao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PrograsmApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(BancoDaoIdConfig.class);
		MeuAppicativo app = new MeuAppicativo((BancoDao) context.getBean("MySqlDao"));
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("3131123123");
		pessoa.setIdPessoa(1);
		pessoa.setName("Walney");

		app.Cadastro(pessoa);

		System.out.print(app.obterPessoas().size());

		context.close();

	}

}
