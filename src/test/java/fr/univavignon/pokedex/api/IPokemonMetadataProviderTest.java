package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

    @Test
    void shouldReturnMetadataOfBulbizarre() throws Exception {
        PokemonMetadata pokemonMetadataBulbi = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadataBulbi);

        PokemonMetadata result = pokemonMetadataProvider.getPokemonMetadata(0);

        assertEquals(pokemonMetadataBulbi, result);
    }

    @Test
    void shouldReturnNullForNonExistentPokemon() throws Exception {
        when(pokemonMetadataProvider.getPokemonMetadata(999)).thenReturn(null);

        PokemonMetadata result = pokemonMetadataProvider.getPokemonMetadata(999);

        assertNull(result);
    }


}
