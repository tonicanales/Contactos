package main;

import util.Input;

public class Persona {
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String mail;
	
	
	
	
	public Persona (String contacto){
		
		String[] unaPersona = contacto.split(";");
		if(unaPersona.length<3)
			throw new RuntimeException("Formato incorrecto");
		String[] nombreApellido = unaPersona[0].split(" ");
		String nombre = nombreApellido[0];
		String apellido = (nombreApellido.length==2)?nombreApellido[1]:"";

		this.nombre = nombre;
		this.apellidos = apellido;
		this.telefono = (unaPersona[1]);
		this.mail = (unaPersona[2]);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	public String toFormat(){
		String cadena = nombre + " " + apellidos + ";" + telefono + ";" + mail;
		return cadena;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean r=false;
		Persona person = (Persona) obj;
		if (this.nombre.equals(person.getNombre())&&
				this.apellidos.equals(person.getApellidos()) &&
						this.telefono.equals(person.getTelefono()) &&
								this.mail.equals(person.getMail())
								){
				r = true;
					
				}
		return r;
	}

	
	
	
	@Override
	public String toString(){
		return  "Contacto: " + nombre  + " " + apellidos + " " + mail + " " + telefono;	
	}	
	
	

	
	
}
