package controller;

import model.Juego;
import processing.core.PApplet;

public class ControllerMain {
	private Juego juego;
	private PApplet app;
	public ControllerMain(PApplet app) {
		this.app=app;
		this.juego = new Juego(app);
	}
	
	
	
	public void escogerPokemon(String id) {
		juego.escogerPokemon(id);
	}
	
	public void pintarPokemon() {
	
	}
	

}
