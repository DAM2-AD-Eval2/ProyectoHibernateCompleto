package com.dam.DAM2_21_22_ProyectoHibernateCompleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Utilidad {

   static HashMap<String, Dueno> hmDuenos = new HashMap<String, Dueno>();
   static HashMap<Integer, List<Veterinario>> hmVeterinarios = new HashMap<Integer, List<Veterinario>>();	
	
   public static void leerFicheros(ArrayList<Dueno> duenos, ArrayList<Animal> animales, ArrayList<Veterinario> veterinarios) throws IOException {
	   
	   BufferedReader brDueno = Files.newBufferedReader(Paths.get("D:\\PRUEBAS\\Animales\\duenos.csv"));
	   Stream<String> lineasDueno = brDueno.lines();
	   lineasDueno.forEach(l->{
		   String[] linea = l.split(";");
		   Dueno dueno = new Dueno(linea[0], linea[1], Integer.parseInt(linea[2]));
		   duenos.add(dueno);
		   hmDuenos.put(linea[0], dueno);
	   });
	   
	   BufferedReader brVeterinario = Files.newBufferedReader(Paths.get("D:\\PRUEBAS\\Animales\\veterinarios.csv"));
	   Stream<String> lineasVeterinario = brVeterinario.lines();
	   lineasVeterinario.forEach(l->{
		   String[] linea = l.split(";");
		   Veterinario veterinario = new Veterinario(Integer.parseInt(linea[0]), linea[1]);
		   veterinarios.add(veterinario);
		   List<Veterinario> listaVet = new ArrayList<Veterinario>();
		   listaVet.add(veterinario);
		   hmVeterinarios.put(Integer.parseInt(linea[0]), listaVet);
	   });
	   
	   BufferedReader brAnimal = Files.newBufferedReader(Paths.get("D:\\PRUEBAS\\Animales\\animales.csv"));
	   Stream<String> lineasAnimales = brAnimal.lines();
	   lineasAnimales.forEach(l->{
		   String[] linea = l.split(";");
		   if (linea[6].equals("p")) {
			   animales.add(new Perro(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), 
				   				  	hmVeterinarios.get(Integer.parseInt(linea[3])),
				   				  	hmDuenos.get(linea[4]), Integer.parseInt(linea[5])));
		   }else {
			   animales.add(new Gato(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), 
	   				  	hmVeterinarios.get(Integer.parseInt(linea[3])),
	   				  	hmDuenos.get(linea[4]), Integer.parseInt(linea[5])));
		   }
		  
	   });
	   
   }

}
