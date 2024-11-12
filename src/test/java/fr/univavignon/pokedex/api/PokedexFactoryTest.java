package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PokedexFactoryTest {
    private PokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        // Initialisation de l'instance de PokemonFactory avant chaque test
        pokemonFactory = new PokemonFactory();
    }

    @Test
    void shouldCreatePokemonWithValidIndex() {
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

    @Test
    void shouldCreatePokemonWithValidStats() {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);

        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 1000);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 1000);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 1000);
    }

}
