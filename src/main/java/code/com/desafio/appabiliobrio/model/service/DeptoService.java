package code.com.desafio.appabiliobrio.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import code.com.desafio.appabiliobrio.model.domain.Depto;
import code.com.desafio.appabiliobrio.model.domain.Status;
import code.com.desafio.appabiliobrio.model.repository.DeptoRepository;

@Service
public class DeptoService {

	@Autowired
	private DeptoRepository deptoRepository;
	
	public List<Depto> obterLista(){
		return (List<Depto>) deptoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<Depto> obterLista(String campo){
		return (List<Depto>) deptoRepository.findAll(Sort.by(Sort.Direction.ASC, campo));
	}

	public void incluir(Depto depto) {
		depto.setStatus(Status.ATIVO);
		deptoRepository.save(depto);
	}

	public void excluir(Integer id) {
		deptoRepository.deleteById(id);;
	}
	
	public Depto obterPorId(Integer id) {
		return deptoRepository.findById(id).orElse(null);
	}
	
	
}
