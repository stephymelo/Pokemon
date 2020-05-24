package view;

import processing.core.PApplet;
import processing.core.PImage;

public class PokedexScreen {

	private PApplet app;
	private PImage pokedex, botonTipo, botonNom;

	public PokedexScreen(PApplet app) {
		this.app = app;

		this.pokedex = app.loadImage("data/View.jpg");
		this.botonNom = app.loadImage("data/BotonNom.png");
		this.botonTipo = app.loadImage("data/BotonTipo.png");
	}

	public void drawPokedex() {

		app.image(pokedex, 0, 0, 1200, 800);
		app.image(botonTipo, 76, 578);
		app.image(botonNom, 322, 578);

	}

}
