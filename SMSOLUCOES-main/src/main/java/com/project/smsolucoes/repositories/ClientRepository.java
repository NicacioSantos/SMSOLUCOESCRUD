package com.project.smsolucoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.smsolucoes.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
