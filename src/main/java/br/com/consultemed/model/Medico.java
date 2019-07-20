package br.com.consultemed.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
	@NamedQuery(name = "Medico.findAllCount", query = "SELECT COUNT(m) FROM Medico m") })

@Entity
@Table(name = "TB_MEDICOS")
public class Medico extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}