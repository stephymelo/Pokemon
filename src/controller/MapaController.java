package controller;

import model.Juego;

import processing.core.PApplet;

public class MapaController {
	private PApplet app;
	private Juego juego;

	
	public MapaController(PApplet app,Juego juego) {
//		app.imageMode(app.CENTER);
		this.app=app;
		this.juego=juego;
		
	}
	
	public void pintarJugador() {
		juego.jugadores();
		 juego.pintarPokemonSalvaje();
	
	
		
		
		
	}
	public void caminar() {
		juego.caminar();
	}
	
	
	
	public void pintarMapa() {
        juego.pintarMapa();
        juego.encontrarPokemon();
       
    	
       
	}
	
	
}
