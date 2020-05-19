package model;

import processing.core.PApplet;
import processing.core.PConstants;

import java.util.LinkedList;

import model.Pokemon;

public class Juego {
	private PApplet app;
	private Jugador jugador;
	private Pokemon pokemones;
	private Inicial pokemonInicial;
//	private LinkedList <Pokemon>pokemonInicial;
	
	private int pintarPokemon;
	
	private int matX, matY;
	
	private double varCaptura;
	private boolean intentoCaptura;
	
	private int turno;
	private boolean ataque, ataqueRival;
	private boolean combate;

	private int mapa[][] = { 
			{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, 
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, 
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, 
			{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, };

	public Juego(PApplet app) {
		this.app = app;

		jugador = new Jugador(app, 50, 50);
//		pokemonInicial=new LinkedList<Pokemon>();

	
		


		
		this.matY = 4;
		this.matX = 1;



		this.varCaptura = 0;
		this.intentoCaptura = false;
		
		this.turno = 0;
		this.combate = false;
		this.ataque =false;
		this.ataqueRival =false;

	}

	public void jugadores() {
		jugador.pintarJugador();

	}

	public void pintarMapa() {
		for (int fila = 0; fila < 16; fila++) {
			for (int col = 0; col < 12; col++) {
				if (mapa[fila][col] == 0) {
					app.fill(0, 0, 0, 30);

				}
				if (mapa[fila][col] == 1) {
					app.fill(255, 255, 255);

				}
				if (mapa[fila][col] == 2) {
					app.fill(255, 0, 0, 20);

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
			    jugador.setPosX(-10);
			

			}

		}

		if (app.keyCode == PConstants.RIGHT) {
			if (matY + 1 < 20 && mapa[matY + 1][matX] != 0) {
				matY += 1;
				
				jugador.setPosX(10);

			}

		}

		if (app.keyCode == PConstants.UP) {
			if (matX + 1 < 12 && mapa[matY][matX + 1] != 0) {
				matX -= 1;
			jugador.setPosY(-10);

		}
		}

			

		if (app.keyCode == PConstants.DOWN) {
			if (matX + 1 < 12 && mapa[matY][matX + 1] != 0) {
				matX += 1;
				jugador.setPosY(10);

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
		if (id.toLowerCase().trim().equals("agua")) {
			
			this.pintarPokemon = 1;
			System.out.println("alo");
			pokemonInicial=new Inicial(id,"./imagenes/sobbleAtras.png","./imagenes/sobbleDelante.png",10,10,app);
			

			

		}

	}

	public void pintarPokemonInicial() {
		switch (pintarPokemon) {
		case 1:
		
            pokemonInicial.setDeltante("./imagenes/sobbleAtras.png");
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAdelante());
//			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAdelante());
//				

			break;
			
		case 2:
			break;
		case 3:
			break;
		}

	}
	
	
	public void pintarenBatalla() {
//		pokemonInicial.pintar(this.pokemoInical.getPokemonImagenAtras(),10,10);
	}
	

	public void encontrarPokemon() {
		// if jugador en area sensible de pasto, jugador encuentra pokemon

		if (jugador.getPosX() < 8 && jugador.getPosY() < 460 && jugador.getPosX() > 420 && jugador.getPosY() > 750) {

			System.out.println("im in");
//			encuentroPokemon=true;
		}

	}

	public void randomicosDeCaptura() {
		
		//poner arreglo de pokemones (for) aquí

		if(this.intentoCaptura == true) {
			
			this.varCaptura = Math.floor(Math.random() * 100 + 1);
			
			//pokemon full vida
			if(this.pokemones.getVida() >= 20) {
				
				if(this.varCaptura >= 95) {
					
					//pokemon escapa del combate
				}
				
				if(this.varCaptura <= 94 && this.varCaptura >= 40) {
					
					//pokemon no es capturado
				}
				
				if(this.varCaptura < 40) {
					
					//pokemon es capturado
				}
				
			}
			
			//pokemon mitad de vida
			if(this.pokemones.getVida() < 5 && this.pokemones.getVida() >= 10 ) {
				
				if(this.varCaptura >= 97) {
					
					//pokemon escapa del combate
				}
				
				if(this.varCaptura <= 96 && this.varCaptura >= 70) {
					
					//pokemon no es capturado
				}
				
				if(this.varCaptura < 70) {
					
					//pokemon es capturado
				}
				
			}
			
			//pokemon poca vida
			if(this.pokemones.getVida() >= 5) {
				
				if(this.varCaptura >= 98) {
					
					//pokemon escapa del combate
				}
				
				if(this.varCaptura <= 97 && this.varCaptura >= 90) {
					
					//pokemon no es capturado
				}
				
				if(this.varCaptura < 90) {
					
					//pokemon es capturado
				}
				
			}
		}	
	}
	
	public void ataqueDePokemon() {
		if (this.combate == true) {
			this.turno = 1;
			switch (turno) {
			case 1:
				if(this.ataque == true) {
//					this.pokemones.setVida(vida) = this.pokemones.setVida(vida) - this.pokemones.getDano();
					this.ataque = false;
					this.turno = 2;
				}
				break;
			case 2:
				this.ataqueRival = true;
				if(this.ataqueRival == true) {
//					this.pokemones.setVida(vida) = this.pokemones.setVida(vida) - this.pokemones.getDano();
					this.ataqueRival = false;
					this.turno = 1;
				}
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
