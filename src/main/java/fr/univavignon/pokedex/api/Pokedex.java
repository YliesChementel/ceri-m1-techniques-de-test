package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private List<Pokemon> listPokemon = new ArrayList<>();
    private List<Pokemon> pokemons;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return listPokemon.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        listPokemon.add(pokemon);
        return listPokemon.size() - 1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= listPokemon.size()) {
            throw new PokedexException("Invalid ID");
        }
        return listPokemon.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        pokemons = Collections.unmodifiableList(listPokemon);
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> pokemons = new ArrayList<>(listPokemon);
        pokemons.sort(order);
        return Collections.unmodifiableList(pokemons);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
