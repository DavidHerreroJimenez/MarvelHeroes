package davidherrerojimenez.marvelheroes.heroeslist;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import davidherrerojimenez.marvelheroes.base.PresenterInterface;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Character;

/**
 * Proyect: MarvelHeroes.
 * Package name: davidherrerojimenez.marvelheroes.heroeslist.
 * Created by udhj1a on 17/07/2017 12:13.
 */

public interface HeroesListViewInterface extends PresenterInterface{

    void refreshListAdapter(List<Character> newListCharacters);

    void getListOrEmptyTextIfListIsEmpty(RecyclerView rvHeroesList, TextView tvEmptyList);

}
