package model;

import processing.core.PApplet;

public class Pokedex implements Comparable <Pokedex> {
	private PApplet app;
	private int posX,posY;
	private String nombre,tipo; 
	
	public Pokedex(String nombre,String tipo,int posX,int posY) {
		this.posX=posX;
		this.posY=posY;
		this.nombre=nombre;
		this.tipo=tipo;
		
	}
	
	
	public void drawPokedex() {
		
	}
	
	
	
	
	
	

	@Override
	public int compareTo(Pokedex nombre) {
//		return  this.nombre-nombre.getNombre();
		// TODO Auto-generated method stub
		return 0;
	}

}
