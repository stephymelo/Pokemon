package view;
import controller.ControllerMain;
import model.Juego;
import processing.core.PApplet;

public class MainView extends PApplet {
	private MapaScreen mapaScreen; 
	private IntroScreen introScreen;
	private Juego juego;
	private ControllerMain controllerMain;
	private int pantalla;
	

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
		controllerMain=new ControllerMain(this,juego);
		pantalla=1;
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
//			batallaScreen.drawScreen();
			break;
			
		}
		
		

	}
	
	
	public void mouseClicked() {
		controllerMain.verificarClicks();
		
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
		mapaScreen.jugadorCaminando();
		mapaScreen.caminar();

		
	}
	
	public void keyReleased() {
	
		
	}
	
	

}




