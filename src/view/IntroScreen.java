package view;

import controlP5.ControlP5;

import java.text.SimpleDateFormat;
import java.util.Date;
import controlP5.Textfield;
import controller.ControllerMain;
import model.Juego;
import processing.core.PFont;
import processing.core.PSurfaceNone.AnimationThread;
import processing.core.PApplet;
import processing.core.PImage;

public class IntroScreen extends ScreenView {
	private PImage start,starthover,gender,genderGirl,genderBoy,userGirl,userBoy,continueButton,professor,professorDos;
	private PImage pokemonSelect,pokemonBlue,pokemonWhite,pokemonGreen,professorRival,professorFinal,rivalPantalla;
	private int pantallaIntro;
	private ControlP5 cp5;
	private String input,username,fecha;
	private PFont pixel;
	
	private ControllerMain controller;
	
	
	private String agua,hierba,fuego;
	
	
	private boolean girlClick,boyClick;
	
	public IntroScreen(PApplet app,Juego juego){
		super(app,juego);
		
		cp5 = new ControlP5(app);
		
		controller=new ControllerMain(app,juego);
		
		this.agua="agua";
		this.fuego="fuego";
		this.hierba="hierba";
	
		
		this.start=app.loadImage("imagenes/start.png");
		this.starthover=app.loadImage("imagenes/startMouse.png");
		this.gender=app.loadImage("imagenes/chooseGender.png");
		this.genderGirl=app.loadImage("imagenes/chooseGirl.png");
		this.genderBoy=app.loadImage("imagenes/chooseBoy.png");
		this.userBoy=app.loadImage("imagenes/usernameBoy.png");
		this.userGirl=app.loadImage("imagenes/usernameGirl.png");
		this.continueButton=app.loadImage("imagenes/continueButton.png");
		this.professor=app.loadImage("imagenes/introprofesor.png");
		this.professorDos=app.loadImage("imagenes/introprofesorDos.png");
		this.pokemonSelect=app.loadImage("imagenes/seleccionarPokemon.png");
		this.pokemonBlue=app.loadImage("imagenes/seleccionarAZUL.png");
		this.pokemonWhite=app.loadImage("imagenes/seleccionarBlanco.png");
		this.pokemonGreen=app.loadImage("imagenes/seleccionarVerde.png");
		this.professorRival=app.loadImage("imagenes/introprofesorTres.png");
		this.professorFinal=app.loadImage("imagenes/introprofesorCuatro.png");
		this.rivalPantalla=app.loadImage("imagenes/rivalPantalla.png");
		this.girlClick=false;
		this.boyClick=false;
		this.pantallaIntro=0;
		
		this.pixel = app.createFont("pokemon_pixel_font.ttf", 14);
		PFont pixel = app.createFont("pokemon_pixel_font.ttf", 16);
		
		
		this.input = "username";
		this.fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		

			cp5.addTextfield(input).setPosition(500, 700).setSize(200, 30).setAutoClear(true)
					.setColorValue(app.color(0)).setColorBackground(app.color(0, 0, 0, 1)).setFont(pixel)
					.setColorActive(app.color(0)).setColorForeground(app.color(0)).getCaptionLabel().hide();

		}
		
	
	
