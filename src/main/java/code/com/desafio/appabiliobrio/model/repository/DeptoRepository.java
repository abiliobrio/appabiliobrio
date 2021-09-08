package code.com.desafio.appabiliobrio.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import code.com.desafio.appabiliobrio.model.domain.Depto;

@Repository
public interface DeptoRepository extends CrudRepository<Depto, Integer> {

	public List<Depto> findAll(Sort sort);

	
}
