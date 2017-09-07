package davidherrerojimenez.marvelheroes.heroeslist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import davidherrerojimenez.marvelheroes.R;
import davidherrerojimenez.marvelheroes.herodetail.HeroDetail;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Character;
import davidherrerojimenez.marvelheroes.splashscreen.SplashScreen;

/**
 * Project name: MarvelHeroes
 * Package name: davidherrerojimenez.marvelheroes.heroeslist
 *
 * Created by dherrero on 16/07/17.
 */

public class FragmentHeroesList extends Fragment implements TextWatcher, HeroesListViewInterface{

    @BindView(R.id.fragment_heroes_list_edittext)
    EditText etFindCharacter;

    @BindView(R.id.fragment_heroes_list__linearlayout_reciclerview_list)
    RecyclerView rvHeroesList;

    @BindView(R.id.fragment_heroes_list__linearlayout_textview_empty_list)
    TextView tvEmptyList;

    private static List<Character> listCharactersFromApi;
    private static AdapterHeroesList adapterHeroesList;

    private HeroesListPresenterImp heroesListPresenterImp;
    private ProgressDialog dialog;


    public FragmentHeroesList() {

        heroesListPresenterImp = new HeroesListPresenterImp(this);
    }

    public static FragmentHeroesList newInstance() {

        return new FragmentHeroesList();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heroes_list,container,false);

        ButterKnife.bind(this,view);

        if(savedInstanceState != null){
            if(listCharactersFromApi != null) {
                listCharactersFromApi.clear();
            }else{
                listCharactersFromApi = new ArrayList<>();
            }


            listCharactersFromApi = savedInstanceState.getParcelableArrayList(Character.TAG);
        }


        etFindCharacter.addTextChangedListener(this);

        rvHeroesList.setHasFixedSize(true);

        heroesListPresenterImp.showListOrHide(listCharactersFromApi, rvHeroesList, tvEmptyList);

        heroesListPresenterImp.newListIfListIsNull(listCharactersFromApi);

        adapterHeroesList = new AdapterHeroesList(getContext(), listCharactersFromApi);

        adapterHeroesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO vamos a la nueva activity que es el detalle
//                Toast.makeText(getContext(),"Lalala: " + rvHeroesList.getChildAdapterPosition(view),Toast.LENGTH_LONG).show();

//                Log.d("tag", "Lalala: " + rvHeroesList.getChildAdapterPosition(view));

                Intent intent = new Intent(getActivity(), HeroDetail.class);

                Character character = listCharactersFromApi.get(rvHeroesList.getChildAdapterPosition(view));

//                intent.putExtra(Character.TAG, character);

                Bundle b = new Bundle();
                b.putParcelable(Character.TAG, character);

                intent.putExtra("bundle", b);

                startActivity(intent);
            }
        });


        rvHeroesList.setAdapter(adapterHeroesList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rvHeroesList.setLayoutManager(layoutManager);

        return view;
    }




    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (charSequence.toString().trim().length() >= 3){
            etFindCharacter.setText("");
            if (dialog == null)
                dialog = new ProgressDialog(getActivity());

        dialog.setTitle(getString(R.string.fragment_heroes_list_dialog_title));
        dialog.setMessage(getString(R.string.fragment_heroes_list_dialog_description));
        dialog.show();
    }

        heroesListPresenterImp.callApiIfCharSequence(charSequence);

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void getListOrEmptyTextIfListIsEmpty(RecyclerView rvHeroesList, TextView tvEmptyList) {

        this.rvHeroesList = rvHeroesList;
        this.tvEmptyList = tvEmptyList;

    }

    @Override
    public void refreshListAdapter(List<Character> listCharactersFromApi) {


        if(adapterHeroesList != null) {
            this.listCharactersFromApi = listCharactersFromApi;
            adapterHeroesList.setList(listCharactersFromApi);
            adapterHeroesList.notifyDataSetChanged();
//            heroesListPresenterImp.showListOrHide(listCharactersFromApi, rvHeroesList, tvEmptyList);


            if (listCharactersFromApi == null || listCharactersFromApi.isEmpty()){
                rvHeroesList.setVisibility(View.GONE);
                tvEmptyList.setVisibility(View.VISIBLE);
            }else{
                rvHeroesList.setVisibility(View.VISIBLE);
                tvEmptyList.setVisibility(View.GONE);
            }

//            if(heroesListViewInterface != null)
//                heroesListViewInterface.getListOrEmptyTextIfListIsEmpty(rvHeroesList, tvEmptyList);
        }

        if(dialog!= null)
            dialog.dismiss();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        ArrayList<Character> listToSave = new ArrayList<Character>();
        if(listCharactersFromApi != null)
        listToSave.addAll(listCharactersFromApi);

        outState.putParcelableArrayList(Character.TAG, listToSave);
        super.onSaveInstanceState(outState);


    }
}
