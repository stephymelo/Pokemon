package model;

import processing.core.PApplet;

import processing.core.PConstants;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import Exception.exceptionRival;
import Exception.exceptionCatch;
import model.Pokemon;

/**
 * POKEMON SWORD
 *
 * @author Stephanie, Natalia, Miguel
 */

public class Juego implements Runnable {
	private PApplet app;
	private static Jugador jugador;
	private static Rival rival;
	private Inicial pokemonInicial;
	private static Inicial pokemonRival;
	private static Salvaje pokemonSalvaje;
	private Salvaje pokemonSalvajeBatalla;
	private boolean pokemonCapturado;
	private String[] text;
	private Pokedex pokedex;
	private LinkedList<Pokedex> pokedexList;
	private PokedexTipo pokeOrd;
	private boolean verdeB;
	private PImage verde;
	private ArrayList<Pokemon> pokemonUsers;
	private int pintarPokemon;
	private int matX, matY;
	private boolean regresoBatalla;
	

	private int pantallaBatalla;
	private double varCaptura;
	private boolean intentoCaptura, intento;
	private int posXMatriz, posYMatriz;
	private int turno;
	private boolean ataque, ataqueRival, batallaHilo;
	private boolean encontroPokemon, mostrarPokemon, mostrarPoder, mapaScreen, combateRival, escapePokemon, showError;
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
		pantallaBatalla = 0;
		pokemonUsers = new ArrayList<Pokemon>();
		mostrarPokemon = true;
		regresoBatalla=false;
		mostrarPoder = false;
		intento = false;
		escapePokemon = false;
		showError = false;
		batallaHilo = false;
		this.mapaScreen = false;
		this.encontroPokemon = false;
		pokemonSalvaje = new Salvaje("wooloo", "./imagenes/pokemones/wooloo.png", "noexiste", 5, 450, app);
		pokemonSalvajeBatalla = null;
		pokemonCapturado = false;
		combateRival = false;
		this.rival = new Rival(app, 900, 200);
		this.posXMatriz = 100;
		this.posYMatriz = 50;
		
	

		// filas hacia abajo
		this.matY = 0;
		// columnas hacia horizantal
		this.matX = 3;
		this.varCaptura = 0;
		this.intentoCaptura = false;
		this.intento = false;
		this.pantallaBatalla = 0;
		this.turno = 0;
		this.ataque = false;
		this.ataqueRival = false;
		// POKEDEX
		pokedexList = new LinkedList<Pokedex>();
		pokeOrd = new PokedexTipo();

		verde = app.loadImage("./imagenes/Pokedex/Verde.png");

		text = app.loadStrings("./pokedexTXT/pokedex.txt");

		verdeB = false;

