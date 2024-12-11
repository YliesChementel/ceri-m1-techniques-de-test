package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PokedexFactoryTest {

    private PokedexFactory pokedexFactory;
    private PokemonFactory pokemonFactory;
    private PokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setup() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    void shouldReturnInstanceOfIPokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertInstanceOf(Pokedex.class, pokedex);
    }

    @Test
    void shouldReturnNullWhenMetadataProviderIsNull() throws Exception {

        IPokedex pokedex = pokedexFactory.createPokedex(null, pokemonFactory);

        assertNull(pokedex, "Doit retourner null si le fournisseur de métadonnées est null");
    }

    @Test
    void shouldReturnNullWhenPokemonFactoryIsNull() throws Exception {

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, null);

        assertNull(pokedex, "Doit retourner null si la fabrique de Pokémon est null");
    }

}
