package view;
import processing.core.PApplet;

public class MainView extends PApplet {
	private MapaScreen mapaScreen; 
	private IntroScreen introScreen;
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
		System.out.println(mouseX+"mouseX"+mouseY+"mouseY");
		
		
		
		if(pantalla==0) {
			if(mouseX>480&&mouseY>670&&mouseX<710&&mouseY<750 &&introScreen.getPantallaIntro()==0) {
				introScreen.setPantallaIntro(1);
					
		}
		if(mouseX>230&&mouseY>30&&mouseX<455&&mouseY<570) {
			introScreen.setPantallaIntro(2);
			introScreen.setGirlClick(true);
		}
		if(mouseX>800&&mouseY>30&&mouseX<1045&&mouseY<570) {
			introScreen.setPantallaIntro(2);
			introScreen.setBoyClick(true);
		}
		if(mouseX>900&&mouseY>700&&mouseX<1115&&mouseY<750&&introScreen.getPantallaIntro()==2) {
			introScreen.setPantallaIntro(3);
			return;
		}
		if(mouseX>970&&mouseY>700&&mouseX<1155&&mouseY<750&&introScreen.getPantallaIntro()==3) {
			introScreen.setPantallaIntro(4);
			return;
		}
		if(mouseX>970&&mouseY>700&&mouseX<1155&&mouseY<750&&introScreen.getPantallaIntro()==4) {
			introScreen.setPantallaIntro(5);
			return;
		}
		if(mouseX>970&&mouseY>700&&mouseX<1155&&mouseY<750&&introScreen.getPantallaIntro()==5) {
			introScreen.setPantallaIntro(6);
			return;
		}
		if(mouseX>970&&mouseY>700&&mouseX<1155&&mouseY<750&&introScreen.getPantallaIntro()==6) {
			introScreen.setPantallaIntro(7);
			return;
		}
		if(mouseX>970&&mouseY>700&&mouseX<1155&&mouseY<750&&introScreen.getPantallaIntro()==7) {
			pantalla=1;
			return;
		}
		}
	}
	
	
	
	public void keyPressed() {
		mapaScreen.jugadorCaminando();
	
		
//		switch(keyCode) {
//		case LEFT:
//			
//			break;
//		case RIGHT:
//			
//			break;
//		case UP:
//			mapaScreen.jugador();
//			
//			
//			break;
//		case DOWN:
//			
//			break;
//		}
		
	}
	
	public void keyReleased() {
		mapaScreen.caminar();
		
	}
	
	

}




