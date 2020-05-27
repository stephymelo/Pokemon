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
<<<<<<< HEAD
<<<<<<< HEAD
	private boolean grockeyB, rookideeB, sobbleB, scorbunnyB, woolooB, butterfreeB, hoothootB, pidoveB, minccinoB,
			caterpieB;
	private boolean posicion1, posicion2, posicion3, posicion4, posicion5, posicion6, posicion7, posicion8, posicion9,
			posicion10;
	private PImage grockey, rookidee, sobble, scorbunny, wooloo, butterfree, hoothoot, pidove, minccino, caterpie;

	// USUARIOS
	private Usuario usuario;
	private String[] textUsu;
	private LinkedList<Usuario> usuarioList;
	private UsuarioFecha UsuarioOrd;
=======
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
	private boolean verdeB;
	private PImage verde;
	private ArrayList<Pokemon> pokemonUsers;
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
	private int pintarPokemon;
	private int matX, matY;
	private boolean regresoBatalla;
	

	private int pantallaBatalla;
	private double varCaptura;
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
		mostrarPokemon = true;
		regresoBatalla=false;
		mostrarPoder = false;
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		
	

		// filas hacia abajo
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		this.matY = 0;
		this.matX = 3;
		this.varCaptura = 0;
		this.pantallaBatalla = 0;
		this.turno = 0;
		this.ataque = false;
		this.ataqueRival = false;
		// POKEDEX
		pokedexList = new LinkedList<Pokedex>();
		pokeOrd = new PokedexTipo();

<<<<<<< HEAD
<<<<<<< HEAD
		grockey = app.loadImage("./imagenes/Pokedex/Verde.png");
		rookidee = app.loadImage("./imagenes/Pokedex/buho.png");
		sobble = app.loadImage("./imagenes/Pokedex/Azul.png");
		scorbunny = app.loadImage("./imagenes/Pokedex/Blanco.png");
		wooloo = app.loadImage("./imagenes/Pokedex/oveja.png");
		butterfree = app.loadImage("./imagenes/Pokedex/Butterfree.png");
		hoothoot = app.loadImage("./imagenes/Pokedex/Hoothoot.png");
		pidove = app.loadImage("./imagenes/Pokedex/Pidove.png");
		minccino = app.loadImage("./imagenes/Pokedex/Minccino.png");
		caterpie = app.loadImage("./imagenes/Pokedex/Caterpie.png");

		text = app.loadStrings("./pokedexTXT/pokedex.txt");

		grockeyB = false;
		rookideeB = false;
		sobbleB = false;
		scorbunnyB = false;
		woolooB = false;
		butterfreeB = false;
		hoothootB = false;
		pidoveB = false;
		minccinoB = false;
		caterpieB = false;

		posicion1 = false;
		posicion2 = false;
		posicion3 = false;
		posicion4 = false;
		posicion5 = false;
		posicion6 = false;
		posicion7 = false;
		posicion8 = false;
		posicion9 = false;
		posicion10 = false;
=======
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		verde = app.loadImage("./imagenes/Pokedex/Verde.png");

		text = app.loadStrings("./pokedexTXT/pokedex.txt");

		verdeB = false;
<<<<<<< HEAD
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.

		for (int i = 0; i < text.length; i++) {
			String[] poketxt = text[i].split(" ");
			String nombre = poketxt[1];
			String tipo = poketxt[2];

			pokedexList.add(new Pokedex(nombre, tipo));
<<<<<<< HEAD
<<<<<<< HEAD
		}

		// USUARIO
		usuarioList = new LinkedList<Usuario>();

		textUsu = app.loadStrings("./usuariosTXT/userRegister.txt");
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.

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
				

				if (ataque == true) {
					turno = 1;
				

				}
				Thread.sleep(3000);
				if (ataqueRival == true) {
					
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
<<<<<<< HEAD
<<<<<<< HEAD
				turno=2;
=======
				System.out.println(turno+"turno");
				
				
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
				System.out.println(turno+"turno");
				
				
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
			}
			break;
		case 2:
			pokemonInicial.setVida(pokemonInicial.getVida() - pokemonSalvajeBatalla.getDano());
			ataqueRival = false;
