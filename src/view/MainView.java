package view;

import java.lang.Thread.State;

import controller.ControllerMain;
//import controller.MainController;
import controller.PokedexController;
import controller.UsuarioController;
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

	// MENU
	private MenuScreen menuScreen;
	private PokedexController pokeController;
	private UsuarioController usuController;

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
		menuScreen = new MenuScreen(this);
		usuController = new UsuarioController(this);

		new Thread(introScreen).start();

	}

	public void draw() {
		textFont(pixelFont, 20);

		switch (pantalla) {
		case 0:
			introScreen.drawScreen();
			break;
		case 1:
			mapaScreen.drawScreen();
			// POKEDEX
			menuScreen.drawView();
			menuScreen.mouseMenu();
			break;
		case 2:
			batallaScreen.drawScreen();
			new Thread(juego).start();

//			if(juego.getState()==State.NEW) {
//				juego.start();
//			}

			break;
		case 3:
			menuScreen.drawView();
			pokeController.pintarJuego();
			pokeController.mouseJuego();
			break;
		case 4:
			menuScreen.drawView2();
			usuController.pintarUsuario();
			break;

		}

		if (controllerMain.encontro() == true) {
			pantalla = 2;
		}

		if (controllerMain.deVueltaMapa() == true) {
			pantalla = 1;

		}

		if (controllerMain.regresoBatalla() == true) {
			pantalla = 2;
		}

		

	}

	public void mouseClicked() {
		if (pantalla == 1) {
			controllerMain.verificarClicksMapa();
		}
		if (pantalla == 2) {
			controllerMain.verificarClicks();
		}
		

		//System.out.println(mouseX + "mouseX" + mouseY + "mouseY");

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

		if (mouseX > 208 && mouseX < 312 && mouseY > 137 && mouseY < 158) {
			pantalla = 3;
		}
		if (mouseX > 206 && mouseX < 290 && mouseY > 200 && mouseY < 228) {
			pantalla = 4;
		}
		if (mouseX > 1080 && mouseX < 1122 && mouseY > 23 && mouseY < 58) {
			pantalla = 1;
		}

		pokeController.ordenarParcial();
		pokeController.ordenarNatural();
		
		usuController.ordenarParcial();
		usuController.ordenarNatural();
	}

	public void keyPressed() {

		mapaScreen.caminar();

	}


	public int getPantalla() {
		return pantalla;
	}

	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}

}
