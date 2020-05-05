package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Jugador {
	private PApplet app;
	private int posX;
	private int posY;
	private PImage caminarHombre[];
	private PImage caminarMujer[];
	private PImage mujer;
	private int camino,direc;
	private boolean up,down,left,right;
	
	public Jugador(PApplet app,int posX,int posY) {
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		this.direc=0;
		this.camino=0;
		this.up=false;
		this.down=false;
		this.left=false;
		this.right=false;
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
		mujer=app.loadImage("imagenes/PersonajeFemenino/PFIzquierda1.png");
		
		
	}
	
	public void pintarJugadorCaminando() {
		
			switch(this.direc) {
			case 1:
			switch(this.camino) {
			case 0:
				app.image(caminarMujer[10],this.posX,this.posY);
				this.camino++;
				break;
			case 1:
				app.image(caminarMujer[11],this.posX,this.posY);
			
				break;
			}
				
				break;
			case 2:
				switch(this.camino) {	
			case 0:
				app.image(caminarMujer[8],this.posX,this.posY);
				this.camino++;
				break;
			case 1:
				app.image(caminarMujer[9],this.posX,this.posY);
				
				break;
				}
			
			case 3:
				switch(this.camino) {
			case 0:
				app.image(caminarMujer[6],this.posX,this.posY);
				this.camino++;
				break;
			case 1:
				app.image(caminarMujer[7],this.posX,this.posY);
				
			
				}
			
				
				break;
			case 4:
				switch(this.camino) {
				case 0:
					app.image(caminarMujer[5],this.posX,this.posY);
					this.camino++;
					break;
				case 1:
					app.image(caminarMujer[4],this.posX,this.posY);
					
					break;
					}
				}
	
	}
			
			
		
		
	
	
	public void pintarJugador() {
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
	
	public void caminarDos(PApplet app) {

		switch(app.keyCode) {
		case PConstants.LEFT:
			this.posX-=10;	
			this.direc=1;
//			app.image(caminarMujer[10],this.posX,this.posY);
			
			
			break;
		case PConstants.RIGHT:
			this.posX+=10;	
			this.direc=2;
			break;
		case PConstants.UP:
			this.posY-=10;	
			this.direc=3;
			
			
			break;
		case PConstants.DOWN:
			this.posY+=10;	
			this.direc=4;
			
			break;
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
	
	

}
