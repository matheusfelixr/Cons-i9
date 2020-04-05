package com.consi9.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consi9.api.model.Product;
import com.consi9.api.repository.ProductRepository;

@RestController
@RequestMapping(value="/api/product")
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping(path = "/list")
	public List<Product> listProducts(){
		return productRepository.findAll(); 
	}

	@PostMapping("/new") 
	public Product saveProduct(@RequestBody @Valid Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/delete")
	public void deleteProduct(@RequestBody @Valid Product product) {
		productRepository.delete(product);
	}
	
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody @Valid Product product) {
		return productRepository.save(product);
	}	


}
