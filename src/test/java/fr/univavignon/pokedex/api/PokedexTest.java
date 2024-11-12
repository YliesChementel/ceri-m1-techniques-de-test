package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    @Test
    void shouldReturnListContainingAddedPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokedex.addPokemon(pokemon);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(1, pokemons.size(), "La liste des Pokémon devrait contenir 1 Pokémon");
        assertEquals("Bulbizarre", pokemons.get(0).getName(), "Le Pokémon récupéré doit être Bulbizarre");
    }

    @Test
    void shouldThrowExceptionWhenModifyingUnmodifiableListOfPokemons() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokedex.addPokemon(pokemon);
        List<Pokemon> pokemons = pokedex.getPokemons();

        assertThrows(UnsupportedOperationException.class, () -> {
            pokemons.add(new Pokemon(1, "Salamèche", 4, 4, 2, 39, 60, 500, 1, 15));
        }, "La liste des Pokémon ne doit pas être modifiable");
    }

    @Test
    void shouldReturnListContainingAddedPokemonUsingCorrectOrder() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pokemon1 = new Pokemon(1, "Herbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pokemon2 = new Pokemon(2, "Florizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        pokedex.addPokemon(pokemon);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        Comparator<Pokemon> nameComparator = PokemonComparators.NAME;

        List<Pokemon> pokemons = new ArrayList<>(pokedex.getPokemons());
        pokemons.sort(nameComparator);

        assertEquals("Bulbizarre", pokemons.get(0).getName(), "Le premier Pokémon devrait être Bulbizarre");
        assertEquals("Florizarre", pokemons.get(1).getName(), "Le deuxième Pokémon devrait être Dracaufeu");
        assertEquals("Herbizarre", pokemons.get(2).getName(), "Le troisième Pokémon devrait être Salamèche");
    }

}
