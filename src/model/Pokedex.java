package model;

import processing.core.PApplet;

public class Pokedex implements Comparable<Pokedex> {

	private int posX, posY;
	private String nombre, tipo, numero;

	public Pokedex(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;

	}

	@Override
	public int compareTo(Pokedex p) {
		return nombre.compareTo(p.getNombre());
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

