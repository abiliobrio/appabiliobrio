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

import code.com.desafio.appabiliobrio.model.domain.Depto;
import code.com.desafio.appabiliobrio.model.domain.Status;
import code.com.desafio.appabiliobrio.model.service.DeptoService;

@Controller
public class DeptoController {

	@Autowired
	private DeptoService deptoService;

	private List<Depto> colecaoDepto = new ArrayList<Depto>();

	@GetMapping(value = "/depto")
	public String telaCadastro() {
		return "depto/cadastro";
	}

	@PostMapping(value = "/depto/incluir")
	public String incluir(Model model, Depto depto) {

		deptoService.incluir(depto);

		model.addAttribute("mensagem", "Depto " + depto.getDescricao() + " incluída!!!");

		return obterlista(model);
	}

	@GetMapping(value = "/depto/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		Depto deptoExcluido = deptoService.obterPorId(id);
		deptoService.excluir(id);
		model.addAttribute("mensagem", "Depto " + deptoExcluido.getDescricao() + " excluída!!!");

		return obterlista(model);
	}

	@GetMapping(value = "/depto/{id}/consultar")
	public String consultar(Model model, @PathVariable Integer id) {

		Depto depto = deptoService.obterPorId(id);
		model.addAttribute("depto", depto);

		return telaCadastro();
	}

	@GetMapping(value = "/depto/lista")
	public String obterlista(Model model) {

		model.addAttribute("deptos", deptoService.obterLista());

		return "depto/lista";
	}

	@GetMapping(value = "/voltarDepto")
	public String voltar(Model model) {

		model.addAttribute("deptos", deptoService.obterLista());

		return "redirect:depto/lista";
	}
	
	@PostMapping(value = "/depto/ordenar")
	public String ordenar(Model model, @RequestParam String sortBy) {
		
		model.addAttribute("deptos", deptoService.obterLista(sortBy));
		
		return "depto/lista";
	}
	
	
}
