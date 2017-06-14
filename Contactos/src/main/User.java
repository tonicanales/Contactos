package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.FileHelper;
import util.Input;

public class User {
	
	public final static  String FILE_NAME = "listado";

	
	/******************************** user interface  ***********************************/
	public static void listarOpciones() {
		System.out.println("\nEscoge una opción");
		System.out.println("1. Adicionar un contacto\n2. Listar todos los contactos almacenados\n3. Listar ordenados por nombre\n4. Buscar por nombre\n"
				+ "5. Buscar por email\n6. Editar un contacto\n7. Eliminar un contacto\n8. Salir");
	}
	
	
	public static Persona scanNuevoRegistro() {
		System.out.println("Introduce nombre y apellido");
		String nombre = Input.scannLine();
		System.out.println("Introduce el teléfono");
		String telefono = Input.scannLine();
		System.out.println("Introduce el mail");
		String mail = Input.scannLine();
		String nuevoRegistro = nombre + ";" + telefono + ";" + mail;
		if (comprobacionesNuevo(nuevoRegistro)){
			Persona nuevaPersona = new Persona(nuevoRegistro);
			return nuevaPersona;
		} else {
			Persona nuevaPersona = null;
			return nuevaPersona;
		}
	}
	
	public static void printList(Persona[] array) {
		// TODO Auto-generated method stub
		for(int i=0; i < array.length; i++){
				System.out.println( i + " " + array[i].toString() ); 
		}
	}
	
	public static String pedirDatos(){
		System.out.println("Introduce datos:");
		String dato = Input.scannLine().toLowerCase();
		return dato;
	}
	
	public static void escribir(String[] registros) {
		FileHelper.writeFile(registros, FILE_NAME);
	}
	
	
	/******************************** comprobaciones  ***********************************/

	
	public static boolean comprobacionesNuevo(String registroacomprobar){
		boolean comprobacion = true;
		String[] separada = registroacomprobar.split(";");
		if (separada.length!=3 || separada[0] ==null || separada[1] ==null || separada[2] ==null || 
				checkPhone(separada[1])==false || checkEmail(separada[2])==false ){
			System.out.println("Datos no válidos");
			comprobacion = false;
			return comprobacion;
		}
			 
		else 
			return comprobacion;
			
	}
	
	
	
	
	private static boolean checkEmail (String email) {
		boolean mailvalido = false;
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            mailvalido = true;
        }
        return mailvalido;
    }
	
	
	private static boolean checkPhone (String phone) {
		boolean mailvalido = false;
		Pattern pattern = Pattern
                .compile("(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}");
 
        Matcher mat = pattern.matcher(phone);
 
        if (mat.matches() == true) {
            mailvalido = true;
        }
        return mailvalido;
    }
	

	
}
