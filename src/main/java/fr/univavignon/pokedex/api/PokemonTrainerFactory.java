package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    private final IPokemonMetadataProvider pokemonMetadataProvider;
    private final IPokemonFactory pokemonFactory;

    public PokemonTrainerFactory(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        if((name == null || name.isEmpty()) || team ==null || pokedexFactory == null){
            return null;
        }
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}
