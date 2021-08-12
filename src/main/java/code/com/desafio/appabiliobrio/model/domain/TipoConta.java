package code.com.desafio.appabiliobrio.model.domain;

public enum TipoConta {

	RECEITA("Receita"), DESPESA("Despesa"), RESULTADO("Resultado");

	private String descricao;

	TipoConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public boolean isReceita() {
		return RECEITA.equals(this);
	}

	public boolean isDespesa() {
		return DESPESA.equals(this);
	}

	public boolean isResultado() {
		return RESULTADO.equals(this);
	}

}
