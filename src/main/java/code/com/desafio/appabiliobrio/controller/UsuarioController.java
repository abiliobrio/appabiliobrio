package code.com.desafio.appabiliobrio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import code.com.desafio.appabiliobrio.model.domain.Usuario;
import code.com.desafio.appabiliobrio.model.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	private List<Usuario> colecaoUsuario = new ArrayList<Usuario>();

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Model model, Usuario usuario) {

		usuarioService.incluir(usuario);

		model.addAttribute("mensagem", "Usuario " + usuario.getLoginUsuario() + " incluída!!!");

		return obterlista(model);
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		Usuario usuarioExcluido = usuarioService.obterPorId(id);
		usuarioService.excluir(id);
		model.addAttribute("mensagem", "Usuario " + usuarioExcluido.getLoginUsuario() + " excluída!!!");

		return obterlista(model);
	}

	@GetMapping(value = "/usuario/{id}/consultar")
	public String consultar(Model model, @PathVariable Integer id) {

		Usuario usuario = usuarioService.obterPorId(id);
		model.addAttribute("usuario", usuario);

		return telaCadastro();
	}

	@GetMapping(value = "/usuario/lista")
	public String obterlista(Model model) {

		model.addAttribute("usuarios", usuarioService.obterLista());

		return "usuario/lista";
	}

	@GetMapping(value = "/voltarUser")
	public String voltar(Model model) {

		model.addAttribute("usuarios", usuarioService.obterLista());

		return "redirect:usuario/lista";
	}
	
	@PostMapping(value = "/usuario/ordenar")
	public String ordenar(Model model, @RequestParam String sortBy) {
		
		model.addAttribute("usuarios", usuarioService.obterLista(sortBy));
		
		return "usuario/lista";
	}
	
}
