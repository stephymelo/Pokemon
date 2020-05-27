package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario implements Comparable<Usuario> {

	private String username, fecha;

	public Usuario(String username, String fecha) {
		this.username = username;
		this.fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

	}
	
	@Override
	public int compareTo(Usuario u) {
		return fecha.compareTo(u.getUsername());
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getUsername() {
		return username;

	}

	public void setUsername(String username) {
		this.username = username;
	}

}
