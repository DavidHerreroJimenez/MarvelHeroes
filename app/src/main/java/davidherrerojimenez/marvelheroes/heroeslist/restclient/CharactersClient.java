package davidherrerojimenez.marvelheroes.heroeslist.restclient;

import android.app.ProgressDialog;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import davidherrerojimenez.marvelheroes.base.Constants;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Character;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.CharacterDataContainer;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.CharacterDataWrapper;
import davidherrerojimenez.marvelheroes.utils.Hash;
import davidherrerojimenez.marvelheroes.utils.Time;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Project name: MarvelHeroes
 * Package name: davidherrerojimenez.marvelheroes.heroeslist.restclient
 * <p>
 * Created by dherrero on 17/07/17.
 */

public class CharactersClient {

    private static final String TAG = "CharactersClient";

    public CharactersClient() {
    }


    /**
     * Metodo que llama a la api y recoge los datos.
     */
    public static void buildRetrofit(final OnApiCalledFinished OnApiCalledFinished, String charSequence) {

        String hash;
        String ts = Time.getTimestamp();
        String url = Constants.URL_BASE_ENDPOINT + ":" + Constants.URL_PORT + Constants.URL_BASE_METHOD + "/";
        String toHash = ts + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY;
        hash = Hash.md5(toHash);




        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(Constants.PUBLIC_KEY, hash, ts));
//        if (debug) {
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            builder.addInterceptor(interceptor);
//        }

        OkHttpClient client = builder.build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        CharactersService service = retrofit.create(CharactersService.class);


        Call<CharacterDataWrapper> characterDataWrapper= service.getCharacterDataWrapper(charSequence);

        characterDataWrapper.enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                if(response != null && response.body() != null) {
                    Log.d(TAG, response.body().toString());

                    CharacterDataContainer data = response.body().getData();

                    if (data != null) {
                        List<Character> listCharactersFromApi = data.getResults();
                        OnApiCalledFinished.onApiCalledFinishedOk(listCharactersFromApi);
                    }else{
                        List<Character> listCharactersFromApi = new ArrayList<Character>();
                        OnApiCalledFinished.onApiCalledFinishedOk(listCharactersFromApi);
                    }
                }

            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {

                if (t != null){
                    if(t.getMessage() != null )
                        Log.e(TAG, t.getMessage());
                }

                List<Character> listCharactersFromApi = new ArrayList<Character>();
                OnApiCalledFinished.onApiCalledFinishedOk(listCharactersFromApi);
            }

        });


    }
}
