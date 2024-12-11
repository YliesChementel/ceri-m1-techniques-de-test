package fr.univavignon.pokedex.api;

/**
* Factory class responsible for creating Pokémon Trainer instances.
* It initializes a new trainer with a given name, team, and Pokédex,
* using the provided Pokémon metadata provider and Pokémon factory.
*/
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
    * The provider used to fetch Pokémon metadata, such as their stats, abilities, etc.
    */
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    /**
    * The factory used to create Pokémon instances with specific attributes.
    */
    private final IPokemonFactory pokemonFactory;

    /**
    * Constructor for the PokemonTrainerFactory.
    * Initializes the factory with the Pokémon metadata provider and Pokémon factory.
    *
    * @param metadataProvider The provider used to fetch Pokémon metadata.
    * @param pokemonFactory The factory used to create Pokémon instances.
    */
    public PokemonTrainerFactory(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
    * Creates and returns a new Pokémon Trainer instance with the provided name, team, and Pokédex.
    *
    * @param name The name of the Pokémon Trainer.
    * @param team The team that the Pokémon Trainer belongs to.
    * @param pokedexFactory The factory used to create the trainer's Pokédex.
    * @return A new Pokémon Trainer instance, or null if any of the inputs are invalid.
    */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        if((name == null || name.isEmpty()) || team == null || pokedexFactory == null){
            return null;
        }
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}

