package code.com.desafio.appabiliobrio.model.testes;

import code.com.desafio.appabiliobrio.model.domain.Conta;
import code.com.desafio.appabiliobrio.model.domain.Status;
import code.com.desafio.appabiliobrio.model.domain.TipoConta;

public class ContaTeste {

	public static void main(String[] args) {
		Conta conta = new Conta("Caixa",TipoConta.RESULTADO,Status.ATIVO);
		conta.setSaldo(1000);
		System.out.println("Conta: " + conta);
		
	}

}
