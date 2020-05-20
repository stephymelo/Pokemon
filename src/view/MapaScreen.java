package view;
import controller.MapaController;
import model.Juego;
import processing.core.PApplet;

import processing.core.PImage;

public class MapaScreen extends ScreenView {


	private PImage mapa,grass;
	private MapaController mapaController;
	
	
	
	public MapaScreen(PApplet app,Juego juego){
		super(app,juego);
		mapaController=new MapaController(app,juego);
		
		this.mapa=app.loadImage("imagenes/fondoPixel.png");
		this.grass=app.loadImage("imagenes/grassSeperate.png");
	
		
	
		
	}
	
	public void drawScreen(){
		
		app.image(mapa,0,0);
		mapaController.pintarJugador();
		app.image(grass,0,0);
		mapaController.pintarMapa();
		

		
		
	}
	

	public void caminar() {
		mapaController.caminar();
	}
	
	

}
