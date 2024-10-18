package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokedexTest {

    @Mock
    IPokedex pokedex;

    @Test
    void shouldReturnCorrectSize() {
        when(pokedex.size()).thenReturn(5);

        int result = pokedex.size();

        assertEquals(5, result, "La taille du pokédex doit être 5");
    }

    @Test
    void shouldAddPokemonAndReturnIndex() {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90,613,64,4000,4,56);
        when(pokedex.addPokemon(pokemon)).thenReturn(0);

        int index = pokedex.addPokemon(pokemon);

        assertEquals(0, index, "L'index du Pokémon ajouté doit être 0");
    }

    @Test
    void shouldGetPokemonById() throws PokedexException {
        Pokemon expectedPokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90,613,64,4000,4,56);
        when(pokedex.getPokemon(0)).thenReturn(expectedPokemon);

        Pokemon result = pokedex.getPokemon(0);

        assertEquals(expectedPokemon, result, "Le Pokémon récupéré doit être Bulbasaur");
    }

    @Test
    void shouldThrowPokedexExceptionForInvalidId() throws PokedexException {
        when(pokedex.getPokemon(-1)).thenThrow(new PokedexException("Invalid ID"));

        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-1);
        });

        assertEquals("Invalid ID", exception.getMessage(), "Doit lever une PokedexException pour un ID invalide");
    }
}
