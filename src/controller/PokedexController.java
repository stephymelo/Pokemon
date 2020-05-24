package controller;

import model.Juego;
import processing.core.PApplet;

public class PokedexController {
	
	Juego juego;
	PApplet app;

	public PokedexController(PApplet app) {
		this.app = app;
		
		juego = new Juego(app);
	}
	
	public void pintarJuego() {
		juego.pintarPokedex();
	}
	
	public void mouseJuego() {
		juego.mouseLogica();
	}
	
	public void ordenarParcial() {
		juego.OrdenarTipo();
	}
	
	public void ordenarNatural() {
		juego.OrdenarNombre();
	}

}
