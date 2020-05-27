package model;

import java.util.Comparator;

public class UsuarioFecha implements Comparator <Usuario>{

	public UsuarioFecha() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Usuario u1, Usuario u2) {
		return u1.getFecha().compareTo(u2.getFecha());
	}

}
