package view;
import controller.MapaController;
import model.Juego;
import processing.core.PApplet;
import processing.core.PConstants;
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
		mapaController.pintarMapa();
		app.imageMode(PConstants.CENTER);
		
		app.image(mapa,app.width/2,app.height/2);
	
		app.image(grass,app.width/2,app.height/2);
		
		mapaController.pintarJugador();
		

		
		
	}
	

	public void caminar() {
		mapaController.caminar();
	}
	
	

}
