package davidherrerojimenez.marvelheroes.heroeslist.restclient;

import java.util.List;

import davidherrerojimenez.marvelheroes.base.api.ApiInterface;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Character;

/**
 * Project name: MarvelHeroes
 * Package name: davidherrerojimenez.marvelheroes.heroeslist.restclient
 * <p>
 * Created by dherrero on 17/07/17.
 */

public interface OnApiCalledFinished extends ApiInterface{

    public void onApiCalledFinishedOk(List<Character> listdownloaded);
}
