package com.dam.DAM2_21_22_ProyectoHibernateCompleto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "P")
public class Perro extends Animal {
	
	@Column
	private int numVacunas;

	public Perro(int id, String nombre, int edad, List<Veterinario> listaVet, Dueno dueno,  int numVacunas) {
		super(id, nombre, edad, listaVet, dueno);
		this.numVacunas = numVacunas;
	}

	public int getNumVacunas() {
		return numVacunas;
	}

	public void setNumVacunas(int numVacunas) {
		this.numVacunas = numVacunas;
	}
	
}
