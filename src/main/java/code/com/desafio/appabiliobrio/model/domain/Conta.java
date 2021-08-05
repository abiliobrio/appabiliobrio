package code.com.desafio.appabiliobrio.model.domain;

public class Conta {
	
	private String descricao;
	private int periodo;
	private float saldo;
	private boolean status;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Conta [descricao=" + descricao + ", periodo=" + periodo + ", saldo=" + saldo + ", status=" + status
				+ "]";
	}
	
}
