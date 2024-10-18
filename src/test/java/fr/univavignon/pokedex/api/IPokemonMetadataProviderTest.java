package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;
import org.mockito.plugins.MockMaker;


public class IPokemonMetadataProviderTest {

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Test
    void shouldReturnMetadataOfBulbizarre() throws Exception {
        PokemonMetadata pokemonMetadataBulbi = new PokemonMetadata(0,"Bulbizarre",126,126,90);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadataBulbi);
    }
}
