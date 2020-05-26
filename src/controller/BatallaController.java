package controller;


import processing.core.PApplet;

public class BatallaController extends Controller {
	
	
	
	public BatallaController(PApplet app) {
		super(app);
		
	}
	
	
	public void pintar() {
		juego.batallaPintar();
//		juego.pintarPokemonRival();
		
		
	}
	public void pintarPoder() {
		juego.poder();
		juego.vidaPokemon();
		juego.batalla();
		juego.pokeAtaque();
	}
	
	public int pantallaBatalla() {
		return juego.getPantallaBatalla();
	}

	
	
	
}
