package model;

import processing.core.PApplet;

public class Salvaje extends Pokemon implements Runnable{
	
	private boolean enPasto;
	
	public Salvaje(String id,String delante,String atras, int posX,int posY,PApplet app) {
		super(id,delante, atras, posX,posY, app);
		enPasto=false;
		
	}
	
	public void run() {
		if(enPasto==true) {
			caminarPasto();
			
		}
		
	}
	
	
	public void captura() {
		
	}
	
	
	public void caminarPasto() {
		
	}
	
	public void aparicion() {
		
	}



	
	
}
