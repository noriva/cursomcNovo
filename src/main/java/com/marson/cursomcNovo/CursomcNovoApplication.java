package com.marson.cursomcNovo;

import java.text.SimpleDateFormat;
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
import com.marson.cursomcNovo.domain.Pagamento;
import com.marson.cursomcNovo.domain.PagamentoComBoleto;
import com.marson.cursomcNovo.domain.PagamentoComCartao;
import com.marson.cursomcNovo.domain.Pedido;
import com.marson.cursomcNovo.domain.Produto;
import com.marson.cursomcNovo.domain.enums.EstadoPagamento;
import com.marson.cursomcNovo.domain.enums.TipoCliente;
import com.marson.cursomcNovo.repositories.CategoriaRepository;
import com.marson.cursomcNovo.repositories.CidadeRepository;
import com.marson.cursomcNovo.repositories.ClienteRepository;
import com.marson.cursomcNovo.repositories.EnderecoRepository;
import com.marson.cursomcNovo.repositories.EstadoRepository;
import com.marson.cursomcNovo.repositories.PagamentoRepository;
import com.marson.cursomcNovo.repositories.PedidoRepository;
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
	
	@Autowired
	PedidoRepository pedidoRepository ;
	
	@Autowired
	PagamentoRepository pagamentoRepository ;
	
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
		
		Cliente cli1 = new Cliente(null,"Maria silva" , "silva@bol.com.br" , "11111" , TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("222","221"));
		
		Endereco e1 = new Endereco(null , "Rua flores" , "300" , "apto 303" , "Jardim" , "33344" , cli1 , c1);
		Endereco e2 = new Endereco(null , "Rua matos" , "400" , "apto 200" , "Centro" , "55544" , cli1 , c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1 , pagto2));
		
	}

}
