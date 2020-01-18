package com.marson.cursomcNovo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marson.cursomcNovo.domain.Categoria;
import com.marson.cursomcNovo.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcNovoApplication implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository categoriaRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcNovoApplication.class, args);
		
		
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null , "Inform�tica");
		Categoria cat2 = new Categoria(null , "Escrit�rio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
