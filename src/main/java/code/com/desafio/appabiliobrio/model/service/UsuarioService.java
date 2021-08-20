package code.com.desafio.appabiliobrio.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import code.com.desafio.appabiliobrio.model.domain.Usuario;
import code.com.desafio.appabiliobrio.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> obterLista(){
		return (List<Usuario>) usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeUsuario"));
	}

	public List<Usuario> obterLista(String campo){
		return (List<Usuario>) usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, campo));
	}

	public void incluir(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);;
	}
	
	public Usuario obterPorId(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	
	
}
