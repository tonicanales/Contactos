package test;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import main.ListaContactos;
import main.Persona;

public class TestContactos {
	
	@Test
	public void testAdd(){
		
		String[] lista = {"Pedro Mart�nez;0000;pedro@gmail.com","Juan P�rez;1111;Juan@gmail.com"};
		ListaContactos nuevaLista = new ListaContactos(lista);
		String nuevoContacto = "Luis L�pez;2222;pedro@gmail.com";
		Persona newPersona = new Persona(nuevoContacto);
		nuevaLista.addContact(newPersona);
		
		Assert.assertEquals("Pedro", nuevaLista.get(0).getNombre());
		Assert.assertEquals("Mart�nez", nuevaLista.get(0).getApellidos());
		Assert.assertEquals("0000", nuevaLista.get(0).getTelefono());
		Assert.assertEquals("pedro@gmail.com", nuevaLista.get(0).getMail());
		
		Assert.assertEquals("Luis", nuevaLista.get(2).getNombre());
		Assert.assertEquals("L�pez", nuevaLista.get(2).getApellidos());
		Assert.assertEquals("2222", nuevaLista.get(2).getTelefono());
		Assert.assertEquals("pedro@gmail.com", nuevaLista.get(2).getMail());

	}
	
	
	@Test
	public void testSobreEscribe(){
		String[] lista = {"Pedro Mart�nez;0000;pedro@gmail.com","Juan P�rez;1111;Juan@gmail.com","Miguel Gonz�lez;3333;Miguel@gmail.com",
		"Carlos G�mez;444;carlos@gmail.com"};
		String sobreContacto = "Mar�a Mart�nez;5555;maria@gmail.com";
		Persona sobrePersona = new Persona(sobreContacto);
		ListaContactos nuevaLista = new ListaContactos(lista);
		nuevaLista.set(1, sobrePersona);
		
		Assert.assertEquals("Mar�a", nuevaLista.get(1).getNombre());
		Assert.assertEquals("Mart�nez", nuevaLista.get(1).getApellidos());
		Assert.assertEquals("5555", nuevaLista.get(1).getTelefono());
		Assert.assertEquals("maria@gmail.com", nuevaLista.get(1).getMail());
		
		
	}
	
	@Test
	public void testRemove(){
		
		String[] lista = {"Pedro Mart�nez;0000;pedro@gmail.com","Juan P�rez;1111;Juan@gmail.com","Miguel Gonz�lez;3333;Miguel@gmail.com",
				"Carlos G�mez;444;carlos@gmail.com"};
		ListaContactos nuevaLista = new ListaContactos(lista);
		String quitarContacto = "Pedro Mart�nez;0000;pedro@gmail.com";
		Persona quitarPersona = new Persona(quitarContacto);
		nuevaLista.remove(quitarPersona);
		
		Assert.assertEquals("Juan", nuevaLista.get(0).getNombre());
		Assert.assertEquals("P�rez", nuevaLista.get(0).getApellidos());
		Assert.assertEquals("1111", nuevaLista.get(0).getTelefono());
		Assert.assertEquals("Juan@gmail.com", nuevaLista.get(0).getMail());
		
		nuevaLista.remove(0);
		
		Assert.assertEquals("Miguel", nuevaLista.get(0).getNombre());
		Assert.assertEquals("Gonz�lez", nuevaLista.get(0).getApellidos());
		Assert.assertEquals("3333", nuevaLista.get(0).getTelefono());
		Assert.assertEquals("Miguel@gmail.com", nuevaLista.get(0).getMail());

	}
	
	
	@Test
	public void compareName(){
		String[] lista = {"Pedro Mart�nez;0000;pedro@gmail.com","Juan P�rez;1111;Juan@gmail.com","Jaime Gonz�lez;3333;Miguel@gmail.com",
		"Carlos G�mez;444;carlos@gmail.com"};
		ListaContactos copyLista = new ListaContactos(lista);
		
		Assert.assertEquals("Jaime", copyLista.findByName("Ja")[0].getNombre());

	}
	
	
	@Test
	public void ordenaName(){
		
		String[] lista = {"ZZ Mart�nez;0000;pedro@gmail.com","Antonio P�rez;1111;Juan@gmail.com","Miguel Gonz�lez;3333;Miguel@gmail.com",
		"Carlos G�mez;444;carlos@gmail.com"};
		
		ListaContactos copyLista = new ListaContactos(lista);
		Persona[] listaOrdenada = copyLista.sort();
		Assert.assertEquals("Antonio", listaOrdenada[0].getNombre());

		
	}
	
}
