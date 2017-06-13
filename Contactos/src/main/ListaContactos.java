package main;

import java.util.Arrays;

public class ListaContactos {
	
	private Persona[] listacontactos;

	public ListaContactos(String[] listacontactos){
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
		return listacontactos[i];
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
	public void set(Persona person, int index){
		
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
		for (int i = 0; i < listacontactos.length; i++){
			if(strName.length()<=listacontactos[i].getNombre().length()){
				String subnombre = listacontactos[i].getNombre().substring(0, strName.length()).toLowerCase();
				if (subnombre.equals(strName.toLowerCase())){
					cont++;
				}
			}
		}
		Persona[] copyLista = new Persona[cont];	
		for (int i = 0, j = 0; i < listacontactos.length; i++){
			if(strName.length()<=listacontactos[i].getNombre().length()){
				String subnombre = listacontactos[i].getNombre().substring(0, strName.length()).toLowerCase();
				if (subnombre.equals(strName.toLowerCase())){
					copyLista[j]=listacontactos[i];
					j++;
				}
			}
		}	
		return copyLista;
	}
	
	
	
	
	
	
}
