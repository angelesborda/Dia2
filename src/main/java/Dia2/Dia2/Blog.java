package Dia2.Dia2;

import java.util.Calendar;
import java.util.Scanner;

public class Blog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User u=new User();
		Scanner textoTag;
		String nuevoTag;
		Scanner cont;
		String continua;
		Entry e;
		Tag tag;
		continua="y";
		do{
			System.out.println ("Si desea ingresar un post, seleccione 1");
			System.out.println ("Si desea borrar un post, selecione 3");
			System.out.println ("Si desea agregar Tag, selecione 4");
			System.out.println ("Si desea salir, selecione 5");
			cont= new Scanner (System.in);
			int i=Integer.valueOf(cont.nextLine());
			
			switch(i){
				case 1:
					e=new Entry();
					
					System.out.println ("Ingrese el titulo");
					Scanner entrada = new Scanner (System.in);
					e.setTitle(String.valueOf(entrada.nextLine()));
					
					System.out.println ("Ingrese el texto");
					entrada = new Scanner (System.in);
					e.setText(String.valueOf(entrada.nextLine()));
					
					e.setCalendar(Calendar.getInstance());
					
					e.setArrayList(e.seleccionarTags(u));
					
					u.setEntry(e);
					u.postEntry(e);
					break;
				case 2:
					if(u.getEntry()!=null){
				
						int x= u.getEntry().size();
						if(u.getEntry().size()>10){
							for(int y=(x-1);y>=(x-10);y--){
								u.postEntry(u.getEntry().get(y));
								
							}
						}
						else{
							for(int y=(x-1);y>=0;y--){
								u.postEntry(u.getEntry().get(y));
							}
						}
					}
			
					 
					break;
				case 3:
					System.out.println("Ingrese el titulo del post que desee eliminar");
					Scanner xx= new Scanner (System.in);
					String post=String.valueOf(xx.nextLine());
					Entry delEntry=u.getEntryByTitle(post, u);
					if(delEntry!=null){
						
						try{
							System.out.println();
							u.deleteEntry(delEntry);
							System.out.println("El post se ha borrado con éxito");
						}
						catch(Exception ex){
							System.out.println("El listado de posts esta vacio");
						}
						
					}
					else{
						System.out.println("No hay o no se encontró el post elegido para borrar");
					}
					
					break;
				case 4:
					String continuar="y";
					while(continuar.equalsIgnoreCase("y")){
						
							System.out.println ("Ingrese nuevo tag");
							textoTag = new Scanner (System.in);
							nuevoTag=String.valueOf(textoTag.nextLine());
							
							tag=new Tag();
							tag.setText(nuevoTag);
							u.setTag(tag);
							System.out.println ("Desea ingresar otro tag? (Y/N)");
							cont = new Scanner (System.in);
							continuar=String.valueOf(cont.nextLine());
						
					}
					
					break;
				case 5: continua="n";
				break;
				default: 	System.out.println("opcion erronéa");
				break;
			
			}
		}while(continua.equalsIgnoreCase("y"));
	}
}