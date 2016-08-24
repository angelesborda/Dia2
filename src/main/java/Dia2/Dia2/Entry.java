package Dia2.Dia2;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Scanner;

class Entry {
	private String title;
	private String text;
	private Calendar date;
	private ArrayList<Tag> tag;
	private int id;
	
	
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String  getTitle(){
		return title;
	}
	public void setText(String text){
		this.text=text;
	}
	public String getText(){
		return text;
	}
	public void setCalendar(Calendar date){
		this.date=date;
	}
	public Calendar getCalendar(){
		return date;
	}
	public void setArrayList(ArrayList<Tag> list){
		this.tag=list;
	}
	
	public ArrayList<Tag> getArrayList(){
		return tag;
	}
	
	public ArrayList<Tag> seleccionarTags(User u){
		System.out.println ("Se muestran los tags existentes:");
		ArrayList<Tag> rta = new ArrayList<Tag>();
		if(u.getTag()!=null){
			for (int i=0;i<u.getTag().size();i++){
				System.out.print(u.getTag().get(i).getText());
				if(i!=u.getTag().size()-1){
					System.out.print(" ; ");
				}
				else{
					System.out.println ("");
				}
			}
		}
		
		System.out.println ("Ingresar los tags deseados separados por ';'. Es posible elegir ninguno");
		Scanner cont= new Scanner (System.in);
		String continua=String.valueOf(cont.nextLine());
		
		if (continua!=null && !continua.isEmpty()){
			Tag t;
			int pos=continua.indexOf(";");
			int i=0;
			String texto;
			while(i>=0){
				
				if(pos!=-1){
					texto=continua.substring(i, pos);
					i=pos+1;
					pos=continua.substring(i, continua.length()).indexOf(";");
					if(pos!=-1){
						pos+=i;
					}
				}
				else{
					texto=continua.substring(i, continua.length());
					i=pos;
				}
				
				t=new Tag();
				t.setText(texto);
				rta.add(t);
			}
			
		}
		cont.close();
		return rta;
	}

}

