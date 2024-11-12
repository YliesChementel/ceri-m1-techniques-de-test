package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PokemonMetadataTest {

    @Test
    void shouldReturnIndexofBulbizarre() throws Exception {
        PokemonMetadata pokemonMetadataBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        assertEquals(pokemonMetadataBulbizarre.getIndex(), 0);
    }

    @Test
    void shouldReturnNameofBulbizarre() throws Exception {
        PokemonMetadata pokemonMetadataBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        assertEquals(pokemonMetadataBulbizarre.getName(), "Bulbizarre");
    }

    @Test
    void shouldReturnAttackofBulbizarre() throws Exception {
        PokemonMetadata pokemonMetadataBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        assertEquals(pokemonMetadataBulbizarre.getAttack(), 126);
    }

    @Test
    void shouldReturnDefenseofBulbizarre() throws Exception {
        PokemonMetadata pokemonMetadataBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        assertEquals(pokemonMetadataBulbizarre.getDefense(), 126);
    }

    @Test
    void shouldReturnStaminaofBulbizarre() throws Exception {
        PokemonMetadata pokemonMetadataBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        assertEquals(pokemonMetadataBulbizarre.getStamina(), 90);
    }

}
