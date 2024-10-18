package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.plugins.MockMaker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

    @Mock
    IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

    @Mock
    IPokedex pokedex;

    @Test
    void shouldReturnInstanceOfIPokedex() throws Exception {
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
        assertNotNull(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
    }
}