	public void drawScreen(){
if(pantallaIntro!=2) {
	this.username = cp5.get(Textfield.class, "username").setVisible(false).getText();
}
	
		switch(pantallaIntro) {
		case 0:
		app.image(start,0,0);
		
		if(app.mouseX>480&&app.mouseY>670&&app.mouseX<710&&app.mouseY<750) {
		
			app.image(starthover,0,0);
		}
		break;
		case 1:
			app.image(gender, 0, 0);

			if(app.mouseX>230&&app.mouseY>30&&app.mouseX<455&&app.mouseY<570) {
				app.image(genderGirl,0,0);
			}
			if(app.mouseX>800&&app.mouseY>30&&app.mouseX<1045&&app.mouseY<570) {
				app.image(genderBoy,0,0);
			}
			break;
		case 2:
			if(girlClick) {
				app.image(userGirl,0,0);
			}
			if(boyClick) {
				app.image(userBoy,0,0);
			}
			
			app.image(continueButton,900,700);
			this.username = cp5.get(Textfield.class, "username").setVisible(true).getText();
			
			break;
		case 3:
			app.image(professor,0,0);
			app.image(continueButton,970,700);
			
			break;
		case 4:
			app.image(professorDos,0,0);
			app.image(continueButton,970,700);
			
			break;
		case 5:
			app.image(pokemonSelect,0,0);
			if(app.mouseX>900&&app.mouseY>130&&app.mouseX<1155&&app.mouseY<570) {
				app.image(pokemonBlue,0,0);
				
				

				
			}
			if(app.mouseX>490&&app.mouseY>60&&app.mouseX<720&&app.mouseY<530) {
				app.image(pokemonWhite,0,0);
				
		
			}
			
			if(app.mouseX>90&&app.mouseY>170&&app.mouseX<300&&app.mouseY<570) {
				app.image(pokemonGreen,0,0);
				
		
			}
			
			
			break;
		case 6:
			app.image(professorRival,0,0);
			app.image(continueButton,970,700);
			
			break;
		case 7:
			app.image(rivalPantalla,0,0);
			app.image(continueButton,490,720);
			
			break;
		case 8:
			app.image(professorFinal,0,0);
			
			break;
			
	}
	}

	
	
	
	
	
	public void getInfoForm() {
		String[] user;
		user = new String [2];
		user[0]=username;
		user[1]=fecha;
		
		for (int i = 0; i < user.length; i++) {
			user[i]=username+" "+fecha;
			
		}
		
		if(app.mouseX>900&&app.mouseY>700&&app.mouseX<1115&&app.mouseY<750&&pantallaIntro==2) {
			
			username = cp5.get(Textfield.class, "username").getText();
			
			app.saveStrings("./usuariosTXT/userRegister.txt",user);
			
//			System.out.print(username+fecha);
			
			pantallaIntro=3;
			return;
		}
		
	}
	
	
	public void mouseClick() {
		
		if(app.mouseX>480&&app.mouseY>670&&app.mouseX<710&&app.mouseY<750 &&pantallaIntro==0) {
			setPantallaIntro(1);
				
	}
	if(app.mouseX>230&&app.mouseY>30&&app.mouseX<455&&app.mouseY<570&&pantallaIntro==1) {
		pantallaIntro=2;
		controller.escogerGenero(0);
		girlClick=true;
	}
	if(app.mouseX>800&&app.mouseY>30&&app.mouseX<1045&&app.mouseY<570&&pantallaIntro==1) {
		pantallaIntro=2;
		controller.escogerGenero(1);
	     boyClick=true;
	}
	
	if(app.mouseX>970&&app.mouseY>700&&app.mouseX<1155&&app.mouseY<750&&pantallaIntro==3) {
		pantallaIntro=4;
		return;
	}
	if(app.mouseX>970&&app.mouseY>700&&app.mouseX<1155&&app.mouseY<750&&pantallaIntro==4) {
		pantallaIntro=5;
		return;
	}
	//CHOOSE POKEMON
	
	if(pantallaIntro==5) {
		//azul
	if(app.mouseX>900&&app.mouseY>130&&app.mouseX<1155&&app.mouseY<570) {
		pantallaIntro=6;
		controller.escogerPokemon(agua);
		return;
	}
	//blanco
	if(app.mouseX>490&&app.mouseY>60&&app.mouseX<720&&app.mouseY<530) {
		pantallaIntro=6;
		controller.escogerPokemon(fuego);
		return;
	}
	//verde
	if(app.mouseX>90&&app.mouseY>170&&app.mouseX<300&&app.mouseY<570) {
		pantallaIntro=6;
		controller.escogerPokemon(hierba);
		return;
		
	}
	}
	
	
	if(app.mouseX>970&&app.mouseY>700&&app.mouseX<1155&&app.mouseY<750&&pantallaIntro==6) {
		pantallaIntro=7;
		return;
	}
	
	
	
}

	
	
	
	
	
	
	public int getPantallaIntro() {
		return pantallaIntro;
	}

	public void setPantallaIntro(int pantallaIntro) {
		this.pantallaIntro = pantallaIntro;
	}



	public boolean isGirlClick() {
		return girlClick;
	}



	public void setGirlClick(boolean girlClick) {
		this.girlClick = girlClick;
	}



	public boolean isBoyClick() {
		return boyClick;
	}



	public void setBoyClick(boolean boyClick) {
		this.boyClick = boyClick;
	}
	
	
	
	
	
	
}