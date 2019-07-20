package br.com.consultemed.service;

import java.util.List;

public interface IMedico<T> {

	public void salvar(T medico) throws Exception;
	public void remover(Long id) throws Exception;
	public List<T> listar() throws Exception;
	public void editar(T medico) throws Exception;
	public T buscaPorId(Long id) throws Exception;
	public T buscaPorNome(String nome) throws Exception;
	public T buscaPorEmail(String email) throws Exception;
	
}
