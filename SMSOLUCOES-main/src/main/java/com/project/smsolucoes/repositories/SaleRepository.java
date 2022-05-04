package com.project.smsolucoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.smsolucoes.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
