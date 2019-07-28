package br.com.consultemed.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.consultemed.dao.ConsultaDaoImpl;
import br.com.consultemed.model.Consulta;

public class ConsultaService {

	ConsultaDaoImpl dao;
	
	public ConsultaService() {
		this.dao = new ConsultaDaoImpl();
	}
	
	public void salvar(Consulta consulta) {
		this.dao.salvar(consulta);
	}
	public List<Consulta> listar() {
		return this.dao.listar();
	}
	
	public void editar(Consulta consulta) {
		this.dao.editar(consulta);
	}
	
	public List<Consulta> consultaPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
		return this.dao.consultaPorPeriodo(dataInicio, dataFim);
	}
	
	public Consulta buscarPorId(Long id) {
		return this.dao.buscarPorId(id);
	}
	
}
