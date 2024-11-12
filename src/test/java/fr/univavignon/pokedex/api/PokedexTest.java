package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PokedexTest {

    private Pokedex pokedex;

    @BeforeEach
    public void setup() {
        PokemonFactory pokemonFactory = new PokemonFactory();
        IPokemonMetadataProvider metadataProvider = null;
        pokedex = new Pokedex(metadataProvider,pokemonFactory);
    }

    @Test
    void shouldReturnCorrectSize() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90,613,64,4000,4,56);
        pokedex.addPokemon(pokemon);
        assertEquals(pokedex.size(), 1, "La taille du pokédex doit être 1");
    }

    @Test
    void shouldAddPokemonAndReturnIndex() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90,613,64,4000,4,56);
        assertEquals(pokedex.addPokemon(pokemon),0, "L'index du Pokémon ajouté doit être 0");
    }

    @Test
    void shouldGetPokemonById() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90,613,64,4000,4,56);
        pokedex.addPokemon(pokemon);
        assertEquals(pokemon, pokedex.getPokemon(0), "Le Pokémon récupéré doit être Bulbizarre");
    }

}
