package model;

import processing.core.PApplet;
import processing.core.PImage;

public class JugadorMujer extends Jugador {
	private PImage caminarMujer[];

	public JugadorMujer(PApplet app, int posX, int posY) {
		super(app, posX, posY);
        this.app=app;
		
		
		
		
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
	}
	

//	public void pintarJugadorCaminando() {
//		
//			switch(this.direc) {
//			case 1:
//			switch(this.camino) {
//			case 0:
//				app.image(caminarMujer[10],this.posX,this.posY);
//				this.camino++;
//				break;
//			case 1:
//				app.image(caminarMujer[11],this.posX,this.posY);
//			
//				break;
//			}
//				
//				break;
//			case 2:
//				switch(this.camino) {	
//			case 0:
//				app.image(caminarMujer[8],this.posX,this.posY);
//				this.camino++;
//				break;
//			case 1:
//				app.image(caminarMujer[9],this.posX,this.posY);
//				
//				break;
//				}
//			
//			case 3:
//				switch(this.camino) {
//			case 0:
//				app.image(caminarMujer[6],this.posX,this.posY);
//				this.camino++;
//				break;
//			case 1:
//				app.image(caminarMujer[7],this.posX,this.posY);
//				
//			
//				}
//			
//				
//				break;
//			case 4:
//				switch(this.camino) {
//				case 0:
//					app.image(caminarMujer[5],this.posX,this.posY);
//					this.camino++;
//					break;
//				case 1:
//					app.image(caminarMujer[4],this.posX,this.posY);
//					
//					break;
//					}
//				}
//	
//	}
			
			
		
		
	
	
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

}
