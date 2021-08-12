package code.com.desafio.appabiliobrio.model.domain;

public enum Status {
	
	  ATIVO("Ativo"), INATIVO("Inativo"), CANCELADO("Cancelado");
	  
		private String descricao;

		Status(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return this.descricao;
		}
		
		public boolean isAtivo() {
			return ATIVO.equals(this);
		}
		
		public boolean isInativo() {
			return INATIVO.equals(this);
		}
		
	  public boolean isCancelado() {
	    return CANCELADO.equals(this);
	  }
}
