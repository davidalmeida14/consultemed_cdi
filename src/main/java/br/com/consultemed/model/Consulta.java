package br.com.consultemed.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "TB_CONSULTA")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Medico medico;
	
	@OneToOne
	private Agendamento agendamento;
	
	private LocalDateTime dataRealizacaoConsulta;
	
	private LocalDateTime dataCancelamentoConsulta;

	@Enumerated(EnumType.STRING)
	private StatusConsulta statusConsulta;
	
	public StatusConsulta getStatusConsulta() {
		if(!Objects.isNull(this.agendamento.getStautsConsulta())) {
			return this.agendamento.getStautsConsulta();
		} else {
			return statusConsulta;
		}
	}
	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}
	public LocalDateTime getDataRealizacaoConsulta() {
		return dataRealizacaoConsulta;
	}
	public void setDataRealizacaoConsulta(LocalDateTime dataRealizacaoConsulta) {
		this.dataRealizacaoConsulta = dataRealizacaoConsulta;
	}
	public LocalDateTime getDataCancelamentoConsulta() {
		return dataCancelamentoConsulta;
	}
	public void setDataCancelamentoConsulta(LocalDateTime dataCancelamentoConsulta) {
		this.dataCancelamentoConsulta = dataCancelamentoConsulta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Agendamento getAgendamento() {
		return agendamento;
	}
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
	
}
