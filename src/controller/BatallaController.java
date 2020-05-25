package controller;

import model.Juego;
import processing.core.PApplet;

public class BatallaController {
	
	private Juego juego;
	private PApplet app;
	
	public BatallaController(PApplet app,Juego juego) {
		this.app=app;
		this.juego = juego;
		
	}
	
	
	public void pintar() {
		juego.batallaPintar();
		
		
	}
	public void pintarPoder() {
		juego.poder();
		juego.vidaPokemon();
		juego.batalla();
		juego.pokeAtaque();
	}

	
	
	
}