		for (int i = 0; i < text.length; i++) {
			String[] poketxt = text[i].split(" ");
			String nombre = poketxt[1];
			String tipo = poketxt[2];

			pokedexList.add(new Pokedex(nombre, tipo));

		}

	}

	// **************************************************
	// Public methods
	// **************************************************

	public void jugadores() {
		jugador.pintarJugador();
	}

	public void caminar() {
		jugador.caminar(app);
		verificarJugador();
	}

	/**
	 * Hilo de Batalla 
	 *
	 * 
	 */
	public void run() {
		

		if (batallaHilo == true) {
			try {

				turno = 0;
				System.out.println("probandoUno");

				if (ataque == true) {
					turno = 1;
					System.out.println("probandoDos");

				}
				Thread.sleep(3000);
				if (ataqueRival == true) {
					System.out.println("syso");
					turno = 2;

				}

//				pokemonInicial.nivel();
//				if (pokemonSalvajeBatalla.getVida() <= 0) {
//					pokemonInicial.setExperiencia(5);
//					pokemonCapturado = true;
//					pokemonSalvajeBatalla = null;
//					pokemonInicial = null;
//
//				}

			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

	}

	// BATALLA

	public void batalla() {
		vidaPokemon();

		if (batallaHilo == false) {
			turno = 0;
		}

		

		switch (turno) {

		case 1:

			if (ataque == true) {
				pokemonSalvajeBatalla.setVida(pokemonSalvajeBatalla.getVida() - pokemonInicial.getDano());
				mostrarPoder = false;
				ataque = false;
				ataqueRival = true;
				System.out.println(turno+"turno");
				
				
			}
			break;
		case 2:
			pokemonInicial.setVida(pokemonInicial.getVida() - pokemonSalvajeBatalla.getDano());
			ataqueRival = false;
			batallaHilo=false;
			System.out.println(batallaHilo+" SientrohilooDOS");

			break;

		}
		
	}

	public void pintarPokebola() {
		jugador.pokebola();
		PImage pokemonUno = null;
		

		switch (pintarPokemon) {
		case 1:
			pokemonUno = app.loadImage("./imagenes/pokemones/sobbleDelante.png");
			break;
		case 2:
			pokemonUno = app.loadImage("./imagenes/pokemones/scorbunnyDelante.png");
			break;
		case 3:
			pokemonUno = app.loadImage("./imagenes/pokemones/grookeyDelante.png");
			break;
		}

		app.image(pokemonUno, 1000, 55, 80, 50);
		
		if(pokemonCapturado) {
			pokemonUno = app.loadImage("./imagenes/pokemones/wooloo.png");
			app.image(pokemonUno, 1100, 55, 80, 50);
			
		}
		


		
	}

	public void batallaPintar() {
		
		
		
		
		if (mostrarPokemon) {
			pokemonSalvajeBatalla.pintar(pokemonSalvajeBatalla.getPokemonImagenAdelante());
			pokemonSalvajeBatalla.setDano(20);
			app.fill(0);
			app.text("Wooloo" + " " + " " + "2 LV", 110, 145);
		} else {

		}
		
		if(pokemonSalvajeBatalla.getVida()<=0) {
			pokemonSalvajeBatalla.morir();
			
		}
		if (escapePokemon) {
			pokemonSalvajeBatalla.escape();
		}
		
		pintarPokemonInicial();
		pokemonInicial.nivel();

	}

	public void vidaPokemon() {
		pokemonSalvajeBatalla.mostrarVida(250, 155);
		pokemonInicial.mostrarVida(852, 468);
	}

	public void pintarPokemonSalvaje() {
		jugadorPasto();
		pokemonSalvaje.pintar(this.pokemonSalvaje.getPokemonImagenAdelante());

		if (pokemonSalvaje.isEnPasto() == true) {
			new Thread(pokemonSalvaje).start();
		}
	}

	public void pintarMapa() {
		for (int fila = 0; fila < 16; fila++) {
			for (int col = 0; col < 12; col++) {
				app.fill(mapa[fila][col] == 0 ? 150 : mapa[fila][col] == 2 ? 100 : mapa[fila][col] == 1 ? 255 : 0);
				app.rect(col * 100, fila * 50, 100, 50);

			}
		}

	}

	public void escogerGenero(int generoChoose) {
		jugador.setGenero(generoChoose);

	}

	public void verificarJugador() {
		switch (app.keyCode) {
		case PConstants.LEFT:
			if (matY - 1 >= 0) {
				if (mapa[matX][matY - 1] != 0) {
					matY -= 1;
					jugador.setPosX(jugador.getPosX() - 100);
				}
			}
			break;
		case PConstants.RIGHT:
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
			if (matX + 1 < 16) {
				if (mapa[matX + 1][matY] != 0) {
					matX += 1;
					jugador.setPosY(jugador.getPosY() + 100);
				}
			}
			break;
		}
	}

	public void jugadorPasto() {
		pokemonSalvaje.setEnPasto(true);
		if (pokemonSalvaje.getPosY() < 450 + 100) {
			pokemonSalvaje.setDirY(1);
		}
		if (pokemonSalvaje.getPosY() > 748 - 100) {
			pokemonSalvaje.setDirY(-1);
		}
		if (pokemonSalvaje.getPosX() > 395 - 100) {
			pokemonSalvaje.setDirX(-1);
		}

		if (pokemonSalvaje.getPosX() < 5 + 100) {
			pokemonSalvaje.setDirX(1);
		}

	}

	public void pintarRival() {
		this.rival.pintar();
	}

	// Encontrar Pokemon en el pasto
	public void encontrarPokemon() {
		if (PApplet.dist(jugador.getPosX(), jugador.getPosY(), pokemonSalvaje.getPosX(),
				pokemonSalvaje.getPosY()) < 100) {
			encontroPokemon = true;

		}
		if (encontroPokemon == true) {
			pokemonSalvaje.setEnPasto(false);
			if (pokemonSalvajeBatalla == null) {
				pokemonSalvajeBatalla = new Salvaje("wooloo", "./imagenes/pokemones/wooloo.png", "noexiste", 850, 250,
						app);
			}
		}
	}

	
	// TODO aca se verifican clicks
	public void verificarClicks() {
		System.out.println(batallaHilo+"hiloo");
		
		// fight
		if (PApplet.dist(app.mouseX, app.mouseY, 700, 650) < 100 && turno == 0 && mostrarPoder == false) {
			mostrarPoder = true;
			return;
		}

		// poder
		if (PApplet.dist(app.mouseX, app.mouseY, 800, 680) < 100 && turno == 0 && mostrarPoder == true) {
			
			ataque = true;
			batallaHilo = true;
			
			
		}
		
		if (PApplet.dist(app.mouseX, app.mouseY, pokemonInicial.getPosX(), pokemonInicial.getPosY()) < 100 && pokemonSalvajeBatalla.getVida()==0) {
			pokemonInicial.setExperiencia(5);
			
		}

		if (PApplet.dist(app.mouseX, app.mouseY, 957, 620) < 100 && turno == 0) {
			randomicosDeCaptura();
		}
		if (app.mouseX > 950 && app.mouseX < 950 + 100 && app.mouseY > 670 && app.mouseY < 670 + 100
				&& pokemonCapturado == true) {
			mapaScreen = true;
			pantallaBatalla = 0;
			pokemonCapturado = true;
			pokemonInicial.setVida(250);
			
			
		}
	}

	public void verificarClicksMapa() {
		System.out.println(mostrarPokemon + "poke");
		
//		if(pokemonCapturado = true) {
		try {
			if (app.mouseX > 860 && app.mouseX < 930 && app.mouseY > 130 && app.mouseY < 260) {
				combateRival = true;
				regresoBatalla=true;
				
			}
			throw new exceptionRival("no capturaste");
		} catch (exceptionRival e) {
			System.out.println(e.getMessage());
		}
		}
	

	public void pokeAtaque() {
		app.fill(255);
		app.textSize(50);
		if (turno == 1) {
			switch (pintarPokemon) {
			case 1:
				app.text("Sobble used bubbles", 100, 660);
				break;
			case 2:
				app.text("Scorbunny used Ember", 100, 660);
				break;
			case 3:
				app.text("Grookey used Leach", 100, 660);
				break;
			}
		}

	}

	// Seleccionar poder del pokemon para atacar
	public void poder() {
		if (mostrarPoder) {
			app.textSize(80);
			app.fill(248, 248, 248);
			app.rect(630, 590, 513, 170);
			switch (pintarPokemon) {
			case 1:
				app.fill(90, 136, 255);
				app.text("Watergun", 700, 700);
				break;
			case 2:
				app.fill(255, 83, 83);
				app.text("Ember", 700, 700);
				break;
			case 3:
				app.fill(174, 255, 168);
				app.text("LeachSeed", 700, 700);
				break;
			}
		}
	}
	
	/**
	 * Recibe el id del intro.
	 *
	 * Crea un pokemon y lo agrega al arreglo
	 */
	
	public void escogerPokemon(String id) {
		ArrayList<Pokemon> pokemonTemporal = new ArrayList<Pokemon>();
		pokemonTemporal = jugador.getPokemonCapturados();
		if (id.trim().equals("Sobble")) {
			this.pintarPokemon = 1;
			pokemonInicial = new Inicial(id, "./imagenes/pokemones/sobbleDelante.png",
					"./imagenes/pokemones/sobbleAtras.png", 277, 430, app);
			pokemonTemporal.add(new Inicial(id, "./imagenes/pokemones/sobbleDelante.png",
					"./imagenes/pokemones/sobbleAtras.png", 277, 430, app));
			// pokemon rival
			pokemonRival = new Inicial(id, "./imagenes/pokemones/grookeyDelante.png",
					"./imagenes/pokemones/grookeyAtras.png", 875, 200, app);
		}
		if (id.trim().equals("Scorbunny")) {
			this.pintarPokemon = 2;
			pokemonInicial = new Inicial(id, "./imagenes/pokemones/scorbunnyDelante.png",
					"./imagenes/pokemones/scorbunnyAtras.png", 277, 430, app);
			pokemonTemporal.add(new Inicial(id, "./imagenes/pokemones/scorbunnyDelante.png",
					"./imagenes/pokemones/scorbunnyAtras.png", 277, 430, app));

			// pokemon rival
			pokemonRival = new Inicial(id, "./imagenes/pokemones/sobbleDelante.png",
					"./imagenes/pokemones/sobbleAtras.png", 875, 200, app);
		}
		if (id.trim().equals("Grookey")) {
			this.pintarPokemon = 3;
			pokemonInicial = new Inicial(id, "./imagenes/pokemones/grookeyDelante.png",
					"./imagenes/pokemones/grookeyAtras.png", 277, 430, app);

			pokemonTemporal.add(new Inicial(id, "./imagenes/pokemones/grookeyDelante.png",
					"./imagenes/pokemones/grookeyAtras.png", 277, 430, app));

			// pokemon rival
			pokemonRival = new Inicial(id, "./imagenes/pokemones/scorbunnyDelante.png",
					"./imagenes/pokemones/scorbunnyAtras.png", 850, 175, app);

		}

	}

	// PINTAR POKEMON INICIAL DEL JUGADOR

	public void pintarPokemonInicial() {
		app.fill(0);
		app.text(pokemonInicial.getId(), 700, 440);
		app.text(pokemonInicial.getNivel() + "LV", 1000, 440);
		switch (pintarPokemon) {
		case 1:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
			pokemonInicial.setDano(25);

			break;

		case 2:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
			pokemonInicial.setDano(30);

			break;
		case 3:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
			pokemonInicial.setDano(20);

			break;
		}
	}

	// PINTAR POKEMON INICIAL DE RIVAL

	public void pintarPokemonInicialVS() {
		switch (pintarPokemon) {
		case 1:
			pokemonRival.pintar(this.pokemonRival.getPokemonImagenAdelante());
			pokemonRival.setDano(20);
			app.fill(0);	
			app.text("Grookey", 100, 140);
			app.text(pokemonRival.getNivel() + "LV", 400, 140);

			break;

		case 2:
			pokemonRival.pintar(this.pokemonRival.getPokemonImagenAdelante());
			pokemonRival.setDano(25);
			app.fill(0);
			app.text("Sobble", 100, 140);
			app.text(pokemonRival.getNivel() + "LV", 400, 140);

			break;
		case 3:
			pokemonRival.pintar(this.pokemonRival.getPokemonImagenAdelante());
			pokemonRival.setDano(30);
			app.fill(0);
			app.text("Scorbunny", 100, 140);
			app.text(pokemonRival.getNivel() + "LV", 400, 140);

			break;
		}
	}

	/**
	 * Arroja un numero randomico.
	 *
	 * Numero decide si capturaste
	 */
	public void randomicosDeCaptura() {

		ArrayList<Pokemon> pokemonTemporal = new ArrayList<Pokemon>();
		this.varCaptura = Math.floor(Math.random() * 100 + 1);
		if (pokemonSalvajeBatalla.getVida() >= 10) {
			// CAPTURASTE
			if (this.varCaptura < 34) {
				pokemonTemporal = jugador.getPokemonCapturados();
				pantallaBatalla = 2;
				mostrarPokemon = false;
				pokemonCapturado = true;
				pokemonInicial.setExperiencia(5);
				pokemonTemporal.add(new Salvaje("wooloo", "./imagenes/pokemones/wooloo.png", "noexiste", 5, 450, app));
				System.out.println(varCaptura + "captura");
			}
			try {
				if (this.varCaptura >= 97) {
					System.out.println(varCaptura + "Fight");
				}
				throw new exceptionCatch("No capturaste");
			} catch (exceptionCatch e) {
				showError = true;
				System.out.println(e.getMessage());
			}

			if (this.varCaptura >= 34 && this.varCaptura <= 67) {
				pantallaBatalla = 1;
				pokemonCapturado = true;
				pokemonInicial.setExperiencia(5);
				escapePokemon = true;
				System.out.println(varCaptura + "escape");
			}
		}
	}

	// POKEDEX

	public void pintarPokedex() {
		app.fill(86, 89, 85);
		app.textSize(60);
		for (int i = 0; i < pokedexList.size(); i++) {
			Pokedex poke = pokedexList.get(i);
			app.text(poke.getNombre(), 735, 150 + (i * 68));

		}

		if (verdeB == true) {
			app.image(verde, 202, 227);
		}
	}

	public void mouseLogica() {
		if (app.mousePressed == true) {
			// for (int i = 0; i < pokedex.getNombre().pokedexList.size(); i++) {

			if (pokedexList.get(0).getNombre().equals("Grockey")) {
				verdeB = true;

			}
		}
	}

	public void OrdenarTipo() {
		Collections.sort(pokedexList, pokeOrd);
	}

	public void OrdenarNombre() {
		Collections.sort(pokedexList);
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

	public boolean isEncontroPokemon() {
		return encontroPokemon;
	}

	public void setEncontroPokemon(boolean encontroPokemon) {
		this.encontroPokemon = encontroPokemon;
	}

	public boolean isMapaScreen() {
		return mapaScreen;
	}

	public void setMapaScreen(boolean mapaScreen) {
		this.mapaScreen = mapaScreen;
	}

	public int getPantallaBatalla() {
		return pantallaBatalla;
	}

	public void setPantallaBatalla(int pantallaBatalla) {
		this.pantallaBatalla = pantallaBatalla;
	}

	public boolean isRegresoBatalla() {
		return regresoBatalla;
	}

	public void setRegresoBatalla(boolean regresoBatalla) {
		this.regresoBatalla = regresoBatalla;
	}

	public boolean isCombateRival() {
		return combateRival;
	}

	public void setCombateRival(boolean combateRival) {
		this.combateRival = combateRival;
	}
	
	

}
