package davidherrerojimenez.marvelheroes.herodetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import davidherrerojimenez.marvelheroes.R;
import davidherrerojimenez.marvelheroes.heroeslist.AdapterHeroesList;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Character;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.ComicSummary;

/**
 * Project name: MarvelHeroes
 * Package name: davidherrerojimenez.marvelheroes.herodetail
 * <p>
 * Created by dherrero on 17/07/17.
 *
 * TODO como se puede ver en esta clase no se ha implementado el MVP ni gran parte de las caracterristicas.
 */

public class FragmentHeroDetail extends Fragment implements View.OnClickListener{

    @BindView(R.id.fragment_hero_detail_imageview)
    ImageView ivCharacter;

    @BindView(R.id.adapter_hero_detail_textview_name)
    TextView tvNameCharacter;

    @BindView(R.id.adapter_hero_detail_textview_description)
    TextView tvDescriptionCharacter;

    @BindView(R.id.fragment_hero_detail_detail_btn)
    Button btnDetail;

    @BindView(R.id.fragment_hero_detail_wiki_btn)
    Button btnWiki;

    @BindView(R.id.fragment_hero_detail_comics_btn)
    Button btnComics;

    @BindView(R.id.fragment_hero_detail_tabhost)
    TabHost tabHost;

    @BindView(R.id.fragment_hero_detail_tabhost_tab1)
    LinearLayout llTab1;

    @BindView(R.id.fragment_hero_detail_tabhost_tab2)
    LinearLayout llTab2;

    @BindView(R.id.fragment_hero_detail_tabhost_tab1_recyclerview)
    RecyclerView rvTab1List;

    @BindView(R.id.fragment_hero_detail_tabhost_tab2_recyclerview)
    RecyclerView rvTab2List;

    @BindView(R.id.fragment_hero_detail_tabhost_tab1_textview_empty_list)
    TextView tvTab1EmtpyList;

    @BindView(R.id.fragment_hero_detail_tabhost_tab2_textview_empty_list)
    TextView tvTab2EmtpyList;


    //TODO faltan los recursos, que son las dos listas con la tabbar.

    private HeroDetailPresenterImp heroDetailPresenterImp;

    private Character character;
    private List<ComicSummary> listComicsFromCharacter;

    public FragmentHeroDetail() {

        heroesListPresenterImp = new HeroDetailPresenterImp(this);


    }

    public static FragmentHeroDetail newInstance() {

        Bundle args = new Bundle();

        FragmentHeroDetail fragment = new FragmentHeroDetail();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Bundle bundle = getArguments();
        if (bundle != null) {
            character = bundle.getParcelable(Character.TAG);
        }
        if(savedInstanceState != null) {
            character = savedInstanceState.getParcelable(Character.TAG);


            if(listComicsFromCharacter != null) {
                listComicsFromCharacter.clear();
            }else{
                listComicsFromCharacter = new ArrayList<>();
            }


            listComicsFromCharacter = character.getComics().getItems();
        }

        View view = inflater.inflate(R.layout.fragment_hero_detail,container,false);

        ButterKnife.bind(this,view);




        Picasso.with(getContext())
                .load(character.getThumbnail().getPath() +"."+ character.getThumbnail().getExtension())
                .fit()
                .into(ivCharacter);
        ;


        tvNameCharacter.setText(character.getName());


        tvDescriptionCharacter.setText(character.getDescription());


        btnDetail.setOnClickListener(this);

        btnWiki.setOnClickListener(this);

        btnComics.setOnClickListener(this);


        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");

        tab1.setContent(llTab1.getId());
        tab2.setContent(llTab2.getId());


        tab1.setIndicator(getActivity().getString(R.string.fragment_hero_detail_comics_title));
        tab2.setIndicator(getActivity().getString(R.string.fragment_hero_detail_events_title));


        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.setCurrentTab(0);


        rvTab1List.setHasFixedSize(true);
        rvTab2List.setHasFixedSize(true);

        heroDetailPresenterImp.showListOrHide(listComicsFromCharacter, rvTab1List, tvTab1EmtpyList);

        heroDetailPresenterImp.newListIfListIsNull(listComicsFromCharacter);

        adapterHeroesList = new AdapterHeroesList(getContext(), listComicsFromCharacter);

        rvTab1List.setAdapter(adapterHeroesList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rvTab1List.setLayoutManager(layoutManager);


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.fragment_hero_detail_comics_btn:

                sendActionViewIntent(character.getComics().getCollectionURI());

                break;
            case R.id.fragment_hero_detail_wiki_btn:

                /*
                 * TODO soy consciente que no es la url que se pide
                 *
                 */
                sendActionViewIntent(character.getResourceURI());

                break;

            case R.id.fragment_hero_detail_detail_btn:

                /*
                 * lo  mismo que el boton anterior
                 */
                sendActionViewIntent(character.getSeries().getCollectionURI());

                break;

        }

    }

    private void sendActionViewIntent(String url){

        //todo Soy consciente de que falta la key publica para poder visualizar el enlace
        Intent i = new Intent(Intent.ACTION_VIEW);

        i.setData(Uri.parse(url));
        startActivity(i);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        ArrayList<ComicSummary> listComicsToSave = new ArrayList<>();
        if(listComicsFromCharacter != null)
            listComicsToSave.addAll(listComicsFromCharacter);

        outState.putParcelableArrayList(ComicSummary.TAG, listComicsToSave);

        outState.putParcelable(Character.TAG, character);

        super.onSaveInstanceState(outState);
    }
}
