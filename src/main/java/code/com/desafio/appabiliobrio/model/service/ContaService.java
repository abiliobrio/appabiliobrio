package code.com.desafio.appabiliobrio.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.com.desafio.appabiliobrio.model.domain.Conta;
import code.com.desafio.appabiliobrio.model.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public List<Conta> obterLista() {

		return (List<Conta>) contaRepository.findAll();
	}

	public void incluir(Conta conta) {
		contaRepository.save(conta);
	}

	public void excluir(Integer id) {
		contaRepository.deleteById(id);;
	}
	
	public Conta obterPorId(Integer id) {
		return contaRepository.findById(id).orElse(null);
	}
	
}
