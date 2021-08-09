package code.com.desafio.appabiliobrio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import code.com.desafio.appabiliobrio.model.domain.Conta;

@Controller
public class ContaController {

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

		colecaoConta.add(conta);
		model.addAttribute("mensagem", "Conta " + conta.getDescricao() + " incluída!!!");

		return obterlista(model);
	}

	@GetMapping(value = "/conta/excluir")
	public String excluir(Model model) {
		model.addAttribute("mensagem", "Conta excluída!!!");
		return obterlista(model);
	}

	@GetMapping(value = "/conta/consultar")
	public String consultar() {
		return "";
	}

	@GetMapping(value = "/conta/lista")
	public String obterlista(Model model) {

		model.addAttribute("contas", colecaoConta);

		return "conta/lista";
	}

}
