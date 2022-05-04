package com.project.smsolucoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.smsolucoes.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
