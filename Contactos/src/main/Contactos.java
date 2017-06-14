package main;

import util.FileHelper;
import util.Input;

public class Contactos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] listadoTotal = FileHelper.readFile("listado");
		if (listadoTotal==null)
			 listadoTotal = new String[0];
		
		ListaContactos nuevaLista = new ListaContactos(listadoTotal);

		String eleccion;

		do {
			
			User.listarOpciones();
			eleccion = Input.scannLine();

			switch (eleccion){
		
			case "1":
				Persona newcontact = User.scanNuevoRegistro();
				if (newcontact!=null){
					nuevaLista.addContact(newcontact);
					User.escribir(nuevaLista.toFileFormat());
				}
				break;
			case "2":
				User.printList(nuevaLista.getlista());
				break;
			case "3":
				User.printList(nuevaLista.sort());
				break;
			case "4":
				User.printList(nuevaLista.findByName(User.pedirDatos()));
				break;
			case "5":
				User.printList(nuevaLista.findByMail(User.pedirDatos()));
				break;
			case "6":
				User.printList(nuevaLista.getlista());
				nuevaLista.set(Input.scannInt(), User.scanNuevoRegistro());
				User.escribir(nuevaLista.toFileFormat());
				break;
			case "7":
				User.printList(nuevaLista.getlista());
				nuevaLista.remove(Input.scannInt());
				FileHelper.writeFile(nuevaLista.toFileFormat(), "listado");
				break;
			case "8":
				System.out.println("Hasta pronto");
				break;
			}	
		} while (eleccion!="8");
		
	}


}
