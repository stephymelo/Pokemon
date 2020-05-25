package view;

import controller.BatallaController;
import model.Juego;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class BatallaScreen extends ScreenView {
	private BatallaController batallaController;
	private PImage batallaBg, fightText, triangle, menu;

	public BatallaScreen(PApplet app, Juego juego) {
		super(app, juego);
		// TODO Auto-generated constructor stub
		this.batallaBg = app.loadImage("./imagenes/batallaBG.png");
		this.fightText = app.loadImage("./imagenes/fightBatalla.png");
		this.menu = app.loadImage("./imagenes/batallaMenu.png");
		this.triangle = app.loadImage("./imagenes/triangleBattle.png");
		this.batallaController = new BatallaController(app, juego);

	}

	public void drawScreen() {
		app.fill(86, 89, 85);
		app.textSize(80);
		
		
		app.imageMode(PConstants.CENTER);
		app.image(batallaBg, app.width / 2, app.height / 2);

		app.image(fightText, 900, 700);

		batallaController.pintar();
		app.image(menu, app.width / 2, 680);

		if (app.mouseX > 684 && app.mouseY > 633 && app.mouseX < 827 && app.mouseY < 679) {
			app.image(triangle, 650, 659);
		}
		if (app.mouseX > 960 && app.mouseY > 633 && app.mouseX < 1111 && app.mouseY < 679) {
			app.image(triangle, 920, 659);
		}
		if (app.mouseX > 960 && app.mouseY > 717 && app.mouseX < 1047 && app.mouseY < 758) {
			app.image(triangle, 920, 730);
		}

	
		batallaController.pintarPoder();

	}

}
