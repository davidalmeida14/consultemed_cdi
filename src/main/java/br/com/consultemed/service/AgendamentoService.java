package br.com.consultemed.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.consultemed.dao.AgendamentoDaoImpl;
import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.StatusConsulta;

public class AgendamentoService {

	AgendamentoDaoImpl dao;

	public AgendamentoService() {
		dao = new AgendamentoDaoImpl();
	}

	public void salvar(Agendamento agendamento) {

		List<Agendamento> allAgendamentos = this.listar();

		this.validarAgendamento(allAgendamentos, agendamento);

		this.dao.salvar(agendamento);
	}

	public void remover(Long id) {
		this.dao.remover(id);
	}

	public List<Agendamento> listar() {
		return this.dao.listar();
	}

	public void editar(Agendamento agendamento) {
		this.dao.editarAgendamento(agendamento);

	}

	public Agendamento buscaPorId(Long id) {
		return this.dao.buscarAgendamentoPorId(id);
	}

	public Agendamento buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public Agendamento buscaPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void reagendar(Agendamento agendamento) {

		List<Agendamento> allAgendamentos = this.listar();

		this.validarAgendamento(allAgendamentos, agendamento);

		Agendamento agendamentoBuscado = this.buscaPorId(agendamento.getId());

		if (!agendamentoBuscado.getDataAgendamento().isEqual(agendamento.getDataAgendamento())) {
			agendamento.setStautsConsulta(StatusConsulta.REAGENDADO);
			this.dao.editarAgendamento(agendamento);
		}

	}

	public void validarAgendamento(List<Agendamento> allAgendamentos, Agendamento agendamento) {

		allAgendamentos.forEach(a -> {
			if (a.getDataAgendamento().isEqual(agendamento.getDataAgendamento())
					&& a.getMedico().getId().equals(agendamento.getMedico().getId()) && a.getDataAgendamento() != null) {
				throw new RuntimeException("Nao pode haver dois agendamentos na mesma data para o mesmo médico");
			}
		});

		if (agendamento.getDataAgendamento().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("Data de agendamento não pode ser anterior a data atual");
		}
	}

	public void closeConnection() {
		this.dao.closeTransaction();
	}

	public void openTransaction() {
		this.dao.openTransaction();
	}
}
