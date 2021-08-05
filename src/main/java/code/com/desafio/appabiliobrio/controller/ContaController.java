package code.com.desafio.appabiliobrio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContaController {
	
	@RequestMapping(value = "/")
	public String inicializa() {
		return "index";
	}

	@RequestMapping(value = "/conta/lista")
	public String obterlista(Model model) {
		
		List<String> colecaoConta = new ArrayList<String>();
		colecaoConta.add("Caixa");
		colecaoConta.add("Banco");
		colecaoConta.add("Fornecedor");
		
		model.addAttribute("contas", colecaoConta);
		
		return "conta/lista";
	}
	
}
