package com.project.smsolucoes.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.smsolucoes.dto.SaleDTO;
import com.project.smsolucoes.entities.Client;
import com.project.smsolucoes.entities.Product;
import com.project.smsolucoes.entities.Sale;
import com.project.smsolucoes.repositories.ClientRepository;
import com.project.smsolucoes.repositories.ProductRepository;
import com.project.smsolucoes.repositories.SaleRepository;
import com.project.smsolucoes.util.Formater;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {

	SaleRepository salerepository;
	ClientRepository clientrepository;
	ProductRepository productrepository;
	

	public SaleDTO saveSale(SaleDTO saledto) {
		Sale sale = new Sale();
		List<Product> products = new ArrayList<Product>();
		
		Client client = clientrepository.findById(saledto.getClientid()).get();
		
		if (client != null) {
			sale.setClient(client);
		}	
		sale.setSaleDate(Formater.formatDate(LocalDate.now()));   
        sale.setDeliveryDate(Formater.formatDate(LocalDate.now().plusDays(10)));
        
        for (Long productID : saledto.getProducts()) {
        	Product product = productrepository.findById(productID).get();      	
        	if (product != null) {
        		products.add(product);
        	}
		}
        
        sale.setProducts(products);
        
        sale = salerepository.save(sale);  
	    
	    if (sale != null) {
	    	saledto.setId(sale.getId());
	    	saledto.setSaleDate(sale.getSaleDate());
	    	saledto.setDeliveryDate(sale.getDeliveryDate());
	    	return saledto;
	    } else {
	    	return null;}
	}

	public List<SaleDTO> readAllSale() {
		List<SaleDTO> salesDTO = new ArrayList<SaleDTO>();
		
		List<Sale> sales = salerepository.findAll();
				
		 for (Sale sale : sales) {
			 SaleDTO saledto = new SaleDTO();
			 List<Long> products = new ArrayList<Long>();
			 
			 for (Product product : sale.getProducts()) {
					products.add(product.getId());
				}
			saledto.setClientid(sale.getClient().getId());	
			saledto.setProducts(products);
			saledto.setId(sale.getId());
	    	saledto.setSaleDate(sale.getSaleDate());
	    	saledto.setDeliveryDate(sale.getDeliveryDate());
      
	        salesDTO.add(saledto);
	     }
		 
		return salesDTO;
	}
	
	
	public SaleDTO readSaleById(Long id) {
		Sale sale = salerepository.findById(id).get();	
		SaleDTO saledto = new SaleDTO();
		List<Long> products = new ArrayList<Long>();
		
		if (sale != null) {
			for (Product product : sale.getProducts()) {
				products.add(product.getId());
			}
			saledto.setClientid(sale.getClient().getId());	
			saledto.setProducts(products);
			saledto.setId(sale.getId());
	    	saledto.setSaleDate(sale.getSaleDate());
	    	saledto.setDeliveryDate(sale.getDeliveryDate());
			
		}
				
		return saledto;
	}

	public SaleDTO updateSale(SaleDTO saledto) {
		Sale sale = salerepository.findById(saledto.getClientid()).get();
		List<Product> products = new ArrayList<Product>();
		
		Client client = clientrepository.findById(saledto.getClientid()).get();
		
		if (client != null) {
			sale.setClient(client);
		}	
		sale.setSaleDate(Formater.formatDate(LocalDate.now()));   
	    sale.setDeliveryDate(Formater.formatDate(LocalDate.now().plusDays(10)));
	    
	    for (Long productID : saledto.getProducts()) {
	    	Product product = productrepository.findById(productID).get();      	
	    	if (product != null) {
	    		products.add(product);
	    	}
		}
	    
	    sale.setProducts(products);
	    sale = salerepository.save(sale);
	    
	    if (sale != null) {
	    	saledto.setId(sale.getId());
	    	saledto.setSaleDate(sale.getSaleDate());
	    	saledto.setDeliveryDate(sale.getDeliveryDate());
	    	return saledto;
	    } else {
	    	return null;}
	}

	public void deleteSaleBIid(Long id) {

		salerepository.deleteById(id);
	}
}
