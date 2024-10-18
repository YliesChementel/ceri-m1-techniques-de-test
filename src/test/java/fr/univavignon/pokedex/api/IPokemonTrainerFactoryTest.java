package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.plugins.MockMaker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;
import org.mockito.plugins.MockMaker;

public class IPokemonTrainerFactoryTest {

    @Mock
    IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);

    @Test
    void shouldReturnTrainerInstance() throws Exception {
        //when(pokemonTrainerFactory.createTrainer()).thenReturn();
    }

}
