package controller;

import model.Juego;

import processing.core.PApplet;

public class MapaController {
	private PApplet app;
	private Juego juego;

	
	public MapaController(PApplet app,Juego juego) {
		this.app=app;
		this.juego=juego;
		
	}
	
	public void pintarJugador() {
		juego.jugadores();
		juego.encontrarPokemon();
		juego.pintarPokemonInicial();
	
		
		
		
	}
	public void caminar() {
		juego.caminar();
	}
	public void caminarJugadorTop() {
		juego.jugadorCaminar();
		
	
		
	}
	
	
	public void pintarMapa() {
        juego.pintarMapa();
    	
       
	}
	
	
}
