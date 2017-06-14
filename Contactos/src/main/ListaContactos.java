package main;

import java.util.Arrays;

public class ListaContactos {
	
	private Persona[] listacontactos;

	public ListaContactos( String[] listacontactos){
		iniContact(listacontactos);
	}

	private void iniContact(String[] listacontactos){
		
		this.listacontactos = new Persona[listacontactos.length];
		for (int i=0; i<listacontactos.length; i++){
			Persona contact = new Persona(listacontactos[i]);
			this.listacontactos[i] = contact;
		}
	}
	
	/**
	 * Retorna el numero de personas que contiene
	 * @return
	 */
	public int size(){
		return listacontactos.length;
	}
	
	
	/**
	 * Obtiene la persona que tiene el index i 
	 * @param i
	 * @return
	 */
	public Persona get(int i) {
		Persona[] copyLista = listacontactos;
		return copyLista[i];
	}
	
	public Persona[] getlista() {
		
		Persona[] lista = new Persona[listacontactos.length];
		for(int i=0; i<listacontactos.length; i++)
			lista[i]=listacontactos[i];
		return lista;
	}
	
	
	/**
	 * Adiciona una persona al alrreglo interno de personas. 
	 * Se adiciona en la ultima posicion
	 * @param contact
	 */
	public void addContact(Persona nuevaPersona){
		Persona[] copyPersona = new Persona[listacontactos.length+1];
		for (int i=0; i<listacontactos.length; i++){
			copyPersona[i]=listacontactos[i];
		}
		copyPersona[listacontactos.length]=nuevaPersona; 
		listacontactos = copyPersona;
	}
	
	/**
	 * Retorna el index del objeto person 
	 * @param person
	 * @return
	 */
	public int indexOf(Persona person){
		int index = -1; 
		for(int i=0; i<listacontactos.length; i++){
			if(listacontactos[i].equals(person)){
				index = i;
				 break; 
			}
		}	
		return index; 
	}
	
	
	/** Sobre escribe una persona de la lista en el index dado por index 
	 * @param person
	 * @param index
	 */
	public void set(int index, Persona person){
		
		if(index<listacontactos.length && index >= 0) 
			listacontactos[index]=person;
	}
	
	
	
	
	
	/**
	 * Elimina una persona del la lista
	 * @param person
	 */
	public void remove(Persona person){
		remove(indexOf(person));
	}
	
	public void remove(int index){
		Persona[] copyLista = new Persona[listacontactos.length-1];
		for (int i=0, j=0; i<copyLista.length; i++, j++){
			if(i==index) {
				j++;
			}
			copyLista[i]=listacontactos[j];
		}
		listacontactos=copyLista;
	}
	
	
	/**
	 * Retorna todas las personas que coontengan strString en su campo name
	 * @return
	 */
	public Persona[] findByName(String strName){
		int cont = 0;
		for (Persona person: listacontactos){
			if (person.getNombre().toLowerCase().startsWith(strName.toLowerCase()))
					cont++;
		}
		Persona[] copyLista = new Persona[cont];
		int i =0, j=0;
		for (Persona person: listacontactos){
			if (person.getNombre().toLowerCase().startsWith(strName.toLowerCase())){
					copyLista[j]=listacontactos[i];
					j++;
			}
			i++;
		}	
		return copyLista;
	}
	
	
	/**
	 * Retorna todas las personas que coontengan strString en su campo mail
	 * @return
	 */
	public Persona[] findByMail(String strMail){
		int cont = 0;
		for (Persona person: listacontactos){
			if (person.getMail().toLowerCase().startsWith(strMail.toLowerCase()))
				cont++;
		}
		Persona[] copyLista = new Persona[cont];
		int i =0, j=0;
		for (Persona person: listacontactos){
			if (person.getMail().toLowerCase().startsWith(strMail.toLowerCase())){
					copyLista[j]=listacontactos[i];
					j++;
			}
			i++;
		}	
		return copyLista;
	}
	
	
	/**
	 * Retorna una copia de la lista ordenada alfabeticamente
	 * @return
	 */
	public Persona[] sort(){
		String[] listaOrdenada = new String[listacontactos.length];
		int cont = 0;
		for(Persona persona:listacontactos){
			listaOrdenada[cont] = persona.toFormat();
			cont++;
		}
		
	    Arrays.sort(listaOrdenada);
	    ListaContactos listaConOrden = new ListaContactos(listaOrdenada);
	    return listaConOrden.listacontactos;

	}

	public String[] toFileFormat() {
		String[] lista = new String[listacontactos.length];
		for (int i=0; i < listacontactos.length; i++)
		lista[i] = listacontactos[i].getNombre() + " " + listacontactos[i].getApellidos() + ";" + listacontactos[i].getTelefono() + ";" + listacontactos[i].getMail();
		return lista;
	}	
		
		
	
	
	
}
