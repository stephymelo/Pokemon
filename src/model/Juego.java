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
	private Salvaje pokemonSalvaje;

	private LinkedList<Salvaje> pokemonCapturados;

	private int pintarPokemon;

	private int matX, matY;

	private double varCaptura;
	private boolean intentoCaptura;
	private int posXMatriz, posYMatriz;
	private int turno;
	private boolean ataque, ataqueRival;
	private boolean combate;

	private int mapa[][] = { { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, };

	public Juego(PApplet app) {
		this.app = app;

		jugador = new Jugador(app, 50, 150);
		pokemonCapturados = new LinkedList<Salvaje>();
		pokemonSalvaje = new Salvaje("wooloo", "./imagenes/pokemones/wooloo.png", "noexiste", 200, 200, app);

		this.posXMatriz = 100;
		this.posYMatriz = 50;

		this.matY = 0; // filas hacia abajo
		this.matX = 3; // columnas hacia horizantal

		this.varCaptura = 0;
		this.intentoCaptura = false;

		this.turno = 0;
		this.combate = false;
		this.ataque = false;
		this.ataqueRival = false;

	}

	public void jugadores() {
		jugador.pintarJugador();

	}

	public void caminar() {

		jugador.caminar(app);
		verificarJugador();

        
	}

	public void pintarMapa() {
		for (int fila = 0; fila < 16; fila++) {
			for (int col = 0; col < 12; col++) {
				app.fill(mapa[fila][col] == 0 ? 150 : mapa[fila][col] == 2 ? 100 : mapa[fila][col] == 1 ? 255 : 0);
				app.rect(col * 100, fila * 50, 100, 50);

//				if (mapa[fila][col] == 0) {
//					app.fill(0, 0, 0, 30);
//z
//				}
//				if (mapa[fila][col] == 1) {
//					app.fill(255, 255, 255,80);
//
//				}
//				if (mapa[fila][col] == 2) {
//					app.fill(255, 0, 0, 20);
//					
//
//				}

//				app.rect((col *posXMatriz), (fila * posYMatriz), 100, 50);
			}
		}

		jugadorPasto();
		

	}

	public void verificarJugador() {

		switch (app.keyCode) {

		case PConstants.LEFT:
			if (matY-1>=0) {
				if (mapa[matX][matY - 1] != 0) {
					matY -= 1;
					jugador.setPosX(jugador.getPosX() - 100);

				}
			}

			break;
		case PConstants.RIGHT:

//			System.out.println(matY + 1);
			if (matY + 1 < 12) {

				if (mapa[matX][matY + 1] != 0) {
					matY += 1;
					jugador.setPosX(jugador.getPosX() + 100);
				}

			}
			break;

		case PConstants.UP:
			if (matX - 1 > 0) {
				if (mapa[matX - 1][matY] != 0) {
					matX -= 1;
					jugador.setPosY(jugador.getPosY() - 100);
				}
			}
			break;
		case PConstants.DOWN:
			if (matX+1<16) {
				if (mapa[matX + 1][matY] != 0) {
					matX += 1;
					jugador.setPosY(jugador.getPosY() + 100);
					
				}
			}
			break;

		}
	}

	public void escogerGenero(int generoChoose) {
		jugador.setGenero(generoChoose);

	}

	public void jugadorPasto() {
		
		if(mapa[matX][matY]==2) {
			
		}
		

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 12; j++) {
				if ((jugador.getPosX() > (j * 50)+50 && jugador.getPosX() < (j * 50)+50
						&& jugador.getPosY() > (i * 50) - 50 && jugador.getPosY() < (i * 50) + 50) && mapa[i][j] == 2) {
					System.out.println("entro");
					pokemonSalvaje.setEnPasto(true);
					
			

				}
			}

		}

		if(pokemonSalvaje.isEnPasto()==true) {
			new Thread(pokemonSalvaje).start();
		}


	
	}

	public void verificarClicks() {

//		for (int i = 0; i < 16; i++) {
//		for (int j = 0; j < 12; j++) {
////		System.out.println("The max is: "+app.mouseX+"space"+app.mouseY+" at index ["+i+"]["+j+"]");
//		}

		System.out.println(app.mouseX + " " + app.mouseY);

	}

	public void escogerPokemon(String id) {
		if (id.toLowerCase().trim().equals("agua")) {

			this.pintarPokemon = 1;

			pokemonInicial = new Inicial(id, "./imagenes/pokemones/sobbleDelante.png",
					"./imagenes/pokemones/sobbleAtras.png", 10, 10, app);

		}
		if (id.toLowerCase().trim().equals("fuego")) {

			this.pintarPokemon = 2;

			pokemonInicial = new Inicial(id, "./imagenes/pokemones/scorbunnyDelante.png",
					"./imagenes/pokemones/scorbunnyAtras.png", 10, 10, app);

		}
		if (id.toLowerCase().trim().equals("hierba")) {

			this.pintarPokemon = 3;

			pokemonInicial = new Inicial(id, "./imagenes/pokemones/grookeyDelante.png",
					"./imagenes/pokemones/grookeyAtras.png", 10, 10, app);

		}

	}

	public void pintarPokemonInicial() {
		switch (pintarPokemon) {
		case 1:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());

			break;

		case 2:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());

			break;
		case 3:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());

			break;
		}

	}

	public void pintarPokemonInicialVS() {
		switch (pintarPokemon) {
		case 1:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAdelante());

			break;

		case 2:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAdelante());

			break;
		case 3:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAdelante());

			break;
		}
	}

	public void encontrarPokemon() {
		// if jugador en area sensible de pasto, jugador encuentra pokemon

		if (jugador.getPosX() < 8 && jugador.getPosY() < 460 && jugador.getPosX() > 420 && jugador.getPosY() > 750) {

			System.out.println("im in");
//			encuentroPokemon=true;
		}

	}

	public void randomicosDeCaptura() {

		// poner arreglo de pokemones (for) aquí

		if (this.intentoCaptura == true) {

			this.varCaptura = Math.floor(Math.random() * 100 + 1);

			// pokemon full vida
			if (this.pokemones.getVida() >= 20) {

				if (this.varCaptura >= 95) {

					// pokemon escapa del combate
				}

				if (this.varCaptura <= 94 && this.varCaptura >= 40) {

					// pokemon no es capturado
				}

				if (this.varCaptura < 40) {

					// pokemon es capturado
				}

			}

			// pokemon mitad de vida
			if (this.pokemones.getVida() < 5 && this.pokemones.getVida() >= 10) {

				if (this.varCaptura >= 97) {

					// pokemon escapa del combate
				}

				if (this.varCaptura <= 96 && this.varCaptura >= 70) {

					// pokemon no es capturado
				}

				if (this.varCaptura < 70) {

					// pokemon es capturado
				}

			}

			// pokemon poca vida
			if (this.pokemones.getVida() >= 5) {

				if (this.varCaptura >= 98) {

					// pokemon escapa del combate
				}

				if (this.varCaptura <= 97 && this.varCaptura >= 90) {

					// pokemon no es capturado
				}

				if (this.varCaptura < 90) {

					// pokemon es capturado
				}

			}
		}
	}

	public void ataqueDePokemon() {
		if (this.combate == true) {
			this.turno = 1;
			switch (turno) {
			case 1:
				if (this.ataque == true) {
//					this.pokemones.setVida(vida) = this.pokemones.setVida(vida) - this.pokemones.getDano();
					this.ataque = false;
					this.turno = 2;
				}
				break;
			case 2:
				this.ataqueRival = true;
				if (this.ataqueRival == true) {
//					this.pokemones.setVida(vida) = this.pokemones.setVida(vida) - this.pokemones.getDano();
					this.ataqueRival = false;
					this.turno = 1;
				}
				break;
			}
		}
	}

	public int getPosXMatriz() {
		return posXMatriz;
	}

	public void setPosXMatriz(int posXMatriz) {
		this.posXMatriz = posXMatriz;
	}

	public int getPosYMatriz() {
		return posYMatriz;
	}

	public void setPosYMatriz(int posYMatriz) {
		this.posYMatriz = posYMatriz;
	}

}
