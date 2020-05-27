package controller;


import processing.core.PApplet;

public class BatallaController extends Controller {
	
	
	
	public BatallaController(PApplet app) {
		super(app);
		
	}
	
	
	public void pintar() {
		juego.batallaPintar();	
		
	}
	
	public void pintarRival() {
		juego.pintarPokemonInicialVS();
	}
	
	public boolean combateRival() {
		return juego.isCombateRival();
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
