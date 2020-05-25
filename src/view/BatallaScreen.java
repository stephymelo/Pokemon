package view;

import controller.BatallaController;
import java.util.Timer;
import java.util.TimerTask;
import model.Juego;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

       
public class BatallaScreen extends ScreenView {
	private    Timer timer;
	private int pantalla;
	private BatallaController batallaController;
	private PImage batallaBg, fightText, triangle, menu,menuExit,menuCatch,notCatch;

	public BatallaScreen(PApplet app, Juego juego) {
		super(app, juego);
		// TODO Auto-generated constructor stub
		  timer = new Timer();
		  pantalla= batallaController.pantallaBatalla();
		this.batallaBg = app.loadImage("./imagenes/batallaBG.png");
		this.fightText = app.loadImage("./imagenes/fightBatalla.png");
		this.menu = app.loadImage("./imagenes/batallaMenu.png");
		this.menuExit = app.loadImage("./imagenes/menuExit.png");
		this.menuCatch = app.loadImage("./imagenes/catchMenu.png");
		this.notCatch = app.loadImage("./imagenes/notCatch.png");
		this.triangle = app.loadImage("./imagenes/triangleBattle.png");
		this.batallaController = new BatallaController(app, juego);
		
		Timer t = new java.util.Timer();
		t.schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                pantalla=0;
		                t.cancel();
		            }
		        }, 
		        5000 
		);
		
	}
	
	
	
 
 

	public void drawScreen() {

		switch(pantalla) {
		case 0:
			app.fill(86, 89, 85);
			app.textSize(80);
			
			
			app.imageMode(PConstants.CENTER);
			app.image(batallaBg, app.width / 2, app.height / 2);

			app.image(fightText, 900, 700);

			batallaController.pintar();
			app.image(menu, app.width / 2, 680);

			if (app.mouseX > 684 && app.mouseY > 633 && app.mouseX < 827 && app.mouseY < 679) {
				app.image(triangle, 650, 645);
			}
			if (app.mouseX > 960 && app.mouseY > 633 && app.mouseX < 1111 && app.mouseY < 679) {
				app.image(triangle, 920, 645);
			}
			if (app.mouseX > 960 && app.mouseY > 717 && app.mouseX < 1047 && app.mouseY < 758) {
				app.image(triangle, 920, 720);
			}
		
		case 1:
			app.image(menuExit, app.width / 2, 680);
			break;
		case 2:
			app.image(menuCatch, app.width / 2, 680);
			
			break;
		case 3:
			app.image(notCatch, app.width / 2, 680);
			TimeUnit.SECONDS.sleep(1);
			
			
			
			break;
		
		}
		
		
		

	
		batallaController.pintarPoder();

	}

}
