package model;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Pokemon  {
	protected PApplet app;
	protected int posX,posY;
	protected int dano;
	protected int experiencia,nivel;
	protected float vida;
	protected String id;
	protected String deltante,atras;
//	protected PImage pokemonImagenAdelante,pokemonImagenAtras;
	
	
	public Pokemon(String id,String delante,String atras, int posX,int posY,PApplet app) {
		this.id=id;
		this.posX=posX;
		this.posY=posY;
		this.vida=250;
		this.app=app;
		this.experiencia=experiencia;
		this.nivel=nivel;
		
		
//		
//		this.pokemonImagenAdelante=app.loadImage(delante);
//		this.pokemonImagenAtras=app.loadImage(atras);
		
		
	}
	
//	public void pintar(PImage pokemonImagen) {
//		app.image(pokemonImagen, posX, posY);
//		
//	}
	
	
	
	
	
	
	public void mostrarVida(int posX, int posY) {
		app.fill(96, 209, 126);
		app.noStroke();
		app.rect(posX,posY,vida, 20);
		if(vida<=0) {
			vida=0;
		}
		
	}
	
	public void nivel() {
		if(experiencia>=5) {
			nivel++;
			experiencia=0;
			
		}
		
	}
	
	
	
	
	public void atacar() {
		
	}
	
	public void morir() {
		
	}
	
	public void defensa() {
		
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

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public float getVida() {
		return vida;
	}

	public void setVida(float vida) {
		this.vida = vida;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getDeltante() {
		return deltante;
	}

	public void setDeltante(String deltante) {
		this.deltante = deltante;
	}

	public String getAtras() {
		return atras;
	}

	public void setAtras(String atras) {
		this.atras = atras;
	}

	
	

}
