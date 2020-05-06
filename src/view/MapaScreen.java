package view;
import controller.MapaController;
import processing.core.PApplet;

import processing.core.PImage;

public class MapaScreen extends ScreenView {


	private PImage mapa;
	private MapaController mapaController;
	
	
	
	public MapaScreen(PApplet app){
		super(app);
		mapaController=new MapaController(app);
		
		this.mapa=app.loadImage("imagenes/fondoPixel.png");
	
		
	}
	
	public void drawScreen(){
	
		app.image(mapa,0,0);
		mapaController.pintarJugador();
		
		
	}
	
	public void jugadorCaminando() {
		mapaController.caminarJugadorTop();
		
		
	}
	public void caminar() {
		mapaController.caminar();
	}
	
	

}
