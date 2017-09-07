package davidherrerojimenez.marvelheroes.utils;

/**
 * Proyect: MarvelHeroes.
 * Package name: davidherrerojimenez.marvelheroes.utils.
 * Created by udhj1a on 19/07/2017 10:05.
 */

public class Time {


    public static String getTimestamp(){

        String ts;


        Long tsLong = System.currentTimeMillis() / 1000;
        ts = tsLong.toString();

        return ts;
    }
}
