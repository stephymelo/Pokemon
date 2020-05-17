package view;
import controller.ControllerMain;
import processing.core.PApplet;

public class MainView extends PApplet {
	private MapaScreen mapaScreen; 
	private IntroScreen introScreen;
	private ControllerMain controllerMain;
	private int pantalla;
	

	public static void main(String[] args) {
		PApplet.main(MainView.class.getName());
	}

	public void settings() {
		size(1200, 800);
		
	}

	public void setup() {
		background(0);
		mapaScreen=new MapaScreen(this);
		introScreen=new IntroScreen(this);
		controllerMain=new ControllerMain(this);
		pantalla=1;
	}

	public void draw() {
		
		
		switch(pantalla){
		case 0:
			introScreen.drawScreen();
			
			if(mouseX>1180&&mouseY>1170&&mouseX<1380&&mouseY<1340) {
				System.out.println("alo");
			}
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
	

		
	}
	
	public void keyReleased() {
		mapaScreen.caminar();
		
	}
	
	

}




