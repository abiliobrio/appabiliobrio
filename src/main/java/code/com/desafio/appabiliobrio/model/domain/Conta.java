package code.com.desafio.appabiliobrio.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descricao;
	
	private TipoConta tipoConta;
	
	private float saldo;
	
	private Date dataCriacao;
	
	private Status status;
	
	public Conta() {
		this.status = (Status.ATIVO);
		this.dataCriacao = new Date();
	}

	public Conta(String descricao, TipoConta tipoConta, Status status) {
		this();
		this.descricao = descricao;
		this.tipoConta = tipoConta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	@Override
	public String toString() {
		return "Conta [id=" + id + ", descricao=" + descricao + ", tipoConta=" + tipoConta + ", saldo=" + saldo
				+ ", dataCriacao=" + dataCriacao + ", status=" + status + "]";
	}

}
