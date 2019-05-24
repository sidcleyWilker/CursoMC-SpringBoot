package com.sidcleywilker.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidcleywilker.cursomc.domain.Cliente;
import com.sidcleywilker.cursomc.repositories.ClienteRepository;
import com.sidcleywilker.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obg = repo.findById(id);
		return obg.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id+", Tipo: "+ Cliente.class.getName()));
	}
}
