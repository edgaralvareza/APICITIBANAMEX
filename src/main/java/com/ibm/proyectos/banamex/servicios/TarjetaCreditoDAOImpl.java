package com.ibm.proyectos.banamex.servicios;

import com.ibm.proyectos.banamex.modelo.entidades.TarjetaCredito;
import com.ibm.proyectos.banamex.repositorios.TarjetaCreditoRepository;

public class TarjetaCreditoDAOImpl extends GenericoDAOImpl<TarjetaCredito, TarjetaCreditoRepository> implements TarjetaCreditoDAO
{

	public TarjetaCreditoDAOImpl(TarjetaCreditoRepository repository) {
		super(repository);
		
	}

}
