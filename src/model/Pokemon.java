package model;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Pokemon  {
	protected PApplet app;
	protected int posX,posY;
	protected int dano;
	protected float vida;
	protected String id;
	protected String deltante,atras;
//	protected PImage pokemonImagenAdelante,pokemonImagenAtras;
	
	
	public Pokemon(String id,String delante,String atras, int posX,int posY,PApplet app) {
		this.id=id;
		this.posX=posX;
		this.posY=posY;
		this.vida=400;
		this.app=app;
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
		app.rect(posX,posY,vida, 20);
		
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

//	public PImage getPokemonImagenAdelante() {
//		return pokemonImagenAdelante;
//	}
//
//	public void setPokemonImagenAdelante(PImage pokemonImagenAdelante) {
//		this.pokemonImagenAdelante = pokemonImagenAdelante;
//	}
//
//	public PImage getPokemonImagenAtras() {
//		return pokemonImagenAtras;
//	}
//
//	public void setPokemonImagenAtras(PImage pokemonImagenAtras) {
//		this.pokemonImagenAtras = pokemonImagenAtras;
//	}

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

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	
	
	

}
