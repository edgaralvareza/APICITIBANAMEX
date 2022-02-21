package com.ibm.proyectos.banamex.servicios;

import com.ibm.proyectos.banamex.modelo.entidades.Cliente;
import com.ibm.proyectos.banamex.repositorios.ClienteRepository;

public class ClienteDAOImpl extends GenericoDAOImpl<Cliente, ClienteRepository> implements ClienteDAO
{

	public ClienteDAOImpl(ClienteRepository repository) {
		super(repository);
		
	}

}
