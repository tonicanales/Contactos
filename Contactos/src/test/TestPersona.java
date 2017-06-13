package test;

import org.junit.Assert;
import org.junit.Test;

import main.ListaContactos;
import main.Persona;
public class TestPersona {

		
		@Test
		public void testPersona(){
			
			String contacto = "Pedro Martínez;1234567;pedro@gmail.com";
			Persona miPersona = new Persona(contacto);
			
			
			Assert.assertEquals("Pedro", miPersona.getNombre());
			Assert.assertEquals("Martínez", miPersona.getApellidos());
			Assert.assertEquals("1234567", miPersona.getTelefono());
			Assert.assertEquals("pedro@gmail.com", miPersona.getMail());

		}
}
