package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Salvaje extends Pokemon implements Runnable{
	
	private boolean enPasto;
	private int dirX,dirY;
	private PImage pokemonImagenAdelante;
	public Salvaje(String id,String delante,String atras, int posX,int posY,PApplet app) {
		super(id,delante, atras, posX,posY, app);
		this.enPasto=false;
		this.dirX=1;
		this.dirY=1;
		this.pokemonImagenAdelante=app.loadImage(delante);
		this.vida=vida;
	}
	
	public void run() {
		if(enPasto==true) {
			caminarPasto();
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public void captura() {
		
	}
	
	
	public void pintar(PImage pokemonImagen) {
		
		
		app.image(pokemonImagen, posX, posY);
	}
	
	
	public void caminarPasto() {
		
		posX+=dirX;
		posY+=dirY;
		
		
	}
	
	public void escape() {
	
		posX+=2;
		if(posX>=1300) {
			posX=1320;
		}
	}
	
	
	public void aparicion() {
		
	}

	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public boolean isEnPasto() {
		return enPasto;
	}

	public void setEnPasto(boolean enPasto) {
		this.enPasto = enPasto;
	}
	
	

	public PImage getPokemonImagenAdelante() {
		return pokemonImagenAdelante;
	}




	public void setPokemonImagenAdelante(PImage pokemonImagenAdelante) {
		this.pokemonImagenAdelante = pokemonImagenAdelante;
	}



	
	

	
	
}
