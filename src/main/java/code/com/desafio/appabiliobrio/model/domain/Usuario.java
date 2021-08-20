package code.com.desafio.appabiliobrio.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String loginUsuario;
	
	private String nomeUsuario;
	
	private String emailUsuario;
	
	private String senhaUsuario;
	
	private Date dataCriacaoUsuario;
	
	private Status status;
	
	private TipoUsuario tipoUsuario;
	
	public Usuario() {
		this.status = (Status.ATIVO);
		this.dataCriacaoUsuario = new Date();
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public Date getDataCriacaoUsuario() {
		return dataCriacaoUsuario;
	}

	public void setDataCriacaoUsuario(Date dataCriacaoUsuario) {
		this.dataCriacaoUsuario = dataCriacaoUsuario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailUsuario == null) ? 0 : emailUsuario.hashCode());
		result = prime * result + id;
		result = prime * result + ((loginUsuario == null) ? 0 : loginUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (emailUsuario == null) {
			if (other.emailUsuario != null)
				return false;
		} else if (!emailUsuario.equals(other.emailUsuario))
			return false;
		if (id != other.id)
			return false;
		if (loginUsuario == null) {
			if (other.loginUsuario != null)
				return false;
		} else if (!loginUsuario.equals(other.loginUsuario))
			return false;
		return true;
	}
	
	
	
}
