package model;

import processing.core.PApplet;
import processing.sound.*;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;
import processing.sound.SoundFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import model.Pokemon;

public class Juego implements Runnable {
	private PApplet app;
	private Jugador jugador;
	private Jugador jugadorBatalla;
	private Rival rival;
	private Pokemon pokemones;
	private Inicial pokemonInicial;
	private Inicial pokemonRival;
	private Salvaje pokemonSalvaje;
	private Salvaje pokemonSalvajeBatalla;

	private String[] text;
	private Pokedex pokedex;
	private LinkedList<Pokedex> pokedexList;
	private PokedexTipo pokeOrd;
	private boolean verdeB;

	private PImage verde;

	private ArrayList<Pokemon> pokemonUsers;

	private int pintarPokemon;

	private int matX, matY;
	private SoundFile musicaFondo;

	private int pantallaBatalla;

	private double varCaptura;
	private boolean intentoCaptura;
	private int posXMatriz, posYMatriz;
	private int turno;
	private boolean ataque, ataqueRival, batallaHilo;
	private boolean combate, combateRival;
	private boolean encontroPokemon, mostrarPokemon, atacando, mostrarPoder;

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

		// musicaFondo = new SoundFile(app, "./sonidos/mapaMusic.mp3");

		jugador = new Jugador(app, 50, 150);
        pantallaBatalla=0;
		pokemonUsers = new ArrayList<Pokemon>();
		mostrarPokemon = true;
		mostrarPoder = false;
		batallaHilo = false;
		this.encontroPokemon = false;
		pokemonSalvaje = new Salvaje("wooloo", "./imagenes/pokemones/wooloo.png", "noexiste", 5, 450, app);
		pokemonSalvajeBatalla = null;

		this.rival = new Rival(app, 900, 200);
		this.posXMatriz = 100;
		this.posYMatriz = 50;

		// filas hacia abajo
		this.matY = 0;
		// columnas hacia horizantal
		this.matX = 3;

		this.varCaptura = 0;
		this.intentoCaptura = false;
		this.pantallaBatalla = 0;
		this.turno = 0;
		this.combate = false;
		this.ataque = false;
		this.ataqueRival = false;
		this.atacando = false;

		// POKEDEX
		pokedexList = new LinkedList<Pokedex>();
		pokeOrd = new PokedexTipo();

		verde = app.loadImage("../imagenes/Pokedex/Verde.png");

		text = app.loadStrings("../pokedexTXT/pokedex.txt");

		verdeB = false;

