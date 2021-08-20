package code.com.desafio.appabiliobrio.model.domain;

public enum TipoUsuario {

	ADM("Admin"), SUPER("Supervisor"), COMUM("ComuM");

	private String descricao;

	TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public boolean isAdm() {
		return ADM.equals(this);
	}

	public boolean isSuper() {
		return SUPER.equals(this);
	}

	public boolean isComum() {
		return COMUM.equals(this);
	}

}
