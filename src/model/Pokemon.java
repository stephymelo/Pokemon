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

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public float getVida() {
		return vida;
	}

	public void setVida(float vida) {
		this.vida = vida;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
