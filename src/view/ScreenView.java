package view;

import model.Juego;
import processing.core.PApplet;

 abstract class ScreenView {
	protected PApplet app;


 
 public ScreenView(PApplet app,Juego juego) {
	 this.app=app;
	 
 }
 
 
}