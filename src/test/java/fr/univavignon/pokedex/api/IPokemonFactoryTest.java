package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokemonFactoryTest {

    @Mock
    IPokemonFactory pokemonFactory;

    @Test
    void shouldCreatePokemonInstance() {
        int index = 0;
        String name = "Bulbizarre";
        int attack = 126;
        int defense = 126;
        int stamina = 90;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        double iv = 54;

        Pokemon expectedPokemon = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedPokemon);

        Pokemon result = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(result, "Le Pokémon créé ne doit pas être null");
        assertEquals(expectedPokemon.getName(), result.getName(), "Le nom du Pokémon doit être celui attendu");
        assertEquals(expectedPokemon.getCp(), result.getCp(), "Le CP du Pokémon doit être celui attendu");
        assertEquals(expectedPokemon.getHp(), result.getHp(), "Le HP du Pokémon doit être celui attendu");
        assertEquals(expectedPokemon.getDust(), result.getDust(), "La quantité de poussière du Pokémon doit être celle attendue");
        assertEquals(expectedPokemon.getCandy(), result.getCandy(), "La quantité de bonbons du Pokémon doit être celle attendue");
        assertEquals(expectedPokemon.getIv(), result.getIv(), "Le pourcentage de perfection IV du Pokémon doit être celui attendu");
    }
}