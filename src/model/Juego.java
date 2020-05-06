package model;

import processing.core.PApplet;

public class Juego {
	private PApplet app;
	private JugadorMujer jugador;
	
	public Juego(PApplet app) {
		this.app=app;
		jugador=new JugadorMujer(app,50,50);
	}
	
	public void jugadores() {
		jugador.pintarJugador();
		
		
		

		
	}
	public void caminar() {
		jugador.caminar(app);
	}
	
	public void jugadorCaminar() {
		jugador.caminarDos(app);
		
	}
	
	
	public void encontrarPokemon() {
		//if jugador en area sensible de pasto, jugador encuentra pokemon
	}
	
	
  
}
