package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;

/**
* Provides metadata for Pokémon, mapping their index to their metadata.
* This class ensures that the metadata for each Pokémon can be retrieved
* based on the Pokémon's index, throwing an exception if the index is invalid.
*/
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /**
    * A map linking Pokémon index to their respective metadata.
    * This map is unmodifiable to prevent modification.
    */
    private static final Map<Integer, PokemonMetadata> INDEXTOMETADATA;

    static {
        Map<Integer, PokemonMetadata> aMap = new HashMap<>();

        aMap.put(1, new PokemonMetadata(1, "Bulbizarre", 49, 49, 45));
        aMap.put(133, new PokemonMetadata(133, "Aquali", 60, 65, 85));

        INDEXTOMETADATA = UnmodifiableMap.unmodifiableMap(aMap);
    }

    /**
    * Retrieves the metadata for a Pokémon based on its index.
    * @param index The unique index of the Pokémon.
    * @return The metadata associated with the given Pokémon index.
    * @throws PokedexException If the Pokémon index is invalid or not found.
    */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata pokemonMetadata = INDEXTOMETADATA.get(index);
        if (pokemonMetadata == null) {
            throw new PokedexException("Invalid index");
        }
        return pokemonMetadata;
    }

}
