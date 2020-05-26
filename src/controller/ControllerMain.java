package controller;

import model.Juego;
import processing.core.PApplet;

public class ControllerMain {
	private Juego juego;
	private PApplet app;
	private boolean encontro;
	
	public ControllerMain(PApplet app,Juego juego) {
		this.app=app;
		this.juego = juego;
		encontro=false;
	}
	
	
	
	public void escogerPokemon(String id) {
		juego.escogerPokemon(id);
	}
	

	public void escogerGenero(int generoChoose) {
		juego.escogerGenero(generoChoose);
	}
	
	public void pintarPokemon() {
	
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
