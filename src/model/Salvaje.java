package model;

import processing.core.PApplet;

public class Salvaje extends Pokemon implements Runnable{
	
	private boolean enPasto;
	private int dirX,dirY;
	
	public Salvaje(String id,String delante,String atras, int posX,int posY,PApplet app) {
		super(id,delante, atras, posX,posY, app);
		this.enPasto=false;
		this.dirX=1;
		this.dirY=1;
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
	
	
	public void caminarPasto() {
		
		posX+=dirX;
		posY+=dirY;
		
		
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
	
	


	
	

	
	
}
