package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Inicial extends Pokemon {
	private PImage pokemonImagenAdelante,pokemonImagenAtras;
	
	public Inicial(String id,String delante,String atras, int posX,int posY,PApplet app) {
		super(id,delante, atras, posX,posY, app);
		this.pokemonImagenAdelante=app.loadImage(delante);
		this.pokemonImagenAtras=app.loadImage(atras);
		
	}
	
	
	
	
	public void pintar(PImage pokemonImagen) {
		app.image(pokemonImagen, posX, posY);
		
	}
	
	
	
	public void subirNivel() {
		
	}




	public PImage getPokemonImagenAdelante() {
		return pokemonImagenAdelante;
	}




	public void setPokemonImagenAdelante(PImage pokemonImagenAdelante) {
		this.pokemonImagenAdelante = pokemonImagenAdelante;
	}




	public PImage getPokemonImagenAtras() {
		return pokemonImagenAtras;
	}




	public void setPokemonImagenAtras(PImage pokemonImagenAtras) {
		this.pokemonImagenAtras = pokemonImagenAtras;
	}

	
	
	
}
