package com.sidcleywilker.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sidcleywilker.cursomc.domain.Categoria;
import com.sidcleywilker.cursomc.domain.Cidade;
import com.sidcleywilker.cursomc.domain.Estado;
import com.sidcleywilker.cursomc.domain.Produto;
import com.sidcleywilker.cursomc.repositories.CategoriaRepository;
import com.sidcleywilker.cursomc.repositories.CidadeRepository;
import com.sidcleywilker.cursomc.repositories.EstadoRepository;
import com.sidcleywilker.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRep;
	
	@Autowired
	private ProdutoRepository produtoRep;
	
	@Autowired
	private CidadeRepository cidaderiaRep;
	
	@Autowired
	private EstadoRepository estadoRep;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null,"informatica");
		Categoria c2 = new Categoria(null,"escritorio");
		
		Produto p1 = new Produto(null, "computador", 2000.0);
		Produto p2 = new Produto(null, "empresora", 800.0);
		Produto p3 = new Produto(null, "mause", 80.0);
		
		c1.setProdutos(Arrays.asList(p1,p2,p3));
		c2.setProdutos(Arrays.asList(p2));
		
		
		p1.setCategorias(Arrays.asList(c1));
		p2.setCategorias(Arrays.asList(c1,c2));
		p3.setCategorias(Arrays.asList(c1));
		
		categoriaRep.saveAll(Arrays.asList(c1,c2));
		produtoRep.saveAll(Arrays.asList(p1,p2,p3));
		
		//====================================================
		
		Estado e1 = new Estado(null, "minas gerais");
		Estado e2 = new Estado(null, "são paulo ");
		
		Cidade cid = new Cidade(null, "urbelandia", e1);
		Cidade cid2 = new Cidade(null, "sao paulo", e2);
		Cidade cid3 = new Cidade(null, "campinas", e2);
		
		e1.setCidades(Arrays.asList(cid));
		e2.setCidades(Arrays.asList(cid2,cid3));
		
		estadoRep.saveAll(Arrays.asList(e1,e2));
		cidaderiaRep.saveAll(Arrays.asList(cid,cid2,cid3));
	}

}
