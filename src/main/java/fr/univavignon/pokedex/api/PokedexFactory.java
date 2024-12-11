package fr.univavignon.pokedex.api;

/**
* Factory class for creating instances of the Pokédex.
* Implements the IPokedexFactory interface and provides
* a method for creating a new Pokedex with specified dependencies.
*/
public class PokedexFactory implements IPokedexFactory {

    /**
    * Creates a new instance of the Pokedex.
    * @param metadataProvider The provider responsible for Pokémon metadata (e.g., types, abilities).
    * @param pokemonFactory The factory used to create Pokémon instances.
    * @return A new Pokedex instance, or null if any of the parameters are null.
    */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        if (metadataProvider == null || pokemonFactory == null) {
            return null;
        }
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}

