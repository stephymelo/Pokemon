package model;

import java.util.Comparator;

public class PokedexTipo implements Comparator <Pokedex> {

	@Override
	public int compare(Pokedex o1, Pokedex o2) {
//		return (o1.getTipo().compareTo(o2.getTipo()));
		return 0;
	}

}
