package com.jltg.demo.service.impl;

import java.util.List;

import com.jltg.demo.repo.IGenericRepo;
import com.jltg.demo.service.ICRUD;



public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T registrar(T t) {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() {
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) {
		getRepo().deleteById(id);
	}

}
