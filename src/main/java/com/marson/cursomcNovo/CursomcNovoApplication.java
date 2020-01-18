package com.marson.cursomcNovo;

import java.util.Arrays;

import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marson.cursomcNovo.domain.Categoria;
import com.marson.cursomcNovo.domain.Cidade;
import com.marson.cursomcNovo.domain.Cliente;
import com.marson.cursomcNovo.domain.Endereco;
import com.marson.cursomcNovo.domain.Estado;
import com.marson.cursomcNovo.domain.Produto;
import com.marson.cursomcNovo.domain.enums.TipoCliente;
import com.marson.cursomcNovo.repositories.CategoriaRepository;
import com.marson.cursomcNovo.repositories.CidadeRepository;
import com.marson.cursomcNovo.repositories.ClienteRepository;
import com.marson.cursomcNovo.repositories.EnderecoRepository;
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
	
	@Autowired
	ClienteRepository clienteRepository ;
	
	@Autowired
	EnderecoRepository enderecoRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcNovoApplication.class, args);
		
		
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null , "Informática");
		Categoria cat2 = new Categoria(null , "Escritório");
		
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
		Estado est2 = new Estado(null , "São Paulo");
		
		Cidade c1 = new Cidade(null , "Uberlândia" , est1);
		Cidade c2 = new Cidade(null , "São Paulo" , est2);
		Cidade c3 = new Cidade(null , "Campinas" , est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2 , c3));
		
		Cliente cli1 = new Cliente(null,"Maria silva" , "silva@bol.com.br" , "11111" , TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("222","221"));
		
		Endereco e1 = new Endereco(null , "Rua flores" , "300" , "apto 303" , "Jardim" , "33344" , cli1 , c1);
		Endereco e2 = new Endereco(null , "Rua matos" , "400" , "apto 200" , "Centro" , "55544" , cli1 , c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
