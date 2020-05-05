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
		jugador.caminar(app);

		
	}
	
	public void jugadorCaminar() {
		jugador.pintarJugadorCaminando();
		jugador.caminarDos(app);
		
	}
	
  
}
