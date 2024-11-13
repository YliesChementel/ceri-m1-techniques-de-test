package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonMetadata metadata = null;
        try {
            metadata = metadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        Random randomAttack = new Random();
        Random randomDefense = new Random();
        Random randomStamina = new Random();


        int ivAttack = randomAttack.nextInt(16);
        int ivDefense = randomDefense.nextInt(16);
        int ivStamina = randomStamina.nextInt(16);

        double iv = (ivAttack + ivDefense + ivStamina) / 0.45;

        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, iv);
    }

}
