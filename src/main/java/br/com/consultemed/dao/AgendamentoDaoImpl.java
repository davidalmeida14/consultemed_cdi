package br.com.consultemed.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.utils.JPAUtils;

public class AgendamentoDaoImpl {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();

	public void salvar(Agendamento agendamento) {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		em.persist(agendamento);
		em.getTransaction().commit();
	}

	public void remover(Long id) {
		em.remove(this.buscarAgendamentoPorId(id));
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Agendamento> listar() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT A FROM Agendamento A");
		return (List<Agendamento>) query.getResultList();

	}

	public Agendamento buscarAgendamentoPorId(Long id) {
		em.getTransaction().begin();
		Agendamento agendamentoBuscado = em.find(Agendamento.class, id);
		return agendamentoBuscado;
	}

	public void editarAgendamento(Agendamento agendamneto) {
		if (!this.em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		em.merge(agendamneto);
		em.getTransaction().commit();
	}

	public void closeTransaction() {
		this.em.close();
	}

	public void openTransaction() {
		this.em.getTransaction().begin();
	}
}
