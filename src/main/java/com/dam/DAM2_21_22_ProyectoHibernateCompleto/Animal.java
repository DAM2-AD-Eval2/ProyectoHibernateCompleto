package com.dam.DAM2_21_22_ProyectoHibernateCompleto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Animal {
	
	@Id
	protected int id;
	@Column
	protected String nombre;
	@Column
	protected int edad;
	@CreationTimestamp
	protected Date fechaAdopcion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codDueno", foreignKey = @ForeignKey(foreignKeyDefinition = "fk_dueno"))
	protected Dueno dueno;
	@ManyToMany(fetch = FetchType.LAZY)
	protected List<Veterinario> listaVeterinarios;
	
	public Animal(int id, String nombre, int edad, List<Veterinario> listVeterinarios, Dueno dueno) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.listaVeterinarios = listVeterinarios;
		this.dueno = dueno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaAdopcion() {
		return fechaAdopcion;
	}

	public void setFechaAdopcion(Date fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public List<Veterinario> getListaVeterinarios() {
		return listaVeterinarios;
	}

	public void setListaVeterinarios(List<Veterinario> listaVeterinarios) {
		this.listaVeterinarios = listaVeterinarios;
	}
	
}
