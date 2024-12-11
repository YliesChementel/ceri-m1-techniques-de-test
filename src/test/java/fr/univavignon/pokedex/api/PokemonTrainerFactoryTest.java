package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTrainerFactoryTest {

    private PokemonTrainerFactory pokemonTrainerFactory;
    private PokedexFactory pokedexFactory;
    private Pokedex pokedex;

    @BeforeEach
    void setUp() {
        // Instanciation des objets réels, pas de mocks
        pokemonTrainerFactory = new PokemonTrainerFactory(new PokemonMetadataProvider(), new PokemonFactory());
        pokedexFactory = new PokedexFactory();
        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
    }

    @Test
    void shouldReturnTrainerInstance() throws Exception {
        Team team = Team.MYSTIC;

        PokemonTrainer expectedTrainer = new PokemonTrainer("Sacha", team, pokedex);

        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", team, pokedexFactory);

        assertNotNull(result);
        assertEquals(expectedTrainer.getName(), result.getName());
        assertEquals(expectedTrainer.getTeam(), result.getTeam());
    }

    @Test
    void shouldReturnNullWhenNameIsNull() throws Exception {
        Team team = Team.MYSTIC;

        PokemonTrainer result = pokemonTrainerFactory.createTrainer(null, team, pokedexFactory);

        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenTeamIsNull() throws Exception {
        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", null, pokedexFactory);

        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenPokedexFactoryIsNull() throws Exception {
        Team team = Team.MYSTIC;

        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", team, null);

        assertNull(result);
    }
}

