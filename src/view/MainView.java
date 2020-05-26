package view;

import java.lang.Thread.State;

import controller.ControllerMain;
//import controller.MainController;
import controller.PokedexController;
import model.Juego;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.sound.*;

public class MainView extends PApplet {
	private MapaScreen mapaScreen;
	private IntroScreen introScreen;
	private BatallaScreen batallaScreen;
	private Juego juego;
	private ControllerMain controllerMain;
	private int pantalla;
	private PFont pixelFont;

	// POKEDEX
	private PokedexScreen pokeScreen;
	private PokedexController pokeController;

	public static void main(String[] args) {
		PApplet.main(MainView.class.getName());
	}

	public void settings() {
		size(1200, 800);
		juego = new Juego(this);
	}

	public void setup() {
		background(0);
		
		mapaScreen = new MapaScreen(this);
		introScreen = new IntroScreen(this);
		batallaScreen = new BatallaScreen(this);
		controllerMain = new ControllerMain(this);
		pantalla = 0;
		imageMode(CENTER);
		pixelFont = createFont("./pokemon_pixel_font.ttf", 20);
		pokeController = new PokedexController(this);
		pokeScreen = new PokedexScreen(this);
		new Thread(juego).start();
//		new Thread(introScreen).start();

	}

	public void draw() {
		textFont(pixelFont, 20);

		switch (pantalla) {
		case 0:
			introScreen.drawScreen();
			break;
		case 1:
			mapaScreen.drawScreen();
			break;
		case 2:
			batallaScreen.drawScreen();
			

//			if(juego.getState()==State.NEW) {
//				juego.start();
//			}
			

			break;

		}

		if (controllerMain.encontro() == true) {
			pantalla = 2;
		}

		if (controllerMain.deVueltaMapa() == true) {
			pantalla = 1;

		}

		// POKEDEX
		/*
		 * pokeScreen.drawPokedex(); pokeController.pintarJuego();
		 * pokeController.mouseJuego();
		 */
	}

	public void mouseClicked() {
		if (pantalla == 1) {
			controllerMain.verificarClicksMapa();
		}
		if (pantalla == 2) {
			controllerMain.verificarClicks();
		}

		System.out.println(mouseX + "mouseX" + mouseY + "mouseY");

		//////// INTRO

		if (pantalla == 0) {
			introScreen.mouseClick();
			introScreen.getInfoForm();
			if (mouseX > 490 && mouseY > 700 && mouseX < 670 && mouseY < 750 && introScreen.getPantallaIntro() == 7) {
				pantalla = 1;
				return;
			}
		}
		/////////

		// POKEDEX
		if (mouseX > 76 & mouseX < 280 && mouseY > 570 & mouseY < 617) {
			pokeController.ordenarParcial();
		}

		if (mouseX > 322 & mouseX < 519 && mouseY > 570 & mouseY < 617) {
			pokeController.ordenarNatural();
		}
	}

	public void keyPressed() {

		mapaScreen.caminar();

	}

	public void keyReleased() {

	}

	public int getPantalla() {
		return pantalla;
	}

	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}

}
