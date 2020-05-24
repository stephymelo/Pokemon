package view;
import controller.ControllerMain;
import model.Juego;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.sound.*;

public class MainView extends PApplet {
	private MapaScreen mapaScreen; 
	private IntroScreen introScreen;
	private BatallaScreen batallaScreen;
	private Juego juego;
	private ControllerMain controllerMain;
	private int pantalla;
	
	
	private SoundFile musicaFondo;
	

	public static void main(String[] args) {
		PApplet.main(MainView.class.getName());
	}

	public void settings() {
		size(1200, 800);
		juego=new Juego(this);
		
	}

	public void setup() {
		background(0);
		mapaScreen=new MapaScreen(this,juego);
		introScreen=new IntroScreen(this,juego);
		batallaScreen=new BatallaScreen(this,juego);
		controllerMain=new ControllerMain(this,juego);
		pantalla=0;
		imageMode(CENTER);
		musicaFondo=new SoundFile(this, "./sonidos/mapaMusic.mp3");
//		musicaFondo.play();
//		musicaFondo.amp(-1);
	//loop soundfile
		
		
	}

	public void draw() {
		
		
		switch(pantalla){
		case 0:
			introScreen.drawScreen();
			
			
			break;
		case 1:
			mapaScreen.drawScreen();
			
			
		
			break;
		case 2:
			batallaScreen.drawScreen();
			break;
			
		}
		
		if(controllerMain.encontro()==true) {
			pantalla=2;
		}

	}
	
	
	public void mouseClicked() {
		if(pantalla==2) {
		controllerMain.verificarClicks();
		}
		System.out.println(pantalla);
		
//		System.out.println(mouseX+"mouseX"+mouseY+"mouseY");
		
	////////INTRO
		
		if(pantalla==0) {
			introScreen.mouseClick();
			introScreen.getInfoForm();

		if(mouseX>490&&mouseY>700&&mouseX<670&&mouseY<750&&introScreen.getPantallaIntro()==7) {
			pantalla=1;
			return;
		}
		}
		/////////
		
		
		
		
		
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




