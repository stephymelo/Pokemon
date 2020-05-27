package model;

import java.util.Comparator;

public class PokedexTipo implements Comparator<Pokedex> {

	@Override
	public int compare(Pokedex p1, Pokedex p2) {

		return p2.getTipo().compareTo(p1.getTipo());

	}

}
