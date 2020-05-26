package controller;

import model.Juego;
import processing.core.PApplet;

public abstract class Controller {
	protected static Juego juego;
	protected PApplet app;
	
	public Controller(PApplet app) {
		this.app=app;
		juego = new Juego(app);
		
}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
	  Controller.juego = juego;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	
	
	
	
	
}

