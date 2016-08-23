package Dia2.Dia2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class User {
	private String nombre;
	private ArrayList<Tag> tag;
	private ArrayList<Entry> entry;
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return nombre;
	}
	
	public void setEntry(Entry entry1)throws NullPointerException{
		try{
			if(entry==null){
				entry=new ArrayList<Entry>();
			}
			this.entry.add(entry1);
		}
		catch(Exception e){
			System.out.println("Error: el Array de Tags esta vacio");
		}
		
	}
	public ArrayList<Entry> getEntry(){
		return entry;
	}
	
	public void setTag(Tag tag1) throws NullPointerException{
		try{
			if(tag==null){
				tag=new ArrayList<Tag>();
			}
			tag.add(tag1);
		}
		catch(Exception e){
			System.out.println("Error: el Array de Tags esta vacio");
		}
		
	}
	public ArrayList<Tag> getTag(){
		return tag;
	}
	public void deleteEntry(Entry entrada) throws IOException{
		try{
			int i=-1;
			boolean encontrado=false;
			
			while(i<entry.size() && !encontrado){
				i++;
				if(entry.get(i).getId()==entrada.getId()){
					encontrado=true;
				}
			}
			
			entry.remove(i);
			
		}
		catch (Exception e){
			System.out.println("ERROR: El post que se desea borrrar no existe");
		}
		
	}
	
	public void postEntry(Entry e){
		System.out.println("Titulo: " + e.getTitle());
		System.out.println(e.getText());
		int mes=e.getCalendar().get(Calendar.MONTH) +1;
		System.out.println("Fecha: "+ e.getCalendar().get(Calendar.DAY_OF_MONTH) + " / " + mes + " / " + e.getCalendar().get(Calendar.YEAR));
		
		if(e.getArrayList()!=null){
			Tag tag;
			for(int t=0;t<e.getArrayList().size();t++){
				tag=e.getArrayList().get(t);
				System.out.print(tag.getText() + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	public Entry getEntryByTitle(String post, User u){
		int i=0;
		while(i<u.getEntry().size()){
			if(u.getEntry().get(i).getTitle().equalsIgnoreCase(post)){
				return getEntry().get(i);
			}
			i++;
		}
		
		return null;
	}
}
