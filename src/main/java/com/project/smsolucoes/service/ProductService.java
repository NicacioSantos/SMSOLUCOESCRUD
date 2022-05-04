package com.project.smsolucoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.smsolucoes.dto.ProductDTO;
import com.project.smsolucoes.entities.Product;
import com.project.smsolucoes.repositories.ProductRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProductService {

	ProductRepository productRepository;

	
	public ProductDTO saveProduct(ProductDTO productdto) {
		
		Product product = new Product();
	    BeanUtils.copyProperties(productdto, product);
	    product = productRepository.save(product);
	    
	    if ( product != null) {
	    	productdto.setId(product.getId());
	    	return productdto;
	    } else {
	    	return null;}
	}

	
	public List<ProductDTO> readAllProduct() {
		
		List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
		
		List<Product> products = productRepository.findAll();
		
		 for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
	        BeanUtils.copyProperties(product, productDTO);
	        productsDTO.add(productDTO);
	     }
		return productsDTO;

	}

	
	public ProductDTO readAllProductById(Long id) {
		
		ProductDTO productDTO = new ProductDTO();
		Product product = productRepository.findById(id).get();
	    if (product != null) {
	    	BeanUtils.copyProperties(productRepository.findById(id).get(), productDTO);
	    }

		return productDTO;

	}

	
	public ProductDTO updateProduct(ProductDTO productdto) {
		Product product = productRepository.findById(productdto.getId()).get();
	    BeanUtils.copyProperties(productdto, product);
	    
	    if (productRepository.save(product) != null) {
	    	return productdto;
	    } else {
	    	return null;}
	}

	
	public void deleteProductBIid( Long id) {

		productRepository.deleteById(id);
	}
	
}
