package controller;

import model.Juego;
import processing.core.PApplet;

public class ControllerMain {
	private Juego juego;
	private PApplet app;
	
	
	public ControllerMain(PApplet app,Juego juego) {
		this.app=app;
		this.juego = juego;
	}
	
	
	
	public void escogerPokemon(String id) {
		juego.escogerPokemon(id);
	}
	
	public void pintarPokemon() {
	
	}
	
	
	
	public void verificarClicks() {
		juego.verificarClicks();
	}
	

}
