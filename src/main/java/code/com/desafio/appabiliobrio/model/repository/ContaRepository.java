package code.com.desafio.appabiliobrio.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import code.com.desafio.appabiliobrio.model.domain.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer>{

	public List<Conta> findAll(Sort sort);
}
