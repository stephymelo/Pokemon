package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Rival {
	private PApplet app;
	private int posX,posY;
	private PImage mapaRival;
	
	
	public Rival(PApplet app, int posX,int posY) {
		this.app=app;
		this.mapaRival=app.loadImage("./imagenes/Contrincante/EnemigoFrente.png");
		this.posX=posX;
		this.posY=posY;
		
	}
	
	
	public void pintar() {
		app.image(mapaRival,this.posX,posY);
		
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	

}
