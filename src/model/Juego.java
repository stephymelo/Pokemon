package model;

import processing.core.PApplet;

public class Juego {
	private PApplet app;
	private JugadorMujer jugador;
	private int pintarPokemon;
	private boolean camino;
	
	private int mapa[][]={{0,0,0,0,0,0,1,1,0,0,0,0},
			              {0,0,0,0,0,0,1,1,0,0,0,0},
			              {0,0,0,0,0,0,1,1,0,0,0,0}, 
			              {1,1,1,1,1,1,1,1,1,1,1,1},
			              {1,1,1,1,1,1,1,1,1,1,1,1},
			              {1,1,1,1,1,1,1,1,1,1,1,1},
			              {1,1,1,1,1,1,1,1,1,1,1,1},
			              {1,1,1,1,1,1,1,1,1,1,1,1},
			              {1,1,1,1,1,1,1,1,1,1,1,1},
			              {2,2,2,2,1,1,2,2,2,2,2,2},
			              {2,2,2,2,1,1,2,2,2,2,2,2},
			              {2,2,2,2,1,1,2,2,2,2,2,2},
			              {2,2,2,2,1,1,2,2,2,2,2,2},
			              {2,2,2,2,1,1,2,2,2,2,2,2},
			              {2,2,2,2,1,1,2,2,2,2,2,2},
			              {0,0,0,0,1,1,0,0,0,0,0,0},
			              };
	
	
	public Juego(PApplet app) {
		this.app=app;
		
		jugador=new JugadorMujer(app,50,50);
		this.pintarPokemon=0;
		this.camino=false;
		
		

      	
		
		
		
	}
	
	public void jugadores() {
		jugador.pintarJugador();
		
		
		

		
	}
	
	
	
	
	
	
	
	public void pintarMapa() {
		for (int fila = 0; fila < 16; fila++) {
			for (int col = 0; col < 12; col++) {
				if (mapa[fila][col] == 0) {
					app.fill(0,0,0,30);
				
				}
				if (mapa[fila][col] == 1) {
					app.fill(255,255,255);
					
				}
				if (mapa[fila][col] == 2) {
					app.fill(255,0,0,20);
					
				}
				
//				app.noStroke();
				app.rect((col * 100), (fila * 50), 100, 50);
			}
		}

		
	}
	
	
	
	
	public void caminar() {
	
		jugador.caminar(app);
		
	}
	
	public void jugadorCaminar() {
		
			jugador.caminarDos(app);
			
		
		
	}
	
	
	
	
	public void escogerPokemon(String id) {
		if(id.contentEquals("agua")) {
			this.pintarPokemon=1;
			
		}
		
	}
	
	public void pintarPokemonInicial() {
		switch(pintarPokemon) {
		case 1:
			app.ellipse(100, 100, 200, 300);
			break;
		}
		

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
