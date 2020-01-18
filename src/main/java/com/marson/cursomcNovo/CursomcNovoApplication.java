package com.marson.cursomcNovo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marson.cursomcNovo.domain.Categoria;
import com.marson.cursomcNovo.domain.Cidade;
import com.marson.cursomcNovo.domain.Estado;
import com.marson.cursomcNovo.domain.Produto;
import com.marson.cursomcNovo.repositories.CategoriaRepository;
import com.marson.cursomcNovo.repositories.CidadeRepository;
import com.marson.cursomcNovo.repositories.EstadoRepository;
import com.marson.cursomcNovo.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcNovoApplication implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository categoriaRepository ;
	
	@Autowired
	ProdutoRepository produtoRepository ;
	
	@Autowired
	EstadoRepository estadoRepository ;
	
	@Autowired
	CidadeRepository cidadeRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcNovoApplication.class, args);
		
		
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null , "Inform�tica");
		Categoria cat2 = new Categoria(null , "Escrit�rio");
		
		Produto p1 = new Produto(null , "Computador" , 2000.00);
		Produto p2 = new Produto(null , "Impressora" , 800.00);
		Produto p3 = new Produto(null , "Mouse" , 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1 , cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2,p3));
		
		Estado est1 = new Estado(null , "Minas gerais");
		Estado est2 = new Estado(null , "S�o Paulo");
		
		Cidade c1 = new Cidade(null , "Uberl�ndia" , est1);
		Cidade c2 = new Cidade(null , "S�o Paulo" , est2);
		Cidade c3 = new Cidade(null , "Campinas" , est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2 , c3));
		
		
	}

}
