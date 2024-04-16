package com.jltg.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jltg.demo.model.Producto;
import com.jltg.demo.repo.IGenericRepo;
import com.jltg.demo.service.IProductoService;



@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

	@Autowired
	private IGenericRepo<Producto, Integer> repo;
	
	@Override
	protected IGenericRepo<Producto, Integer> getRepo() {
		return repo;
	}

}
