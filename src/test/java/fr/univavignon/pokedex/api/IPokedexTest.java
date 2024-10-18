package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.plugins.MockMaker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;
import org.mockito.plugins.MockMaker;


public class IPokedexTest {

    @Mock
    IPokedex pokedex = Mockito.mock(IPokedex.class);

    @Test
    void shouldReturnSizeOfPokemon() throws Exception {
        Pokemon pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
        //when(pokedex.size()).thenReturn(pokemon);
    }

}
