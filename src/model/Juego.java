package model;

import processing.core.PApplet;
import processing.core.PConstants;

public class Juego {
	private PApplet app;
	private JugadorMujer jugador;
	private int pintarPokemon;
	private boolean camino;
	private String id;
	private int matX,matY;
	private int posXJugador;
	
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
		this.id=id;		
		this.matY = 4;
		this.matX = 1;
		
		this.posXJugador=this.jugador.getPosX();
		this.jugador.getPosY();

      	
		
		
		
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
	
	public void verificarJugador() {
	
			if (app.keyCode == PConstants.LEFT) {
				if (matY - 1 > -1 && mapa[matY - 1][matX] != 0) {
					matY -= 1;
					this.posXJugador-=10;
					
				
					
				}

			}

			if (app.keyCode == PConstants.RIGHT) {
				if (matY + 1 < 20 && mapa[matY + 1][matX] != 0) {
					matY += 1;
					posXJugador+=10;
					
				}

			}

			if (app.keyCode == PConstants.UP) {
System.out.println("alo");
					
					
				}

//			}

			if (app.keyCode == PConstants.DOWN) {
				if (matX + 1 < 12 && mapa[matY][matX + 1] != 0) {
					matX += 1;
					

				}

			}
		}
		

		
		

		
	
	
	
	
	
	public void caminar() {
	
		jugador.caminar(app);
		verificarJugador();
		
	}
	
	public void jugadorCaminar() {
		
			jugador.caminarDos(app);
			
		
		
	}
	
	public void verificarClicks() {
//		for (int fila = 0; fila < 16; fila++) {
//			for (int col = 0; col < 12; col++) {
//		System.out.println(mapa[fila][col]);
//			}
//		}
	}
	
	
	
	
	public void escogerPokemon(String id) {
		if(id.equals("agua")) {
			app.ellipse(100, 100, 200, 300);
			this.pintarPokemon=1;
			System.out.println("alo");
			
		}
		
	}
	
	public void pintarPokemonInicial() {
		switch(pintarPokemon) {
		case 1:
			app.fill(255);
			app.ellipse(100, 100, 200, 300);
			
			System.out.println("entro");
			
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
