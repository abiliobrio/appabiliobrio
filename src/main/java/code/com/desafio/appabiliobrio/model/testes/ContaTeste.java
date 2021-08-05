package code.com.desafio.appabiliobrio.model.testes;

import code.com.desafio.appabiliobrio.model.domain.Conta;

public class ContaTeste {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setDescricao("Caixa");
		conta.setPeriodo(821);
		conta.setSaldo(1000);
		conta.setStatus(true);
		System.out.println("Conta: " + conta);
		
	}

}
