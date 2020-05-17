package view;
import controller.MapaController;
import processing.core.PApplet;

import processing.core.PImage;

public class MapaScreen extends ScreenView {


	private PImage mapa,grass;
	private MapaController mapaController;
	
	
	
	public MapaScreen(PApplet app){
		super(app);
		mapaController=new MapaController(app);
		
		this.mapa=app.loadImage("imagenes/fondoPixel.png");
		this.grass=app.loadImage("imagenes/grassSeperate.png");
	
		
	
		
	}
	
	public void drawScreen(){
		
		app.image(mapa,0,0);
		mapaController.pintarJugador();
		app.image(grass,0,0);
		mapaController.pintarMapa();

		
		
	}
	
	public void jugadorCaminando() {
		mapaController.caminarJugadorTop();
		
		
	}
	public void caminar() {
		mapaController.caminar();
	}
	
	

}
