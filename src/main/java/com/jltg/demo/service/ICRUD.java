package com.jltg.demo.service;

import java.util.List;



public interface ICRUD<T, ID> {

	T registrar(T t);
	T modificar(T t);
	List<T> listar();
	T listarPorId(ID id);
	void eliminar(ID id);
	
}
