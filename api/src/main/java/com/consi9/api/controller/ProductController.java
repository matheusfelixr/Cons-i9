package com.consi9.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consi9.api.model.Product;
import com.consi9.api.repository.ProductRepository;

@RestController
@RequestMapping(value="/api/product")
@CrossOrigin(origins = "*")
public class ProductController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping(path = "/list-all")
	public List<Product> listAllProduct(){
		try {
			LOGGER.info("Inicio da busca  no metodo listAllProduct().");
			
			List<Product> ret = new ArrayList<Product>();
			ret = productRepository.findAll();
			
			LOGGER.info("Fim da busca no metodo listAllProduct().");
			return ret;
		} catch (Exception e) {
			LOGGER.error("Erro ao tentar executar o metodo listAllProduct().");
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(path = "/find-by-parameter")
	public List<Product> findByParameterProducts(@RequestParam String name, Float costValue, Float saleValue){
		try {
			LOGGER.info("Inicio da busca no metodo findByParameterProducts().");
			
			List<Product> ret = new ArrayList<Product>();
			ret = productRepository.findByParameters(name, costValue, saleValue); 
			
			LOGGER.info("Fim da busca no metodo findByParameterProducts().");
			return ret;
		} catch (Exception e) {
			LOGGER.error("Erro ao tentar executar o metodo findByParameterProducts().");
			e.printStackTrace();
			return null;
		}
		
	}

	@PostMapping("/new")
	public Product saveProduct(@RequestBody @Valid Product product) {
		try {
			LOGGER.info("Inicio de processo de cadastro do metodo saveProduct().");
			
			product.setCancellation(false);
			product.setCancellationDate(null);
			product.setRegistrationDate(new Date());
			product.setUpdateDate(new Date());
			
			Product ret = new Product();
			ret = productRepository.save(product);
			
			LOGGER.info("fim de processo de cadastro do metodo saveProduct().");
			return ret;
			
		} catch (Exception e) {
			LOGGER.error("Erro ao tentar cadastro do metodo saveProduct().");
			e.printStackTrace();
			return null;
		}		
	}
	
	@PostMapping("/cancel") 
	public Product cancelProduct(@RequestParam Long idProduct) {
		try {
			LOGGER.info("Inicio de processo de cancelamento do metodo cancelProduct().");

			Product product = new Product();
			product = productRepository.findById(idProduct);
			if(product == null) {
				return null;
			}
			product.setCancellation(true);
			product.setCancellationDate(new Date());
			Product ret = new Product();
			ret = productRepository.save(product);
			
			LOGGER.info("Fim de processo de cancelamento do metodo cancelProduct().");
			return ret;
		} catch (Exception e) {
			LOGGER.error("Erro ao tentar cancelar no metodo cancelProduct().");
			e.printStackTrace();
			return null;
		}

	}

	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody @Valid Product product) {
		try {
			LOGGER.info("Inicio de processo de update do metodo updateProduct().");

			Product ret = new Product();
			product.setUpdateDate(new Date());
			ret = productRepository.save(product);
			
			LOGGER.info("Fim de processo de update do metodo updateProduct().");
			return ret;
		} catch (Exception e) {
			LOGGER.error("Erro ao tentar update no metodo updateProduct().");
			e.printStackTrace();
			return null;
		}
	}	


}
