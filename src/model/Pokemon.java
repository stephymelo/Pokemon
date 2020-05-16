package model;

public abstract class Pokemon {
	protected int posX,posY;
	protected int dano;
	protected float vida;
	protected String id;
	
	
	public Pokemon(String id, int posX,int posY) {
		this.id=id;
		this.posX=posX;
		this.posY=posY;
		
		
	}
	
	public void atacar() {
		
	}
	
	public void morir() {
		
	}
	
	public void defensa() {
		
	}
	
	

}
