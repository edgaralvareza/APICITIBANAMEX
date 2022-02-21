package com.ibm.proyectos.banamex.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.ibm.proyectos.banamex.enumeradores.RangoEdad;
import com.ibm.proyectos.banamex.enumeradores.RangoSalario;
import com.ibm.proyectos.banamex.enumeradores.TipoPasion;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cliente", schema = "banamex")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable 
{
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 60)
	private String apellido;
	
	
	
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	
	@Column(name = "rango_edad")
	@Enumerated(EnumType.STRING)
	private RangoEdad rangoEdad;
	
	@Column(name = "rango_salario")
	@Enumerated(EnumType.STRING)
	private RangoSalario rangoSalario;
	
	@Column(name = "tipo_pasion")
	@Enumerated(EnumType.STRING)
	private TipoPasion tipoPasion;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<TarjetaCredito> tarjetasCredito;
	
	
	
	public Cliente(Long id, String nombre, String apellido, String usuarioCreacion, RangoEdad rangoEdad,
			RangoSalario rangoSalario, TipoPasion tipoPasion) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuarioCreacion = usuarioCreacion;
		this.rangoEdad = rangoEdad;
		this.rangoSalario = rangoSalario;
		this.tipoPasion = tipoPasion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", usuarioCreacion=");
		builder.append(usuarioCreacion);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append(", rangoEdad=");
		builder.append(rangoEdad);
		builder.append(", rangoSalario=");
		builder.append(rangoSalario);
		builder.append(", tipoPasion=");
		builder.append(tipoPasion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@PrePersist
	private void antesPersistir()
	{
		this.fechaCreacion = new Date();
	}
	
	@PreUpdate
	private void antesActualizar()
	{
		this.fechaModificacion = new Date();
	}
	
	private static final long serialVersionUID = 78681449385673536L;

}
