package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Jugador {
	protected PApplet app;
	protected int posX;
	protected int posY;
	

		
	protected int camino,direc;
	protected boolean up,down,left,right;
	
	public Jugador(PApplet app,int posX,int posY) {
		this.app=app;
		this.posX=posX;
		this.posY=posY+40;
		this.direc=0;
		this.camino=0;
		this.up=false;
		this.down=false;
		this.left=false;
		this.right=false;
		
		
		
		
		
	}
	public void pintarJugador() {
		
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
