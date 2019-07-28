package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.dao.MedicoDaoImpl;
import br.com.consultemed.model.Medico;

public class MedicoBusiness implements IMedico<Medico>{

	MedicoDaoImpl medicoDao;
	
	public MedicoBusiness() {
		medicoDao = new MedicoDaoImpl();
	} 
	@Override
	public void salvar(Medico medico){
		this.medicoDao.save(medico);
		
	}

	@Override
	public void remover(Long id)  {
		this.medicoDao.deleteById(id);
	}

	@Override
	public List<Medico> listar(){
		return (List<Medico>) this.medicoDao.listAll();
	}

	@Override
	public void editar(Medico medico){
		this.medicoDao.update(medico);
		
	}

	@Override
	public Medico buscaPorId(Long id){
		return this.medicoDao.findById(id);
	}

	@Override
	public Medico buscaPorNome(String nome) {
		return this.medicoDao.buscarPorNome(nome);
	}

	@Override
	public Medico buscaPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public int count() {
		return this.medicoDao.countMedico();
	}

}
