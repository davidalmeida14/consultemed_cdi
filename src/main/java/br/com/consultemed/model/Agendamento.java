package br.com.consultemed.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AGENDAMENTO")

public class Agendamento extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDateTime dataAgendamento;
	
	@ManyToOne
	@JoinColumn(name="Id_Paciente")
	private Paciente paciente;
	
	@Enumerated(EnumType.STRING)
	private StatusConsulta stautsConsulta;
	
	private String descricaoCancelamento;
	
	private LocalDateTime dataCancelamento;
	
	@ManyToOne()
	@JoinColumn(name = "Id_Medico")
	private Medico medico;
	
	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}
	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public StatusConsulta getStautsConsulta() {
		return stautsConsulta;
	}
	public void setStautsConsulta(StatusConsulta stautsConsulta) {
		this.stautsConsulta = stautsConsulta;
	}
	public String getDescricaoCancelamento() {
		return descricaoCancelamento;
	}
	public void setDescricaoCancelamento(String descricaoCancelamento) {
		this.descricaoCancelamento = descricaoCancelamento;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}
