package br.com.newair.newair.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.newair.newair.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

	public Iterable<Cliente> findByNameContaining(String parteName);
}
