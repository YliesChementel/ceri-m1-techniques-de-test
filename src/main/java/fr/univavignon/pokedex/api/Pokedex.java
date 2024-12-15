package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
* Implementation of the IPokedex interface.
* Manages a collection of Pokémon and provides methods for adding, retrieving,
* and accessing their metadata.
*/
public class Pokedex implements IPokedex {

    /**
    * Provides Pokémon metadata, such as types, abilities, and other related information.
    */
    private IPokemonMetadataProvider metadataProvider;

    /**
    * A factory used to create Pokémon instances with specific attributes.
    */
    private IPokemonFactory pokemonFactory;

    /**
    * List holding all Pokémon in the Pokédex.
    * This list stores the Pokémon objects added to the Pokédex.
    */
    private List<Pokemon> listPokemon = new ArrayList<>();

    /**
    * A list that returns an unmodifiable view of the Pokémon stored in the Pokédex.
    */
    private List<Pokemon> pokemons;

    /**
    * Constructor for Pokedex.
    * @param metadataProvider Provides Pokémon metadata.
    * @param pokemonFactory Creates Pokémon instances.
    */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
    * Returns the number of Pokémon in this Pokédex.
    * @return The number of Pokémon.
    */
    @Override
    public int size() {
        return listPokemon.size();
    }

    /**
    * Adds a Pokémon to the Pokédex and returns its unique index.
    * @param pokemon The Pokémon to add.
    * @return The Pokémon's index.
    */
    @Override
    public int addPokemon(Pokemon pokemon) {
        listPokemon.add(pokemon);
        return listPokemon.size() - 1;
    }

    /**
    * Retrieves a Pokémon by its ID.
    * @param id The unique ID of the Pokémon.
    * @return The Pokémon with the specified ID.
    * @throws PokedexException If the ID is invalid.
    */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= listPokemon.size()) {
            throw new PokedexException("Invalid ID");
        }
        return listPokemon.get(id);
    }

    /**
    * Returns an unmodifiable list of all Pokémon in the Pokédex.
    * @return The list of Pokémon.
    */
    @Override
    public List<Pokemon> getPokemons() {
        pokemons = Collections.unmodifiableList(listPokemon);
        return pokemons;
    }

    /**
    * Returns an unmodifiable, sorted list of Pokémon based on the given comparator.
    * @param order The comparator to sort the Pokémon.
    * @return The sorted list of Pokémon.
    */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(listPokemon);
        sortedPokemons.sort(order);
        return Collections.unmodifiableList(sortedPokemons);
    }

    /**
    * Creates a Pokémon with the given attributes.
    * @param index The Pokémon's index.
    * @param cp The CP value.
    * @param hp The HP value.
    * @param dust The dust value.
    * @param candy The candy value.
    * @return The created Pokémon.
    */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
    * Retrieves the metadata for a Pokémon.
    * @param index The Pokémon's index.
    * @return The Pokémon's metadata.
    * @throws PokedexException If the index is invalid.
    */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}

