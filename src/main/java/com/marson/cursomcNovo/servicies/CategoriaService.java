package com.marson.cursomcNovo.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marson.cursomcNovo.domain.Categoria;
import com.marson.cursomcNovo.repositories.CategoriaRepository;
import com.marson.cursomcNovo.servicies.exceptions.ObjectNotFoudException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo ;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoudException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	
	
}
