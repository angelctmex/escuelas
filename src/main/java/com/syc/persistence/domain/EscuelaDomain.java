package com.syc.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "ESCUELAS")

@NamedQueries({
	@NamedQuery(name = "escuelaDomain.buscarPorEscuela", query = "FROM EscuelaDomain ed WHERE ed.nombreEscuela = :escuela")
})

public class EscuelaDomain {
	
	@Id
	@Column(name = "ID_ESCUELA")
	private long   idEscuela;
	
	@Column(name = "NOMBRE_ESCUELA")
	private String nombreEscuela;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "ESPECIALIDAD")
	private String especialidad;
	
	public long getIdEscuela() {
		return idEscuela;
	}
	
	public String getNombreEscuela() {
		return nombreEscuela;
	}
	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String toString() {
		String buffer;
		buffer = "idEscuela[ " + idEscuela + " ]  ";
		buffer += "nombreEscuela[ " + nombreEscuela + " ]  ";
		buffer += "direccion[ " + direccion + " ]  ";
		buffer += "telefono[ " + telefono + " ]  ";
		buffer += "especialidad[ " + especialidad + " ]  ";
		return buffer;
	}

}
