package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static fr.univavignon.pokedex.api.Team.INSTINCT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PokemonTrainerTest {

    private PokemonTrainer pokemonTrainer;
    private Pokedex pokedex;

    @BeforeEach
    public void setup() {
        PokemonFactory pokemonFactory = new PokemonFactory();
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        pokedex = new Pokedex(metadataProvider,pokemonFactory);
        pokemonTrainer = new PokemonTrainer("Sacha",INSTINCT,pokedex);
    }

    @Test
    void shouldReturnNameofTrainer() throws Exception {
        assertEquals(pokemonTrainer.getName(), "Sacha");
    }

    @Test
    void shouldReturnTeamofTrainer() throws Exception {
        assertEquals(pokemonTrainer.getTeam(), INSTINCT);
    }

    @Test
    void shouldReturnPokedexofTrainer() throws Exception {
        assertEquals(pokemonTrainer.getPokedex(), pokedex);
    }
}
