package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Jugador {
	private PApplet app;
	private int posX;
	private int posY;
	private PImage caminarMujer[];
	private PImage caminarHombre[];

    private ArrayList<Pokemon> pokemonCapturados;
	private int genero;
	private boolean up,down,left,right;
	
	public Jugador(PApplet app,int posX,int posY) {
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		
		this.genero=0;
		this.up=false;
		this.down=false;
		this.left=false;
		this.right=false;
		
		this.pokemonCapturados=new ArrayList<Pokemon>();
		
		
		
		caminarMujer= new PImage[12];
		caminarMujer[0]=app.loadImage("imagenes/PersonajeFemenino/PFIzquierda1.png");
		caminarMujer[1]=app.loadImage("imagenes/PersonajeFemenino/PFDerecha1.png");
		caminarMujer[2]=app.loadImage("imagenes/PersonajeFemenino/PFArriba1.png");
		caminarMujer[3]=app.loadImage("imagenes/PersonajeFemenino/PFAbajo1.png");
		caminarMujer[4]=app.loadImage("imagenes/PersonajeFemenino/PFAbajo2.png");
		caminarMujer[5]=app.loadImage("imagenes/PersonajeFemenino/PFAbajo3.png");
		caminarMujer[6]=app.loadImage("imagenes/PersonajeFemenino/PFArriba2.png");
		caminarMujer[7]=app.loadImage("imagenes/PersonajeFemenino/PFArriba3.png");
		caminarMujer[8]=app.loadImage("imagenes/PersonajeFemenino/PFDerecha2.png");
		caminarMujer[9]=app.loadImage("imagenes/PersonajeFemenino/PFDerecha3.png");
		caminarMujer[10]=app.loadImage("imagenes/PersonajeFemenino/PFIzquierda2.png");
		caminarMujer[11]=app.loadImage("imagenes/PersonajeFemenino/PFIzquierda3.png");
		
		caminarHombre= new PImage[12];
		caminarHombre[0]=app.loadImage("imagenes/PersonajeMasculino/PMIzquierda1.png");
		caminarHombre[1]=app.loadImage("imagenes/PersonajeMasculino/PMDerecha1.png");
		caminarHombre[2]=app.loadImage("imagenes/PersonajeMasculino/PMArriba1.png");
		caminarHombre[3]=app.loadImage("imagenes/PersonajeMasculino/PMAbajo1.png");
		caminarHombre[4]=app.loadImage("imagenes/PersonajeMasculino/PMAbajo2.png");
		caminarHombre[5]=app.loadImage("imagenes/PersonajeMasculino/PMAbajo3.png");
		caminarHombre[6]=app.loadImage("imagenes/PersonajeMasculino/PMArriba2.png");
		caminarHombre[7]=app.loadImage("imagenes/PersonajeMasculino/PMArriba3.png");
		caminarHombre[8]=app.loadImage("imagenes/PersonajeMasculino/PMDerecha2.png");
		caminarHombre[9]=app.loadImage("imagenes/PersonajeMasculino/PMDerecha3.png");
		caminarHombre[10]=app.loadImage("imagenes/PersonajeMasculino/PMIzquierda2.png");
		caminarHombre[11]=app.loadImage("imagenes/PersonajeMasculino/PMIzquierda3.png");
		
		
		
		
	}
	
	
	
	public void pintarJugador() {
		if(genero==0) {
			for(int i=0;i<caminarMujer.length;i++) {
				app.image(caminarMujer[0],this.posX,this.posY);
				if(up) {
					app.image(caminarMujer[2],this.posX,this.posY);
				}
				if(down) {
					app.image(caminarMujer[3],this.posX,this.posY);
				}
				if(left) {
					app.image(caminarMujer[0],this.posX,this.posY);
				}
				if(right) {
					app.image(caminarMujer[1],this.posX,this.posY);
				}
			}
		}
		
		if(genero==1) {
			for(int i=0;i<caminarHombre.length;i++) {
				app.image(caminarHombre[0],this.posX,this.posY);
				if(up) {
					app.image(caminarHombre[2],this.posX,this.posY);
				}
				if(down) {
					app.image(caminarHombre[3],this.posX,this.posY);
				}
				if(left) {
					app.image(caminarHombre[1],this.posX,this.posY);
				}
				if(right) {
					app.image(caminarHombre[0],this.posX,this.posY);
				}
			}
		}
			
		}
			
			
		

	
	

	public void pokebola() {
		
		for(Pokemon elPokemon : pokemonCapturados) {
			
			
			
			
		}
		
		
		
	}
	
	
	
	
	public void caminar(PApplet app) {

		switch(app.keyCode) {
		case PConstants.LEFT:
			
			this.left=true;
			this.right=false;
			this.up=false;
			this.down=false;
			
			
			break;
		case PConstants.RIGHT:
			
			this.right=true;
			this.left=false;
			this.up=false;
			this.down=false;
			break;
		case PConstants.UP:
			
			this.up=true;
			this.right=false;
			this.left=false;
			this.down=false;
			
			break;
		case PConstants.DOWN:
				
			this.down=true;
			this.right=false;
			this.left=false;
			this.up=false;
			break;
		}
		
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

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}



	public int getGenero() {
		return genero;
	}



	public void setGenero(int genero) {
		this.genero = genero;
	}



	public ArrayList<Pokemon> getPokemonCapturados() {
		return pokemonCapturados;
	}



	public void setPokemonCapturados(ArrayList<Pokemon> pokemonCapturados) {
		this.pokemonCapturados = pokemonCapturados;
	}
	
	
	

}
