package br.com.injecao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BancoDaoIdConfig {

	@Bean(name = "MySqlDao")
	public BancoDao obterMySql() {
		return new BancoMySqlDao();

	}
	@Bean(name = "Postgres")
	public BancoDao obterPostgress() {
		return new BancoPostgressDao();

	}

}
