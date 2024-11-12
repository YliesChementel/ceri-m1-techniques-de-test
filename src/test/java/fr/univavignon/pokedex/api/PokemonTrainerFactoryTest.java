package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class PokemonTrainerFactoryTest {

    PokemonTrainerFactory pokemonTrainerFactory;

    PokedexFactory pokedexFactory;

    Pokedex pokedex;

    @BeforeEach
    void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory(null,new PokemonFactory());
        pokedexFactory = new PokedexFactory();
        pokedex = new Pokedex(null,new PokemonFactory());
    }

    @Test
    void shouldReturnTrainerInstance() throws Exception {
        Team team = Team.MYSTIC;

        PokemonTrainer pokemonTrainer = new PokemonTrainer("Sacha", team, pokedex);
        PokemonTrainer pokemonTrainerCreated = pokemonTrainerFactory.createTrainer("Sacha", team, pokedexFactory);

        assertNotNull(pokemonTrainerCreated);
        assertEquals(pokemonTrainer.getName(), pokemonTrainerCreated.getName());
        assertEquals(pokemonTrainer.getTeam(), pokemonTrainerCreated.getTeam());
    }

}
