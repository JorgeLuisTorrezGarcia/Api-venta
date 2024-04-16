package com.jltg.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jltg.demo.model.Persona;
import com.jltg.demo.repo.IGenericRepo;
import com.jltg.demo.service.IPersonaService;



@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

	@Autowired
	private IGenericRepo<Persona, Integer> repo;
	
	@Override
	protected IGenericRepo<Persona, Integer> getRepo() {
		return repo;
	}

}
