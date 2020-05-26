package controller;

import controlP5.Controller;
import processing.core.PApplet;

public class MapaController extends Controller {

	public MapaController(PApplet app) {
		super(app);

	}

	public void pintarJugador() {
		juego.jugadores();
		juego.pintarRival();

	}

	public void caminar() {
		juego.caminar();
	}

	public void pintarMapa() {
		juego.pintarPokemones();
		juego.pintarPokemonSalvaje();
		juego.pintarMapa();
		juego.encontrarPokemon();

	}

}
