package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PokedexFactoryTest {

    @Test
    void shouldCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();

        PokedexFactory pokedexFactory = new PokedexFactory();

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertInstanceOf(Pokedex.class, pokedex);
    }

}
