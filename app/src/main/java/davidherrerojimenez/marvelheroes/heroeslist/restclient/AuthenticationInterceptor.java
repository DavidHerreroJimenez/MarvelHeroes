package davidherrerojimenez.marvelheroes.heroeslist.restclient;


import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Project name: MarvelHeroes
 * Package name: davidherrerojimenez.marvelheroes.heroeslist.restclient
 * <p>
 * Created by dherrero on 16/07/17.
 */

public class AuthenticationInterceptor implements Interceptor {

    private String publicKey,hash,ts;

    public AuthenticationInterceptor(String publicKey, String hash, String ts) {

        this.publicKey = publicKey;
        this.hash = hash;
        this.ts = ts;
    }

    @Override public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        HttpUrl url = request.url()
                .newBuilder()
                .addQueryParameter("apikey", publicKey)
                .addQueryParameter("ts", ts)
                .addQueryParameter("hash",hash)

                .build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
