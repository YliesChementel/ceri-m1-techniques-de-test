package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    //Utilisation de la fonction disponible dans RocketPokemonFactory.java
    private static Map<Integer, String> index2name;
    static {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Pikachu de Sacha");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbizarre");
        aMap.put(2, "Herbizarre");
        aMap.put(3, "Florizarre");
        aMap.put(4, "Salamèche");
        aMap.put(5, "Reptincel");
        aMap.put(6, "Dracaufeu");
        aMap.put(7, "Carapuce");
        aMap.put(8, "Carabaffe");
        aMap.put(9, "Tortank");
        aMap.put(10, "Chenipan");
        aMap.put(11, "Chrysacier");
        aMap.put(12, "Papilusion");
        aMap.put(13, "Aspicot");
        aMap.put(14, "Coconfort");
        aMap.put(15, "Dardargnan");
        aMap.put(16, "Roucou");
        aMap.put(17, "Roucoolps");
        aMap.put(18, "Roucarnage");
        aMap.put(19, "Rattata");
        aMap.put(20, "Rattatac");
        aMap.put(21, "Piafabec");
        aMap.put(22, "Rapasdepic");
        aMap.put(23, "Abo");
        aMap.put(24, "Arbok");
        aMap.put(25, "Pikachu");
        aMap.put(26, "Raichu");
        aMap.put(27, "Sabelette");
        aMap.put(28, "Sablaireau");
        aMap.put(29, "Nidoran♀");
        aMap.put(30, "Nidorina");
        aMap.put(31, "Nidoqueen");
        aMap.put(32, "Nidoran♂");
        aMap.put(33, "Nidorino");
        aMap.put(34, "Nidoking");
        aMap.put(35, "Mélofée");
        aMap.put(36, "Mélodelfe");
        aMap.put(37, "Goupix");
        aMap.put(38, "Feunard");
        aMap.put(39, "Rondoudou");
        aMap.put(40, "Grodoudou");
        aMap.put(41, "Nosferapti");
        aMap.put(42, "Nosferalto");
        aMap.put(43, "Mystherbe");
        aMap.put(44, "Ortide");
        aMap.put(45, "Rafflesia");
        aMap.put(46, "Paras");
        aMap.put(47, "Parasect");
        aMap.put(48, "Mimitoss");
        aMap.put(49, "Aéromite");
        aMap.put(50, "Taupiqueur");
        aMap.put(51, "Triopikeur");
        aMap.put(52, "Miaouss");
        aMap.put(53, "Persian");
        aMap.put(54, "Psykokwak");
        aMap.put(55, "Akwakwak");
        aMap.put(56, "Férosinge");
        aMap.put(57, "Colossinge");
        aMap.put(58, "Caninos");
        aMap.put(59, "Arcanin");
        aMap.put(60, "Ptitard");
        aMap.put(61, "Têtarte");
        aMap.put(62, "Tartard");
        aMap.put(63, "Abra");
        aMap.put(64, "Kadabra");
        aMap.put(65, "Alakazam");
        aMap.put(66, "Machoc");
        aMap.put(67, "Machopeur");
        aMap.put(68, "Mackogneur");
        aMap.put(69, "Chétiflor");
        aMap.put(70, "Boustiflor");
        aMap.put(71, "Empiflor");
        aMap.put(72, "Tentacool");
        aMap.put(73, "Tentacruel");
        aMap.put(74, "Racaillou");
        aMap.put(75, "Gravalanch");
        aMap.put(76, "Grolem");
        aMap.put(77, "Ponyta");
        aMap.put(78, "Galopa");
        aMap.put(79, "Ramoloss");
        aMap.put(80, "Flagadoss");
        aMap.put(81, "Magnéti");
        aMap.put(82, "Magnéton");
        aMap.put(83, "Canarticho");
        aMap.put(84, "Doduo");
        aMap.put(85, "Dodrio");
        aMap.put(86, "Otaria");
        aMap.put(87, "Lamantine");
        aMap.put(88, "Tadmorv");
        aMap.put(89, "Grotadmorv");
        aMap.put(90, "Kokiyas");
        aMap.put(91, "Crustabri");
        aMap.put(92, "Fantominus");
        aMap.put(93, "Spectrum");
        aMap.put(94, "Ectoplasma");
        aMap.put(95, "Onix");
        aMap.put(96, "Soporifik");
        aMap.put(97, "Hypnomade");
        aMap.put(98, "Krabby");
        aMap.put(99, "Krabboss");
        aMap.put(100, "Voltorbe");
        aMap.put(101, "Electrode");
        aMap.put(102, "Noeunoeuf");
        aMap.put(103, "Noadkoko");
        aMap.put(104, "Osselait");
        aMap.put(105, "Ossatueur");
        aMap.put(106, "Kicklee");
        aMap.put(107, "Tygnon");
        aMap.put(108, "Excelangue");
        aMap.put(109, "Smogo");
        aMap.put(110, "Smogogo");
        aMap.put(111, "Rhinocorne");
        aMap.put(112, "Rhinoféros");
        aMap.put(113, "Leveinard");
        aMap.put(114, "Saquedeneu");
        aMap.put(115, "Kangourex");
        aMap.put(116, "Hypotrempe");
        aMap.put(117, "Hypocéan");
        aMap.put(118, "Poissirène");
        aMap.put(119, "Poissoroy");
        aMap.put(120, "Stari");
        aMap.put(121, "Staross");
        aMap.put(122, "M. Mime");
        aMap.put(123, "Insécateur");
        aMap.put(124, "Lippoutou");
        aMap.put(125, "Elektek");
        aMap.put(126, "Magmar");
        aMap.put(127, "Scarabrute");
        aMap.put(128, "Tauros");
        aMap.put(129, "Magicarpe");
        aMap.put(130, "Léviator");
        aMap.put(131, "Lokhlass");
        aMap.put(132, "Métamorph");
        aMap.put(133, "Evoli");
        aMap.put(134, "Aquali");
        aMap.put(135, "Voltali");
        aMap.put(136, "Pyroli");
        aMap.put(137, "Porygon");
        aMap.put(138, "Amonita");
        aMap.put(139, "Amonistar");
        aMap.put(140, "Kabuto");
        aMap.put(141, "Kabutops");
        aMap.put(142, "Ptéra");
        aMap.put(143, "Ronflex");
        aMap.put(144, "Artikodin");
        aMap.put(145, "Electhor");
        aMap.put(146, "Sulfura");
        aMap.put(147, "Minidraco");
        aMap.put(148, "Draco");
        aMap.put(149, "Dracoloss");
        aMap.put(150, "Mewtwo");
        aMap.put(151, "Mew");
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    //Utilisation de la fonction disponible dans RocketPokemonFactory.java
    private static int generateRandomStat() {
        int total = 0;
        for(int i=0; i < 1000000; i++)
        {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total = total + r;
        }
        return total / 10000;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name;
        if(!index2name.containsKey(index)) {
            name = index2name.get(0);
        } else {
            name = index2name.get(index);
        }
        int attack;
        int defense;
        int stamina;
        double iv;
        if(index < 0) {
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0;
        } else {
            attack = PokemonFactory.generateRandomStat();
            defense = PokemonFactory.generateRandomStat();
            stamina = PokemonFactory.generateRandomStat();
            iv = 1;
        }
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }


}
