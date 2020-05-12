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
		
		if(jugador.getPosX()<8&&jugador.getPosY()<460&&jugador.getPosX()>420&&
				jugador.getPosY()>750) {
			
			System.out.println("im in");
//			encuentroPokemon=true;
		}
		
		
		
		
		
		
		
	}
	
	
  
}
