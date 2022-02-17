package com.dam.DAM2_21_22_ProyectoHibernateCompleto;

import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Principal {
	
	static ArrayList<Dueno> duenos = new ArrayList<Dueno>();
	static ArrayList<Animal> animales = new ArrayList<Animal>();
	static ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();

	public static void main(String[] args) throws IOException {
		
		Utilidad.leerFicheros(duenos, animales, veterinarios);
		
		//Creación del SessionFactory
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();   	
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		Session sesion = sf.openSession();
		
		sesion.beginTransaction();
		
			for (Dueno dueno: duenos) {
				sesion.save(dueno);
			}
			
			for (Veterinario vet: veterinarios) {
				sesion.save(vet);
			}
			
			for (Animal animal: animales) {
				sesion.save(animal);
			}
		
		
		sesion.getTransaction().commit();
		
		
		sesion.close();
		sf.close();
	}

}
