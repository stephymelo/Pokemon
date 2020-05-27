package view;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MenuScreen {

	private PApplet app;
	private PImage pokedex, botonTipo, botonNom, menu, openMenu, flecha, usuarios, close;
	private boolean openMenuB, menuB;

	public MenuScreen(PApplet app) {
		this.app = app;

		this.pokedex = app.loadImage("./imagenes/Pokedex/View.jpg");
		this.botonNom = app.loadImage("./imagenes/Pokedex/BotonNom.png");
		this.botonTipo = app.loadImage("./imagenes/Pokedex/BotonTipo.png");
		this.menu = app.loadImage("./imagenes/Pokedex/menuPoke.png");
		this.openMenu = app.loadImage("./imagenes/Pokedex/menu.png");
		this.flecha = app.loadImage("./imagenes/Pokedex/triangleBattle.png");
		this.usuarios = app.loadImage("./imagenes/Pokedex/Usuarios.jpg");
		this.close = app.loadImage("./imagenes/Pokedex/X.png");

	}

	// logica pantallas en el caso 4
	public void drawView() {

		app.imageMode(PConstants.CORNER);
		app.image(pokedex, 0, 0, 1200, 800);
		app.image(botonTipo, 76, 578);
		app.image(botonNom, 322, 578);
		app.image(close, 1088, 25, 30, 30);

	}

	public void drawView2() {
		app.imageMode(PConstants.CORNER);
		app.image(usuarios, 0, 0, 1200, 800);
		app.image(close, 1088, 25, 30, 30);

	}

	// logica pantallas en el caso 1
	public void drawView0() {
		app.imageMode(PConstants.CORNER);
		if (openMenuB == true) {
			app.image(openMenu, 50, 50);
		}

		if (openMenuB == false) {
			app.image(menu, 50, 50);
		}

	}

	public void mouseMenu() {

		if (app.mouseX > 208 & app.mouseX < 312 && app.mouseY > 137 & app.mouseY < 158) {
			app.imageMode(PConstants.CORNER);
			app.image(flecha, 170, 135);
		}

		if (app.mouseX > 206 & app.mouseX < 290 && app.mouseY > 200 & app.mouseY < 228) {
			app.imageMode(PConstants.CORNER);
			app.image(flecha, 170, 198);
		}

		if (app.mousePressed == true) {
			if (app.mouseX > 34 & app.mouseX < 140 && app.mouseY > 46 & app.mouseY < 140) {
				openMenuB = true;
				menuB = false;
			} else {
				menuB = true;
				openMenuB = false;
			}

		}
	}

}
