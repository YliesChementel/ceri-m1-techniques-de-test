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
        // Définir les entrées pour la création du Pokémon
        Team team = Team.MYSTIC;

        // Création d'un Pokémon Trainer attendu
        PokemonTrainer expectedTrainer = new PokemonTrainer("Sacha", team, pokedex);

        // Création d'un Pokémon Trainer via la factory
        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", team, pokedexFactory);

        // Vérification des résultats
        assertNotNull(result, "Le Pokémon Trainer créé ne doit pas être null");
        assertEquals(expectedTrainer.getName(), result.getName(), "Les noms doivent être identiques");
        assertEquals(expectedTrainer.getTeam(), result.getTeam(), "Les équipes doivent être identiques");
    }

    @Test
    void shouldReturnNullWhenNameIsNull() throws Exception {
        Team team = Team.MYSTIC;

        // Tester la création avec un nom null
        PokemonTrainer result = pokemonTrainerFactory.createTrainer(null, team, pokedexFactory);

        assertNull(result, "Le résultat doit être null si le nom est null");
    }

    @Test
    void shouldReturnNullWhenTeamIsNull() throws Exception {
        // Tester la création avec une équipe null
        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", null, pokedexFactory);

        assertNull(result, "Le résultat doit être null si l'équipe est null");
    }

    @Test
    void shouldReturnNullWhenPokedexFactoryIsNull() throws Exception {
        Team team = Team.MYSTIC;

        // Tester la création avec un pokedexFactory null
        PokemonTrainer result = pokemonTrainerFactory.createTrainer("Sacha", team, null);

        assertNull(result, "Le résultat doit être null si le pokedexFactory est null");
    }
}

