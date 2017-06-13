package main;

import util.FileHelper;

public class Contactos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] listadoTotal = FileHelper.readFile("listado");
		ListaContactos nuevaLista = new ListaContactos(listadoTotal);
		
		for (int i = 0; i < listadoTotal.length; i++){
			System.out.println(nuevaLista.get(i).toString());
			
		}
		
	}

}
