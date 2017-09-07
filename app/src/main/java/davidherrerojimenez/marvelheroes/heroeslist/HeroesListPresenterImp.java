package davidherrerojimenez.marvelheroes.heroeslist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Character;
import davidherrerojimenez.marvelheroes.heroeslist.restclient.CharactersClient;
import davidherrerojimenez.marvelheroes.heroeslist.restclient.OnApiCalledFinished;

/**
 * Proyect: MarvelHeroes.
 * Package name: davidherrerojimenez.marvelheroes.heroeslist.
 * Created by udhj1a on 17/07/2017 10:57.
 */

public class HeroesListPresenterImp implements  OnApiCalledFinished{

    private OnApiCalledFinished onApiCalledFinished;
    private HeroesListViewInterface heroesListViewInterface;

    public HeroesListPresenterImp() {

        onApiCalledFinished = this;
    }

    public HeroesListPresenterImp(HeroesListViewInterface heroesListViewInterface) {

        onApiCalledFinished = this;
        this.heroesListViewInterface = heroesListViewInterface;
    }

    /**
     * Llama a CharactersClient.buildRetrofit cuando la cadena de caracteres
     * es igual o superior a 3.
     * @param charSequence cadena de caracteres que queremos buscar
     */
    public void callApiIfCharSequence(CharSequence charSequence){

        if(charSequence.toString().trim().length() >= 3){
            CharactersClient.buildRetrofit(onApiCalledFinished, charSequence.toString());
        }
    }


    /**
     * Muestra la lista de resultados si el ArrayList contiene datos. Muestra en caso contrario un mensaje de aviso de lista vacia.
     * @param listCharactersFromApi List<Character> que contiene los datos que se mostraran
     * @param rvHeroesList RecyclerView es la vista que alojara los resultados
     * @param tvEmptyList TextView que muestra el mensaje de lista vacia
     */
    public void showListOrHide(List<Character> listCharactersFromApi, RecyclerView rvHeroesList, TextView tvEmptyList){

    if (listCharactersFromApi == null || listCharactersFromApi.isEmpty()){
        rvHeroesList.setVisibility(View.GONE);
        tvEmptyList.setVisibility(View.VISIBLE);
    }else{
        rvHeroesList.setVisibility(View.VISIBLE);
        tvEmptyList.setVisibility(View.GONE);
    }

        if(heroesListViewInterface != null)
        heroesListViewInterface.getListOrEmptyTextIfListIsEmpty(rvHeroesList, tvEmptyList);
}


    /**
     * Devuelve una nueva ArrayList<Character> vacia si la que nos llega es un valor nulo
     * @param listCharactersFromApi List<Character> que aloja los datos a mostrar en recyclerview
     * @return List<Character> vacia o la que nos llega por parametro
     */
    public List<Character> newListIfListIsNull(List<Character> listCharactersFromApi){

        if(listCharactersFromApi == null)
            return new ArrayList<>();
        else return listCharactersFromApi;
    }


    /**
     * Dada una lista con datos la enviamos a la interface de la vista para refrescar el adapter
     * @param listCharactersFromApi
     */
    public void setListToAdapter(List<Character> listCharactersFromApi){

    listCharactersFromApi = newListIfListIsNull(listCharactersFromApi);

        if(heroesListViewInterface != null)
            heroesListViewInterface.refreshListAdapter(listCharactersFromApi);

    }

    @Override
    public void onApiCalledFinishedOk(List<Character> listdownloaded) {
        setListToAdapter(listdownloaded);
    }

}
