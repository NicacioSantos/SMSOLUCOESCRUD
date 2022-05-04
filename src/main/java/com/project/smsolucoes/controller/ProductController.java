package com.project.smsolucoes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smsolucoes.dto.ProductDTO;
import com.project.smsolucoes.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

	ProductService productService;

	@PostMapping
	public ProductDTO saveProduct(@RequestBody ProductDTO productdto) {

		return productService.saveProduct(productdto);
	}

	@GetMapping
	public List<ProductDTO> readAllProduct() {

		return productService.readAllProduct();

	}

	@GetMapping("/{id}")
	public ProductDTO readAllProductById(@PathVariable Long id) {

		return productService.readAllProductById(id);

	}

	@PutMapping
	public ProductDTO updateProduct(@RequestBody ProductDTO productdto) {

		return productService.updateProduct(productdto);
	}

	@DeleteMapping("/{id}")
	public void deleteProductBIid(@PathVariable Long id) {

		productService.deleteProductBIid(id);
	}
}
