package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static final Map<Integer, PokemonMetadata> INDEXTOMETADATA;

    static {
        Map<Integer, PokemonMetadata> aMap = new HashMap<>();

        aMap.put(1, new PokemonMetadata(1, "Bulbizarre", 49, 49, 45));
        aMap.put(133, new PokemonMetadata(133, "Aquali", 60, 65, 85));

        INDEXTOMETADATA = UnmodifiableMap.unmodifiableMap(aMap);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata pokemonMetadata = INDEXTOMETADATA.get(index);
        if (pokemonMetadata == null) {
            throw new PokedexException("Index invalide");
        }
        return pokemonMetadata;
    }

}
