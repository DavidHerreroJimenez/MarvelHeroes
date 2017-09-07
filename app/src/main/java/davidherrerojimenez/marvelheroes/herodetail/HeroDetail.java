package davidherrerojimenez.marvelheroes.herodetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import davidherrerojimenez.marvelheroes.R;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Character;

public class HeroDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);


        Bundle b = getIntent().getBundleExtra("bundle");
//        Character character = b.getParcelable(Character.TAG);

        FragmentHeroDetail fragmentHeroDetail = FragmentHeroDetail.newInstance();

        fragmentHeroDetail.setArguments(b);

        getSupportFragmentManager().beginTransaction().add(R.id.activity_hero_detail_fragment_container, fragmentHeroDetail).commit();
    }
}
