package controller;

import model.Juego;
import processing.core.PApplet;

public class UsuarioController {

	private PApplet app;
	private Juego juego;

	public UsuarioController(PApplet app) {
		this.app = app;
		juego = new Juego(app);
	}

	public void pintarUsuario() {
		juego.PintarUsuarioLista();
	}

	public void ordenarParcial() {
		juego.OrdenarFecha();
	}

	public void ordenarNatural() {
		juego.OrdenarNombreUsuario();
	}

}
