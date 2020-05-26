package controller;

import model.Juego;
import processing.core.PApplet;

public class PokedexController extends Controller {
	

	public PokedexController(PApplet app) {
	super(app);
		
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
