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

import code.com.desafio.appabiliobrio.model.domain.Conta;
import code.com.desafio.appabiliobrio.model.service.ContaService;

@Controller
public class ContaController {

	@Autowired
	private ContaService contaService;

	private List<Conta> colecaoConta = new ArrayList<Conta>();

	@GetMapping(value = "/")
	public String inicializa() {
		return "index";
	}

	@GetMapping(value = "/conta")
	public String telaCadastro() {
		return "conta/cadastro";
	}

	@PostMapping(value = "/conta/incluir")
	public String incluir(Model model, Conta conta) {

		contaService.incluir(conta);

		model.addAttribute("mensagem", "Conta " + conta.getDescricao() + " incluída!!!");

		return obterlista(model);
	}

	@GetMapping(value = "/conta/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		Conta contaExcluido = contaService.obterPorId(id);
		contaService.excluir(id);
		model.addAttribute("mensagem", "Conta " + contaExcluido.getDescricao() + " excluída!!!");

		return obterlista(model);
	}

	@GetMapping(value = "/conta/{id}/consultar")
	public String consultar(Model model, @PathVariable Integer id) {

		Conta conta = contaService.obterPorId(id);
		model.addAttribute("conta", conta);

		return telaCadastro();
	}

	@GetMapping(value = "/conta/lista")
	public String obterlista(Model model) {

		model.addAttribute("contas", contaService.obterLista());

		return "conta/lista";
	}

	@GetMapping(value = "/voltar")
	public String voltar(Model model) {

		model.addAttribute("contas", contaService.obterLista());

		return "redirect:conta/lista";
	}
	
	@PostMapping(value = "/conta/ordenar")
	public String ordenar(Model model, @RequestParam String sortBy) {
		
		model.addAttribute("contas", contaService.obterLista(sortBy));
		
		return "conta/lista";
	}
	
}
