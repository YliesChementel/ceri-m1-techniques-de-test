package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokemonTrainerFactoryTest {

    @Mock
    IPokemonTrainerFactory pokemonTrainerFactory;

    @Mock
    IPokedexFactory pokedexFactory;

    @Mock
    IPokedex pokedex;

    @Test
    void shouldReturnTrainerInstance() throws Exception {
        Team team = Team.MYSTIC;

        PokemonTrainer expectedTrainer = new PokemonTrainer("Sacha", team, pokedex);

        when(pokemonTrainerFactory.createTrainer("Sacha", team, pokedexFactory)).thenReturn(expectedTrainer);

        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", team, pokedexFactory);

        assertNotNull(result, "Le résultat ne doit pas être null");
        assertEquals(expectedTrainer, result, "Le Pokémon Trainer doit être celui attendu");
    }

    @Test
    void shouldReturnNullWhenNameIsNull() throws Exception {
        Team team = Team.MYSTIC;

        when(pokemonTrainerFactory.createTrainer(null, team, pokedexFactory)).thenReturn(null);

        PokemonTrainer result = pokemonTrainerFactory.createTrainer(null, team, pokedexFactory);

        assertNull(result, "Le résultat doit être null si le nom est null");
    }

    @Test
    void shouldReturnNullWhenTeamIsNull() throws Exception {
        when(pokemonTrainerFactory.createTrainer("Sacha", null, pokedexFactory)).thenReturn(null);

        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", null, pokedexFactory);

        assertNull(result, "Le résultat doit être null si l'équipe est null");
    }

    @Test
    void shouldReturnNullWhenPokedexFactoryIsNull() throws Exception {
        Team team = Team.MYSTIC;

        when(pokemonTrainerFactory.createTrainer("Sacha", team, null)).thenReturn(null);

        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", team, null);

        assertNull(result, "Le résultat doit être null si le factory de pokédex est null");
    }
}

