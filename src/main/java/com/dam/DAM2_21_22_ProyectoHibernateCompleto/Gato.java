package com.dam.DAM2_21_22_ProyectoHibernateCompleto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "G")
public class Gato extends Animal {
	
	@Column
	private int numVidas;

	public Gato(int id, String nombre, int edad, List<Veterinario> listaVet, Dueno dueno, int numVidas) {
		super(id, nombre, edad, listaVet, dueno);
		this.numVidas = numVidas;
	}

	public int getNumVidas() {
		return numVidas;
	}

	public void setNumVidas(int numVidas) {
		this.numVidas = numVidas;
	}
	
}
