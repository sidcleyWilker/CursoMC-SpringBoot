package com.sidcleywilker.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidcleywilker.cursomc.domain.Categoria;
import com.sidcleywilker.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obg = repo.findById(id);
		return obg.orElse(null);
	}
}
