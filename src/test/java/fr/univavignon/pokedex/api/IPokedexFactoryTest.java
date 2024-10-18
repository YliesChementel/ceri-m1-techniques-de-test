package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
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

        IPokedex result = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        assertTrue(result instanceof IPokedex, "Doit retourner une instance de IPokedex");
    }

    @Test
    void shouldReturnNullWhenMetadataProviderIsNull() throws Exception {
        when(pokedexFactory.createPokedex(null, pokemonFactory)).thenReturn(null);

        IPokedex result = pokedexFactory.createPokedex(null, pokemonFactory);

        assertNull(result, "Doit retourner null si le fournisseur de métadonnées est null");
    }

    @Test
    void shouldReturnNullWhenPokemonFactoryIsNull() throws Exception {
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, null)).thenReturn(null);

        IPokedex result = pokedexFactory.createPokedex(pokemonMetadataProvider, null);

        assertNull(result, "Doit retourner null si la fabrique de Pokémon est null");
    }
}
