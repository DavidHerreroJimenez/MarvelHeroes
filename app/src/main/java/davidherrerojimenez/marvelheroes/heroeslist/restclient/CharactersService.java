package davidherrerojimenez.marvelheroes.heroeslist.restclient;

import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Project name: MarvelHeroes
 * Package name: davidherrerojimenez.marvelheroes.heroeslist.restclient
 * <p>
 * Created by dherrero on 16/07/17.
 */

public interface CharactersService {

    @Headers("Accept: */*")
    @GET("characters")
    Call<CharacterDataWrapper> getCharacterDataWrapper(@Query("nameStartsWith") String stringToFind);
}
