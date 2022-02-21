package com.ibm.proyectos.banamex.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ibm.proyectos.banamex.modelo.entidades.Cliente;



public interface ClienteRepository extends CrudRepository<Cliente, Long>
{

	
}
