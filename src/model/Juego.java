package model;


import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

import java.util.ArrayList;
import java.util.LinkedList;

import model.Pokemon;

public class Juego {
	private PApplet app;
	private Jugador jugador;
	private Jugador jugadorBatalla;
	private Pokemon pokemones;
	private Inicial pokemonInicial;
	private Salvaje pokemonSalvaje;
	private Salvaje pokemonSalvajeBatalla;



	private ArrayList<Pokemon> pokemonUsers;

	private int pintarPokemon;

	private int matX, matY;

	private double varCaptura;
	private boolean intentoCaptura;
	private int posXMatriz, posYMatriz;
	private int turno;
	private boolean ataque, ataqueRival;
	private boolean combate;
	private boolean encontroPokemon,mostrarPokemon,atacando,mostrarPoder;
	


	private int mapa[][] = { { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, 
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, 
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2 }, 
			{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, };

	public Juego(PApplet app) {
		this.app = app;
		
		
		jugador = new Jugador(app, 50, 150);

		pokemonUsers=new ArrayList<Pokemon>();
        mostrarPokemon=false;
        mostrarPoder=true;
		this.encontroPokemon=false;
		pokemonSalvaje = new Salvaje("wooloo", "./imagenes/pokemones/wooloo.png", "noexiste", 5, 450, app);
		pokemonSalvajeBatalla=null;

		this.posXMatriz = 100;
		this.posYMatriz = 50;

		this.matY = 0; // filas hacia abajo
		this.matX = 3; // columnas hacia horizantal

		this.varCaptura = 0;
		this.intentoCaptura = false;

		this.turno = 0;
		this.combate = false;
		this.ataque = false;
		this.ataqueRival = false;
		this.atacando=false;
		

	}

	public void jugadores() {
		jugador.pintarJugador();

	}

	public void caminar() {

		jugador.caminar(app);
		verificarJugador();


	}

	
	
	
	public void batalla() {
		
		//clic y cambiar turno
		
		
		pokemonSalvajeBatalla.mostrarVida(250, 155);
		pokemonInicial.mostrarVida(852, 468);
		
		switch(turno) {
		case 1:
		
			//mostrarPoderes=dar clic en boton poder pasar atacando a true y turno =2 
			pokemonSalvajeBatalla.setPosX( 800);
			pokemonSalvajeBatalla.setPosY(250);
			pokemonInicial.setPosX(277);
			pokemonInicial.setPosY(420);
		
			
			
			
			
			break;
		case 2:
			
			
			
			
			
			
			
			if(atacando==false) {
				//mostrarPoder
			}else {
				turno=2;
			}
			
		case 3:
			//atacandoMi
			pokemonSalvajeBatalla.setPosX(app.width/2-100);
			pokemonSalvajeBatalla.setPosY(app.height/2+100);
			pokemonInicial.setPosX(app.width/2+100);
			pokemonInicial.setPosY(app.height/2-100);
//			}
			System.out.println(pokemonInicial.getVida());
//atacando
			
			
			//  if( frameRate){
			
			
		
	
			//hacer metodo de reiniciarPosiciones batalla
		
			if(atacando) {
				pokemonSalvajeBatalla.setVida(pokemonSalvajeBatalla.getVida()-10);
				atacando=false;
				turno=1;
				break;
			}else {
				pokemonInicial.setVida(pokemonInicial.getVida()-10);
				atacando=true;
				turno=1;
				break;
				
			}
			
		case 4:
			break;
			
		}
		
		if(pokemonSalvajeBatalla.getVida()<=0) {
			mostrarPokemon=false;
			
		}
		
	}
	
	
	
	

	
	
	
	
	public void batallaPintar() {
		pokemonSalvajeBatalla.pintar(this.pokemonSalvaje.getPokemonImagenAdelante());
		pintarPokemonInicial();
		
	}
	


	public void pintarPokemonSalvaje() {
		jugadorPasto();
		pokemonSalvaje.pintar(this.pokemonSalvaje.getPokemonImagenAdelante());

		if(pokemonSalvaje.isEnPasto()==true) {
			new Thread(pokemonSalvaje).start();
		}
	}



	public void pintarMapa() {
		for (int fila = 0; fila < 16; fila++) {
			for (int col = 0; col < 12; col++) {
				app.fill(mapa[fila][col] == 0 ? 150 : mapa[fila][col] == 2 ? 100 : mapa[fila][col] == 1 ? 255 : 0);
				app.rect(col * 100, fila * 50, 100, 50);

			}
		}




	}


	public void escogerGenero(int generoChoose) {
		jugador.setGenero(generoChoose);

	}

	public void verificarJugador() {
	

		switch (app.keyCode) {

		case PConstants.LEFT:
			if (matY-1>=0) {
				if (mapa[matX][matY - 1] != 0) {
					matY -= 1;
					jugador.setPosX(jugador.getPosX() - 100);

				}
			}

			break;
		case PConstants.RIGHT:

			//			System.out.println(matY + 1);
			if (matY + 1 < 12) {

				if (mapa[matX][matY + 1] != 0) {
					matY += 1;
					jugador.setPosX(jugador.getPosX() + 100);
				}

			}
			break;

		case PConstants.UP:
			if (matX - 1 > 0) {
				if (mapa[matX - 1][matY] != 0) {
					matX -= 1;
					jugador.setPosY(jugador.getPosY() - 100);
				}
			}
			break;
		case PConstants.DOWN:
			if (matX+1<16) {
				if (mapa[matX + 1][matY] != 0) {
					matX += 1;
					jugador.setPosY(jugador.getPosY() + 100);
					
					





				}
			}
			break;

		}
		

	}



	public void jugadorPasto() {
	
			pokemonSalvaje.setEnPasto(true);
		

		if (pokemonSalvaje.getPosY()<450+100) {


			pokemonSalvaje.setDirY(1);

		}

		if (pokemonSalvaje.getPosY()>748-100) {

			pokemonSalvaje.setDirY(-1);

		}
		if (pokemonSalvaje.getPosX()>395-100) {
			pokemonSalvaje.setDirX(-1);


		}

		if (pokemonSalvaje.getPosX()<5+100) {
			pokemonSalvaje.setDirX(1);


		}


		



//		for (int i = 0; i < 16; i++) {
//			for (int j = 0; j < 12; j++) {
//				if(mapa[i][j] == 2) {
//
//					if ((jugador.getPosX() > (j * 50)-50 && jugador.getPosX() < (j * 50)+50
//							&& jugador.getPosY() > (i * 50) - 50 && jugador.getPosY() < (i * 50) + 50) ) {
//						//					System.out.println("jugadorAdentro");
//						//					pokemonSalvaje.setEnPasto(true);
//					}else {
//						//					pokemonSalvaje.setEnPasto(false);


		}






	public void encontrarPokemon() {
		if(PApplet.dist(jugador.getPosX(),jugador.getPosY(), pokemonSalvaje.getPosX(),pokemonSalvaje.getPosY())<100) {
			encontroPokemon=true;

		}
		
		if(encontroPokemon==true) {
			pokemonSalvaje.setEnPasto(false);
			if(pokemonSalvajeBatalla==null) {
				pokemonSalvajeBatalla=new Salvaje("wooloo", "./imagenes/pokemones/wooloo.png", "noexiste", 850, 250, app);
			}
		}
		
	}



	public void verificarClicks() {
		System.out.println(app.mouseX + " " + app.mouseY);
		
		if(PApplet.dist(app.mouseX,app.mouseY,700, 650)<100) {
			mostrarPoder=true;
			turno=1;
		}
		if(PApplet.dist(app.mouseX,app.mouseY,300, 650)<100) {
			atacando=true;
			turno=2;
		}
		
		

	}

	public void escogerPokemon(String id) {
		if (id.toLowerCase().trim().equals("agua")) {

			this.pintarPokemon = 1;
			//			pokemonUsers.add(pokemonInicial = new Inicial(id, "./imagenes/pokemones/sobbleDelante.png",
			//					"./imagenes/pokemones/sobbleAtras.png", 10, 10, app));


			pokemonInicial = new Inicial(id, "./imagenes/pokemones/sobbleDelante.png",
					"./imagenes/pokemones/sobbleAtras.png", 277, 430, app);

		}
		if (id.toLowerCase().trim().equals("fuego")) {

			this.pintarPokemon = 2;

			pokemonInicial = new Inicial(id, "./imagenes/pokemones/scorbunnyDelante.png",
					"./imagenes/pokemones/scorbunnyAtras.png", 277, 430, app);

		}
		if (id.toLowerCase().trim().equals("hierba")) {

			this.pintarPokemon = 3;

			pokemonInicial = new Inicial(id, "./imagenes/pokemones/grookeyDelante.png",
					"./imagenes/pokemones/grookeyAtras.png",277, 430, app);
			

		}

	}

	public void pintarPokemonInicial() {
		switch (pintarPokemon) {
		case 1:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
			
			break;

		case 2:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
		
			break;
		case 3:

			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAtras());
			
			

			break;
		}

	}
	
