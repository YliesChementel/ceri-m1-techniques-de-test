package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.plugins.MockMaker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Mock
    IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

    @Test
    void shouldReturnInstanceOfPokemon() throws Exception {
        //when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn();
    }
}
