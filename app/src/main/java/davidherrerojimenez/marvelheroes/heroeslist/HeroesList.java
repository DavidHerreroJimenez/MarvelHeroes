package davidherrerojimenez.marvelheroes.heroeslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import davidherrerojimenez.marvelheroes.R;

public class HeroesList extends AppCompatActivity {

    private FragmentHeroesList fragmentHeroesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);

        setTitle(R.string.activity_heroeslist_title);

        fragmentHeroesList = FragmentHeroesList.newInstance();

        getSupportFragmentManager().beginTransaction().add(R.id.activity_heroes_list_fragment_container,fragmentHeroesList).commit();

    }





}