	public void pintarPoder() {
		switch (pintarPokemon) {
		case 1:

		
			if(mostrarPoder=true) {
				  app.fill(255,255,250);
				  app.textSize(30);
					app.text("Sooble",400,400);
			}
			
			break;

		case 2:

		
			if(mostrarPoder=true) {
			  app.fill(255,255,250);
			  app.textSize(30);
				app.text("Scorbunny",400,400);
			}
			break;
		case 3:

			
			if(mostrarPoder=true) {
            app.fill(255,255,250);
            app.textSize(30);
			app.text("Grookey",400,400);
			}

			break;
		}

	}
	
	
	
	
	
	
	
	
	
	

	public void pintarPokemonInicialVS() {
		switch (pintarPokemon) {
		case 1:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAdelante());

			break;

		case 2:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAdelante());
			

			break;
		case 3:
			pokemonInicial.pintar(this.pokemonInicial.getPokemonImagenAdelante());
			

			break;
		}
	}


	public void randomicosDeCaptura() {

		// poner arreglo de pokemones (for) aquí

		if (this.intentoCaptura == true) {

			this.varCaptura = Math.floor(Math.random() * 100 + 1);

			// pokemon full vida
			if (this.pokemones.getVida() >= 20) {

				if (this.varCaptura >= 95) {

					// pokemon escapa del combate
				}

				if (this.varCaptura <= 94 && this.varCaptura >= 40) {

					// pokemon no es capturado
				}

				if (this.varCaptura < 40) {

					// pokemon es capturado
				}

			}

			// pokemon mitad de vida
			if (this.pokemones.getVida() < 5 && this.pokemones.getVida() >= 10) {

				if (this.varCaptura >= 97) {

					// pokemon escapa del combate
				}

				if (this.varCaptura <= 96 && this.varCaptura >= 70) {

					// pokemon no es capturado
				}

				if (this.varCaptura < 70) {

					// pokemon es capturado
				}

			}

			// pokemon poca vida
			if (this.pokemones.getVida() >= 5) {

				if (this.varCaptura >= 98) {

					// pokemon escapa del combate
				}

				if (this.varCaptura <= 97 && this.varCaptura >= 90) {

					// pokemon no es capturado
				}

				if (this.varCaptura < 90) {

					// pokemon es capturado
				}

			}
		}
	}

	public void ataqueDePokemon() {
		if (this.combate == true) {
			this.turno = 1;
			switch (turno) {
			case 1:
				if (this.ataque == true) {
					//					this.pokemones.setVida(vida) = this.pokemones.setVida(vida) - this.pokemones.getDano();
					this.ataque = false;
					this.turno = 2;
				}
				break;
			case 2:
				this.ataqueRival = true;
				if (this.ataqueRival == true) {
					//					this.pokemones.setVida(vida) = this.pokemones.setVida(vida) - this.pokemones.getDano();
					this.ataqueRival = false;
					this.turno = 1;
				}
				break;
			}
		}
	}

	public int getPosXMatriz() {
		return posXMatriz;
	}

	public void setPosXMatriz(int posXMatriz) {
		this.posXMatriz = posXMatriz;
	}

	public int getPosYMatriz() {
		return posYMatriz;
	}

	public void setPosYMatriz(int posYMatriz) {
		this.posYMatriz = posYMatriz;
	}

	public boolean isEncontroPokemon() {
		return encontroPokemon;
	}

	public void setEncontroPokemon(boolean encontroPokemon) {
		this.encontroPokemon = encontroPokemon;
	}

	

}