		for (int i = 0; i < text.length; i++) {
			String[] poketxt = text[i].split(" ");
			String nombre = poketxt[1];
			String tipo = poketxt[2];

			pokedexList.add(new Pokedex(nombre, tipo));

		}

	}

	public void jugadores() {
		jugador.pintarJugador();

	}

	public void caminar() {

		jugador.caminar(app);
		verificarJugador();

	}

	public void vidaPokemon() {
		pokemonSalvajeBatalla.mostrarVida(250, 155);
		pokemonInicial.mostrarVida(852, 468);
	}

	public void run() {
//		
//		try {
//			musicaFondo.play();
//			musicaFondo.amp(-1);
//			Thread.sleep(500);
//			
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//			
//		}

		if (batallaHilo == true) {
			try {
				pokemonInicial.nivel();
				if (pokemonSalvajeBatalla.getVida() <= 0) {
					pokemonInicial.setExperiencia(5);

				}

				turno = 0;

				if (this.ataque == true) {
					turno = 1;

				}
				Thread.sleep(3000);
				if (ataqueRival == true) {

					turno = 2;

				}
				if (pokemonInicial.getExperiencia() == 5) {
					pokemonInicial.setExperiencia(0);
					combate = false;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

	}

	public void batalla() {
		if (combate == true) {
			if (batallaHilo == false) {
				turno = 0;
			}

			vidaPokemon();

			switch (turno) {

			case 1:

				if (ataque == true) {

					pokemonSalvajeBatalla.setVida(pokemonSalvajeBatalla.getVida() - pokemonInicial.getDano());
					mostrarPoder = false;
					ataque = false;
					ataqueRival = true;
				}
				break;
			case 2:
				pokemonInicial.setVida(pokemonInicial.getVida() - 20);
				ataqueRival = false;
				batallaHilo = false;

				break;

			case 3:

			}
		}

	}

	public void batallaRival() {

		if (combateRival == true) {
			if (batallaHilo == false) {
				turno = 0;
			}

			vidaPokemon();

			switch (turno) {

			case 1:

				if (ataque == true) {

					pokemonRival.setVida(pokemonRival.getVida() - pokemonInicial.getDano());
					mostrarPoder = false;
					ataque = false;
					ataqueRival = true;
				}
				break;
			case 2:
				pokemonInicial.setVida(pokemonInicial.getVida() - pokemonRival.getDano());
				ataqueRival = false;
				batallaHilo = false;

				break;

			case 3:

			}
		}
	}

	public void batallaPintar() {
		if (mostrarPokemon == true) {
			pokemonSalvajeBatalla.pintar(this.pokemonSalvaje.getPokemonImagenAdelante());
		} else {

		}
		if (pantallaBatalla == 1) {
			pokemonSalvajeBatalla.escape();
		}

		pintarPokemonInicial();

	}

	public void pintarPokemonSalvaje() {
		jugadorPasto();
		pokemonSalvaje.pintar(this.pokemonSalvaje.getPokemonImagenAdelante());

		if (pokemonSalvaje.isEnPasto() == true) {
			new Thread(pokemonSalvaje).start();
		}
	}

	public void pintarPokemonRival() {

		if (combateRival == true) {
			pokemonRival.pintar(this.pokemonRival.getPokemonImagenAdelante());
		} else {

		}

		pintarPokemonRival();

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

			// System.out.println(matY + 1);
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

//		for (int i = 0; i < 16; i++) {
//			for (int j = 0; j < 12; j++) {
//				if(mapa[i][j] == 2) {
//
//					if ((jugador.getPosX() > (j * 50)-50 && jugador.getPosX() < (j * 50)+50
//							&& jugador.getPosY() > (i * 50) - 50 && jugador.getPosY() < (i * 50) + 50) ) {
//						//					System.out.println("jugadorAdentro");
//						//					pokemonSalvaje.setEnPasto(true);
//					}else {
//						//					pokemonSalvaje.setEnPasto(false);

	}

	public void encontrarPokemon() {
		if (PApplet.dist(jugador.getPosX(), jugador.getPosY(), pokemonSalvaje.getPosX(),
				pokemonSalvaje.getPosY()) < 100) {
			encontroPokemon = true;
			combate = true;
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

//		System.out.println(app.mouseX + " " + app.mouseY);

		// fight
		if (PApplet.dist(app.mouseX, app.mouseY, 700, 650) < 100 && turno == 0 && mostrarPoder == false) {
			mostrarPoder = true;

			return;
		}

		// poder
		if (PApplet.dist(app.mouseX, app.mouseY, 800, 680) < 100 && turno == 0 && mostrarPoder == true) {

			turno = 1;
			ataque = true;
			batallaHilo = true;

		}

		if (PApplet.dist(app.mouseX, app.mouseY, 957, 620) < 100 && turno == 0) {
			randomicosDeCaptura();

//				System.out.println(jugador.getPokemonCapturados().size());

			this.intentoCaptura = true;

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

	public void escogerPokemon(String id) {
		if (id.toLowerCase().trim().equals("agua")) {

			this.pintarPokemon = 1;

			pokemonInicial = new Inicial(id, "./imagenes/pokemones/sobbleDelante.png",
					"./imagenes/pokemones/sobbleAtras.png", 277, 430, app);

			// pokemon rival
			pokemonRival = new Inicial(id, "./imagenes/pokemones/grookeyDelante.png",
					"./imagenes/pokemones/grookeyAtras.png", 277, 430, app);

		}
		if (id.toLowerCase().trim().equals("fuego")) {

			this.pintarPokemon = 2;

			pokemonInicial = new Inicial(id, "./imagenes/pokemones/scorbunnyDelante.png",
					"./imagenes/pokemones/scorbunnyAtras.png", 277, 430, app);

			// pokemon rival
			pokemonRival = new Inicial(id, "./imagenes/pokemones/sobbleDelante.png",
					"./imagenes/pokemones/sobbleAtras.png", 277, 430, app);

		}
		if (id.toLowerCase().trim().equals("hierba")) {

			this.pintarPokemon = 3;

			pokemonInicial = new Inicial(id, "./imagenes/pokemones/grookeyDelante.png",
					"./imagenes/pokemones/grookeyAtras.png", 277, 430, app);

			// pokemon rival
			pokemonRival = new Inicial(id, "./imagenes/pokemones/scorbunnyDelante.png",
					"./imagenes/pokemones/scorbunnyAtras.png", 277, 430, app);

		}

	}

	// PINTAR POKEMON INICIAL DEL JUGADOR

	public void pintarPokemonInicial() {
		switch (pintarPokemon) {
		case 1:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
			pokemonInicial.setDano(25);
			app.fill(0);
			app.text(pokemonInicial.getId(), 400, 500);
			app.text(pokemonInicial.getNivel() + "LV", 500, 500);

			break;

		case 2:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
			pokemonInicial.setDano(30);
			app.fill(0);
			app.text(pokemonInicial.getId(), 400, 500);
			app.text(pokemonInicial.getNivel() + "LV", 500, 500);
			break;
		case 3:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
			pokemonInicial.setDano(20);
			app.fill(0);
			app.text(pokemonInicial.getId(), 400, 500);
			app.text(pokemonInicial.getNivel() + "LV", 500, 500);

			break;
		}

	}

	// PINTAR POKEMON INICIAL DE RIVAL

	public void pintarPokemonInicialVS() {

		/// RECORRER ARREGLO DEL RIVAL Y PINTARLO
		// RIVALARREGLO.PINTAR

		switch (pintarPokemon) {
		case 1:
			pokemonRival.pintar(this.pokemonRival.getPokemonImagenAdelante());
			pokemonRival.setDano(20);
			app.fill(0);
			app.text(pokemonRival.getId(), 800, 150);
			app.text(pokemonRival.getNivel() + "LV", 900, 300);

			break;

		case 2:
			pokemonRival.pintar(this.pokemonRival.getPokemonImagenAdelante());
			pokemonRival.setDano(25);
			app.fill(0);
			app.text(pokemonRival.getId(), 800, 150);
			app.text(pokemonRival.getNivel() + "LV", 900, 300);

			break;
		case 3:
			pokemonRival.pintar(this.pokemonRival.getPokemonImagenAdelante());
			pokemonRival.setDano(30);
			app.fill(0);
			app.text(pokemonRival.getId(), 800, 150);
			app.text(pokemonRival.getNivel() + "LV", 900, 300);

			break;
		}
	}

	public void randomicosDeCaptura() {

		ArrayList<Pokemon> pokemonTemporal = new ArrayList<Pokemon>();

		if (this.intentoCaptura == true) {

			this.varCaptura = Math.floor(Math.random() * 100 + 1);

			if (pokemonSalvajeBatalla.getVida() >= 10) {

				if (this.varCaptura > 67) {
					pantallaBatalla = 2;

					System.out.println(varCaptura + "Fight");
				}

				if (this.varCaptura >= 34 && this.varCaptura <= 67) {
					pantallaBatalla = 1;

					System.out.println(varCaptura + "seEscapo");

				}

				if (this.varCaptura < 34) {
					pantallaBatalla = 2;
					mostrarPokemon = false;
					pokemonTemporal = jugador.getPokemonCapturados();
					pokemonTemporal
							.add(new Salvaje("wooloo", "./imagenes/pokemones/wooloo.png", "noexiste", 5, 450, app));
					jugador.setPokemonCapturados(pokemonTemporal);

					System.out.println(varCaptura + "captura");

				}

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

	public int getPantallaBatalla() {
		return pantallaBatalla;
	}

	public void setPantallaBatalla(int pantallaBatalla) {
		this.pantallaBatalla = pantallaBatalla;
	}

}
