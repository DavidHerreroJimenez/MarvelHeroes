package davidherrerojimenez.marvelheroes.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import davidherrerojimenez.marvelheroes.R;
import davidherrerojimenez.marvelheroes.heroeslist.HeroesList;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, HeroesList.class);
                startActivity(intent);
            }
        },2000);


    }
}