<<<<<<< HEAD
<<<<<<< HEAD
			batallaHilo = false;
=======
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
			batallaHilo=false;
			System.out.println(batallaHilo+" SientrohilooDOS");

>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
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
<<<<<<< HEAD
<<<<<<< HEAD
     	app.image(pokemonUno, 1000, 55, 80, 50);
		if (pokemonCapturado) {
			pokemonUno = app.loadImage("./imagenes/pokemones/wooloo.png");
			app.image(pokemonUno, 1100, 55, 80, 50);
		}
	}

	public void batallaPintar() {
=======

		app.image(pokemonUno, 1000, 55, 80, 50);
		
		if(pokemonCapturado) {
			pokemonUno = app.loadImage("./imagenes/pokemones/wooloo.png");
			app.image(pokemonUno, 1100, 55, 80, 50);
=======

		app.image(pokemonUno, 1000, 55, 80, 50);
		
		if(pokemonCapturado) {
			pokemonUno = app.loadImage("./imagenes/pokemones/wooloo.png");
			app.image(pokemonUno, 1100, 55, 80, 50);
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
			
		}
		


		
	}

	public void batallaPintar() {
		
		
		
		
<<<<<<< HEAD
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		if (mostrarPokemon) {
			pokemonSalvajeBatalla.pintar(pokemonSalvajeBatalla.getPokemonImagenAdelante());
			pokemonSalvajeBatalla.setDano(20);
			app.fill(0);
			app.text("Wooloo" + " " + " " + "2 LV", 110, 145);
		} else {
		}
<<<<<<< HEAD
<<<<<<< HEAD
		if (pokemonSalvajeBatalla.getVida() <= 0) {
			pokemonSalvajeBatalla.morir();
=======
		
		if(pokemonSalvajeBatalla.getVida()<=0) {
			pokemonSalvajeBatalla.morir();
			
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
		
		if(pokemonSalvajeBatalla.getVida()<=0) {
			pokemonSalvajeBatalla.morir();
			
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		}
		if (escapePokemon) {
			pokemonSalvajeBatalla.escape();
		}
<<<<<<< HEAD
<<<<<<< HEAD
=======
		
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
		
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
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
<<<<<<< HEAD
<<<<<<< HEAD
		System.out.println(batallaHilo + "hiloo");
=======
		System.out.println(batallaHilo+"hiloo");
		
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
		System.out.println(batallaHilo+"hiloo");
		
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		// fight
		if (PApplet.dist(app.mouseX, app.mouseY, 700, 650) < 100 && turno == 0 && mostrarPoder == false) {
			mostrarPoder = true;
			return;
		}
		// poder
		if (PApplet.dist(app.mouseX, app.mouseY, 800, 680) < 100 && turno == 0 && mostrarPoder == true) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
			
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
			
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
			ataque = true;
			turno=1;
			batallaHilo = true;
<<<<<<< HEAD
<<<<<<< HEAD
		}
		if (PApplet.dist(app.mouseX, app.mouseY, pokemonInicial.getPosX(), pokemonInicial.getPosY()) < 100
				&& pokemonSalvajeBatalla.getVida() == 0) {
			pokemonInicial.setExperiencia(5);
=======
			
			
		}
		
		if (PApplet.dist(app.mouseX, app.mouseY, pokemonInicial.getPosX(), pokemonInicial.getPosY()) < 100 && pokemonSalvajeBatalla.getVida()==0) {
			pokemonInicial.setExperiencia(5);
			
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
			
			
		}
		
		if (PApplet.dist(app.mouseX, app.mouseY, pokemonInicial.getPosX(), pokemonInicial.getPosY()) < 100 && pokemonSalvajeBatalla.getVida()==0) {
			pokemonInicial.setExperiencia(5);
			
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
			
			
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
			
			
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		}
	}

	public void verificarClicksMapa() {
		System.out.println(mostrarPokemon + "poke");
<<<<<<< HEAD
<<<<<<< HEAD
		if(pokemonCapturado = true) {
=======
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		
//		if(pokemonCapturado = true) {
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		try {
			if (app.mouseX > 860 && app.mouseX < 930 && app.mouseY > 130 && app.mouseY < 260) {
				combateRival = true;
				regresoBatalla=true;
				
			}
			throw new exceptionRival("no capturaste");
		} catch (exceptionRival e) {
			System.out.println(e.getMessage());
		}
<<<<<<< HEAD
<<<<<<< HEAD
	  }
	}
=======
		}
	
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======
		}
	
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.

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
	
	/**
	 * Aparece el poder antes de atacar
	 *
	 * 
	 */
	
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
<<<<<<< HEAD
<<<<<<< HEAD
		if (grockeyB == true) {
			app.image(grockey, 202, 227);
		}

		if (rookideeB == true) {
			app.image(rookidee, 202, 227);
		}

		if (sobbleB == true) {
			app.image(sobble, 202, 227);
		}

		if (scorbunnyB == true) {
			app.image(scorbunny, 202, 227);
		}

		if (woolooB == true) {
			app.image(wooloo, 202, 227);
		}

		if (butterfreeB == true) {
			app.image(butterfree, 202, 227);
		}

		if (hoothootB == true) {
			app.image(hoothoot, 202, 227);
		}

		if (pidoveB == true) {
			app.image(pidove, 202, 227);
		}

		if (minccinoB == true) {
			app.image(minccino, 202, 227);
		}

		if (caterpieB == true) {
			app.image(caterpie, 202, 227);
=======

		if (verdeB == true) {
			app.image(verde, 202, 227);
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======

		if (verdeB == true) {
			app.image(verde, 202, 227);
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		}
	}

	public void mouseLogica() {
<<<<<<< HEAD
<<<<<<< HEAD
		
			// #001
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 110 & app.mouseY < 161) {

				posicion1 = true;

				if (pokedexList.get(0).getNombre().equals("Grockey")) {
					grockeyB = true;
				}
				if (pokedexList.get(0).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(0).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(0).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(0).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(0).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}

				if (pokedexList.get(0).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}
				if (pokedexList.get(0).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(0).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}
			}

			// #002
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 180 & app.mouseY < 220) {

				posicion2 = true;

				if (pokedexList.get(1).getNombre().equals("Grockey")) {
					grockeyB = true;
				}
				if (pokedexList.get(1).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(1).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(1).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(1).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(1).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}

				if (pokedexList.get(1).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}
				if (pokedexList.get(1).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(1).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}
			}

			// #003
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 248 && app.mouseY < 287) {

				posicion3 = true;

				if (pokedexList.get(2).getNombre().equals("Grockey")) {
					grockeyB = true;

				}
				if (pokedexList.get(2).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(2).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(2).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(2).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(2).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}
				if (pokedexList.get(2).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}
				if (pokedexList.get(2).getNombre().equals("Pidove")) {
					pidoveB = true;
				}
				if (pokedexList.get(2).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(2).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}
			}

			// #004
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 309 && app.mouseY < 358) {

				posicion4 = true;

				if (pokedexList.get(3).getNombre().equals("Grockey")) {
					grockeyB = true;

				}
				if (pokedexList.get(3).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(3).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(3).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(3).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(3).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}
				if (pokedexList.get(3).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}
				if (pokedexList.get(3).getNombre().equals("Pidove")) {
					pidoveB = true;
				}
				if (pokedexList.get(3).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(3).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}
			}

			// #005
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 382 & app.mouseY < 422) {

				posicion5 = true;

				if (pokedexList.get(4).getNombre().equals("Grockey")) {
					grockeyB = true;

				}
				if (pokedexList.get(4).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(4).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(4).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(4).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(4).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}
				if (pokedexList.get(4).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}
				if (pokedexList.get(4).getNombre().equals("Pidove")) {
					pidoveB = true;
				}
				if (pokedexList.get(4).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(4).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}

			}

			// #006
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 448 & app.mouseY < 492) {

				posicion6 = true;

				if (pokedexList.get(5).getNombre().equals("Grockey")) {
					grockeyB = true;

				}
				if (pokedexList.get(5).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(5).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(5).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(5).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(5).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}
				if (pokedexList.get(5).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}
				if (pokedexList.get(5).getNombre().equals("Pidove")) {
					pidoveB = true;
				}
				if (pokedexList.get(5).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(5).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}
			}

			// #007
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 520 & app.mouseY < 562) {

				posicion7 = true;

				if (pokedexList.get(6).getNombre().equals("Grockey")) {
					grockeyB = true;

				}
				if (pokedexList.get(6).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(6).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(6).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}
=======
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
		if (app.mousePressed == true) {
			// for (int i = 0; i < pokedex.getNombre().pokedexList.size(); i++) {

			if (pokedexList.get(0).getNombre().equals("Grockey")) {
				verdeB = true;
<<<<<<< HEAD
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.

			}
<<<<<<< HEAD

			// #008
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 576 && app.mouseY < 630) {

				posicion8 = true;

				if (pokedexList.get(7).getNombre().equals("Grockey")) {
					grockeyB = true;

				}
				if (pokedexList.get(7).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(7).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(7).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(7).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(7).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}
				if (pokedexList.get(7).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}
				if (pokedexList.get(7).getNombre().equals("Pidove")) {
					pidoveB = true;
				}
				if (pokedexList.get(7).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(7).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}
			}

			// #009
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 649 && app.mouseY < 696) {

				posicion9 = true;

				if (pokedexList.get(8).getNombre().equals("Grockey")) {
					grockeyB = true;

				}
				if (pokedexList.get(8).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(8).getNombre().equals("Sobble")) {
					sobbleB = true;

				}
				if (pokedexList.get(8).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(8).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(8).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}
				if (pokedexList.get(8).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}

				if (pokedexList.get(8).getNombre().equals("Pidove")) {
					pidoveB = true;
				}
				if (pokedexList.get(8).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(8).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}
			}

			// #010
			if (app.mouseX > 726 & app.mouseX < 979 && app.mouseY > 715 && app.mouseY < 765) {

				posicion10 = true;

				if (pokedexList.get(9).getNombre().equals("Grockey")) {
					grockeyB = true;
				}
				if (pokedexList.get(9).getNombre().equals("Rookidee")) {
					rookideeB = true;
				}
				if (pokedexList.get(9).getNombre().equals("Sobble")) {
					sobbleB = true;
				}
				if (pokedexList.get(9).getNombre().equals("Scorbunny")) {
					scorbunnyB = true;
				}

				if (pokedexList.get(9).getNombre().equals("Wooloo")) {
					woolooB = true;
				}
				if (pokedexList.get(9).getNombre().equals("Butterfree")) {
					butterfreeB = true;
				}
				if (pokedexList.get(9).getNombre().equals("Hoothoot")) {
					hoothootB = true;
				}
				if (pokedexList.get(9).getNombre().equals("Pidove")) {
					pidoveB = true;
				}
				if (pokedexList.get(9).getNombre().equals("Minccino")) {
					minccinoB = true;
				}
				if (pokedexList.get(9).getNombre().equals("Caterpie")) {
					caterpieB = true;
				}
			}

			// BOTONES ORDENAR
			if (app.mouseX > 76 & app.mouseX < 280 && app.mouseY > 570 & app.mouseY < 617) {
				sobbleB = false;
				grockeyB = false;
				scorbunnyB = false;
				woolooB = false;
				rookideeB = false;
				butterfreeB = false;
				hoothootB = false;
				pidoveB = false;
				minccinoB = false;
				caterpieB = false;
				posicion1 = false;
				posicion2 = false;
				posicion3 = false;
				posicion4 = false;
				posicion5 = false;
				posicion6 = false;
				posicion7 = false;
				posicion8 = false;
				posicion9 = false;
				posicion10 = false;
			}

			if (app.mouseX > 322 & app.mouseX < 519 && app.mouseY > 570 & app.mouseY < 617) {
				sobbleB = false;
				grockeyB = false;
				scorbunnyB = false;
				woolooB = false;
				rookideeB = false;
				butterfreeB = false;
				hoothootB = false;
				pidoveB = false;
				minccinoB = false;
				caterpieB = false;
				posicion1 = false;
				posicion2 = false;
				posicion3 = false;
				posicion4 = false;
				posicion5 = false;
				posicion6 = false;
				posicion7 = false;
				posicion8 = false;
				posicion9 = false;
				posicion10 = false;
			}

		

		// DESACTIVAR POKEMONES VISIBLES
		if (grockeyB == true && posicion1 == true) {
			sobbleB = false;
			scorbunnyB = false;
			rookideeB = false;
			woolooB = false;
			butterfreeB = false;
			hoothootB = false;
			pidoveB = false;
			minccinoB = false;
			caterpieB = false;
			posicion2 = false;
			posicion3 = false;
			posicion4 = false;
			posicion5 = false;
			posicion6 = false;
			posicion7 = false;
			posicion8 = false;
			posicion9 = false;
			posicion10 = false;
		}

		if (caterpieB == true && posicion2 == true) {
			sobbleB = false;
			scorbunnyB = false;
			rookideeB = false;
			woolooB = false;
			butterfreeB = false;
			hoothootB = false;
			pidoveB = false;
			minccinoB = false;
			grockeyB = false;
			posicion1 = false;
			posicion3 = false;
			posicion4 = false;
			posicion5 = false;
			posicion6 = false;
			posicion7 = false;
			posicion8 = false;
			posicion9 = false;
			posicion10 = false;
		}

		if (butterfreeB == true && posicion3 == true) {
			sobbleB = false;
			scorbunnyB = false;
			rookideeB = false;
			woolooB = false;
			grockeyB = false;
			hoothootB = false;
			pidoveB = false;
			minccinoB = false;
			caterpieB = false;
			posicion1 = false;
			posicion2 = false;
			posicion4 = false;
			posicion5 = false;
			posicion6 = false;
			posicion7 = false;
			posicion8 = false;
			posicion9 = false;
			posicion10 = false;
		}

		if (scorbunnyB == true && posicion4 == true) {
			sobbleB = false;
			grockeyB = false;
			rookideeB = false;
			woolooB = false;
			butterfreeB = false;
			hoothootB = false;
			pidoveB = false;
			minccinoB = false;
			caterpieB = false;
			posicion1 = false;
			posicion2 = false;
			posicion3 = false;
			posicion5 = false;
			posicion6 = false;
			posicion7 = false;
			posicion8 = false;
			posicion9 = false;
			posicion10 = false;
		}

		if (sobbleB == true && posicion5 == true) {
			grockeyB = false;
			scorbunnyB = false;
			rookideeB = false;
			woolooB = false;
			butterfreeB = false;
			hoothootB = false;
			pidoveB = false;
			minccinoB = false;
			caterpieB = false;
			posicion1 = false;
			posicion2 = false;
			posicion3 = false;
			posicion4 = false;
			posicion6 = false;
			posicion7 = false;
			posicion8 = false;
			posicion9 = false;
			posicion10 = false;

		}

		if (hoothootB == true && posicion6 == true) {
			sobbleB = false;
			grockeyB = false;
			scorbunnyB = false;
			rookideeB = false;
			butterfreeB = false;
			woolooB = false;
			pidoveB = false;
			minccinoB = false;
			caterpieB = false;
			posicion1 = false;
			posicion2 = false;
			posicion3 = false;
			posicion4 = false;
			posicion5 = false;
			posicion7 = false;
			posicion8 = false;
			posicion9 = false;
			posicion10 = false;
		}

		if (rookideeB == true && posicion7 == true) {
			sobbleB = false;
			grockeyB = false;
			scorbunnyB = false;
			woolooB = false;
			butterfreeB = false;
			hoothootB = false;
			pidoveB = false;
			minccinoB = false;
			caterpieB = false;
			posicion1 = false;
			posicion2 = false;
			posicion3 = false;
			posicion4 = false;
			posicion5 = false;
			posicion6 = false;
			posicion8 = false;
			posicion9 = false;
			posicion10 = false;
		}

		if (woolooB == true && posicion8 == true) {
			sobbleB = false;
			grockeyB = false;
			scorbunnyB = false;
			rookideeB = false;
			butterfreeB = false;
			hoothootB = false;
			pidoveB = false;
			caterpieB = false;
			minccinoB = false;
			posicion1 = false;
			posicion2 = false;
			posicion3 = false;
			posicion4 = false;
			posicion5 = false;
			posicion6 = false;
			posicion7 = false;
			posicion9 = false;
			posicion10 = false;
		}

		if (pidoveB == true && posicion9 == true) {
			sobbleB = false;
			grockeyB = false;
			scorbunnyB = false;
			rookideeB = false;
			butterfreeB = false;
			hoothootB = false;
			woolooB = false;
			minccinoB = false;
			caterpieB = false;
			posicion1 = false;
			posicion2 = false;
			posicion3 = false;
			posicion4 = false;
			posicion5 = false;
			posicion6 = false;
			posicion7 = false;
			posicion8 = false;
			posicion10 = false;
		}

		if (minccinoB == true && posicion10 == true) {
			sobbleB = false;
			grockeyB = false;
			scorbunnyB = false;
			rookideeB = false;
			butterfreeB = false;
			hoothootB = false;
			woolooB = false;
			pidoveB = false;
			caterpieB = false;
			posicion1 = false;
			posicion2 = false;
			posicion3 = false;
			posicion4 = false;
			posicion5 = false;
			posicion6 = false;
			posicion7 = false;
			posicion8 = false;
			posicion9 = false;
		}

		// VER NOMBRE Y TIPO POKEDEX
		if (posicion1 == true) {
			app.text(pokedexList.get(0).getNombre(), 220, 155);
			app.text(pokedexList.get(0).getTipo(), 300, 725);
		}
		if (posicion2 == true) {
			app.text(pokedexList.get(1).getNombre(), 220, 155);
			app.text(pokedexList.get(1).getTipo(), 300, 725);
		}
		if (posicion3 == true) {
			app.text(pokedexList.get(2).getNombre(), 220, 155);
			app.text(pokedexList.get(2).getTipo(), 300, 725);
		}
		if (posicion4 == true) {
			app.text(pokedexList.get(3).getNombre(), 220, 155);
			app.text(pokedexList.get(3).getTipo(), 300, 725);
		}
		if (posicion5 == true) {
			app.text(pokedexList.get(4).getNombre(), 220, 155);
			app.text(pokedexList.get(4).getTipo(), 300, 725);
		}
		if (posicion6 == true) {
			app.text(pokedexList.get(5).getNombre(), 220, 155);
			app.text(pokedexList.get(5).getTipo(), 300, 725);
		}
		if (posicion7 == true) {
			app.text(pokedexList.get(6).getNombre(), 220, 155);
			app.text(pokedexList.get(6).getTipo(), 300, 725);
		}
		if (posicion8 == true) {
			app.text(pokedexList.get(7).getNombre(), 220, 155);
			app.text(pokedexList.get(7).getTipo(), 300, 725);
		}
		if (posicion9 == true) {
			app.text(pokedexList.get(8).getNombre(), 220, 155);
			app.text(pokedexList.get(8).getTipo(), 300, 725);
		}
		if (posicion10 == true) {
			app.text(pokedexList.get(9).getNombre(), 220, 155);
			app.text(pokedexList.get(9).getTipo(), 300, 725);
=======
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
=======

			}
>>>>>>> parent of 00c7a19... Menu, pokedex, usuarios.
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
