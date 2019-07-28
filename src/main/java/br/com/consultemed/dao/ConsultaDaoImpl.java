package br.com.consultemed.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Consulta;
import br.com.consultemed.utils.JPAUtils;

public class ConsultaDaoImpl {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	
	public void salvar(Consulta consulta) {
		factory.getTransaction().begin();
		factory.persist(consulta);
		factory.getTransaction().commit();
	}
	
	public void remover(Long id) {
		this.factory.getTransaction().begin();
		this.factory.remove(this.buscarPorId(id));
		this.factory.getTransaction().commit();
	}
	
	public Consulta buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Consulta consultaBuscada = this.factory.find(Consulta.class, id);
		return consultaBuscada;
	}
	

	public void editar(Consulta consulta) {
		this.factory.getTransaction().begin();
		this.factory.merge(consulta);
		this.factory.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> listar(){
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT C From Consulta C");
		return (List<Consulta>) query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Consulta> consultaPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim){
		this.factory.getTransaction().begin();
		String q = "SELECT C FROM Consulta C INNER JOIN Agendamento A ON C.agendamento = A.id"
				+ " WHERE A.dataAgendamento BETWEEN :dataInicio AND :dataFim";
		Query query = this.factory.createQuery(q);
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		return (List<Consulta>) query.getResultList();
	}
	public void closeConnection() {
		this.factory.close();
	}
	
}
