package fr.univavignon.pokedex.api;

import java.util.Random;

/**
 * Factory class responsible for creating Pokémon instances.
 * It uses the Pokémon metadata to generate a Pokémon with specific attributes
 * such as CP, HP, and individual values (IVs).
 */
public class PokemonFactory implements IPokemonFactory {

    /**
     * Creates a new Pokémon instance based on the provided attributes.
     * The method uses Pokémon metadata to initialize the Pokémon's base stats and
     * generates random individual values (IVs) for attack, defense, and stamina.
     *
     * @param index The Pokémon's index, used to fetch its metadata.
     * @param cp The Combat Power of the Pokémon.
     * @param hp The Health Points of the Pokémon.
     * @param dust The amount of Stardust the Pokémon has.
     * @param candy The amount of candy the Pokémon has.
     * @return A newly created Pokémon instance with the provided and generated attributes.
     */
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
