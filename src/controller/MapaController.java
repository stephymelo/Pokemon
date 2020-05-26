package controller;


import processing.core.PApplet;

public class MapaController extends Controller {

	public MapaController(PApplet app) {
		super(app);

	}

	public void pintarJugador() {
		juego.jugadores();
		juego.pintarRival();
		juego.pintarPokebola();

	}

	public void caminar() {
		juego.caminar();
	}

	public void pintarMapa() {
		
		juego.pintarPokemonSalvaje();
		juego.pintarMapa();
		juego.encontrarPokemon();
		

	}

}
