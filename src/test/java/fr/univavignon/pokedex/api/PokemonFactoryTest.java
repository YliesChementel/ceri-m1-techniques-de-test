package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PokemonFactoryTest {

    private PokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    void shouldCreatePokemonInstance() {
        int index = 1;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertEquals(index, pokemon.getIndex());
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }

}
