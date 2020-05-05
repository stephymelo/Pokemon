package controller;

import model.Juego;

import processing.core.PApplet;

public class MapaController {
	private PApplet app;
	private Juego juego;
	
	
	public MapaController(PApplet app) {
		this.app=app;
		juego=new Juego(app);
		
	}
	
	public void pintarJugador() {
		juego.jugadores();
		
	}
	public void caminarJugadorTop() {
		juego.jugadorCaminar();
	
		
	}
}
