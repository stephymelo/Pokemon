package model;

import processing.core.PApplet;

public class Juego {
	private PApplet app;
	private Jugador jugador;
	
	public Juego(PApplet app) {
		this.app=app;
		jugador=new Jugador(app,50,50);
	}
	
	public void jugadores() {
		jugador.pintarJugador();
		jugador.pintarJugadorCaminando();
		jugador.caminarDos(app);
		

		
	}
	public void caminar() {
		jugador.caminar(app);
	}
	
	public void jugadorCaminar() {
	
		
	}
	
  
}
