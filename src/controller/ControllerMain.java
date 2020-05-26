package controller;


import processing.core.PApplet;

public class ControllerMain extends Controller {


	
	public ControllerMain (PApplet app) {
		super(app);

	
	}
	
	
	
	public void escogerPokemon(String id) {
		juego.escogerPokemon(id);
	}
	

	public void escogerGenero(int generoChoose) {
		juego.escogerGenero(generoChoose);
	}
	
	
	public boolean encontro() {
		return juego.isEncontroPokemon();
	}
	
	public boolean deVueltaMapa() {
		return juego.isMapaScreen();
	}
	
	
	
	public void verificarClicksMapa() {
		juego.verificarClicksMapa();
	}
	
	public void verificarClicks() {
		juego.verificarClicks();
	}
	

}
