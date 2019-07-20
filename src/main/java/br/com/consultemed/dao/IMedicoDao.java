package br.com.consultemed.dao;

import java.util.Collection;

import br.com.consultemed.model.Medico;

public interface IMedicoDao extends GenericDao<Medico, Long> {

	public void save(Medico medico);

	public Medico findById(Long id);

	public void deleteById(Long id);

	public void update(Medico medicos);

	public Collection<Medico> listAll();

	public int countMedico();

}
