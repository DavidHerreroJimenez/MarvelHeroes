package davidherrerojimenez.marvelheroes.heroeslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import davidherrerojimenez.marvelheroes.R;
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Character;

/**
 * Project name: MarvelHeroes
 * Package name: davidherrerojimenez.marvelheroes.heroeslist
 *
 * Created by dherrero on 17/07/17.
 */

public class AdapterHeroesList extends RecyclerView.Adapter<AdapterHeroesList.ViewHolderAdapterHeroesList> implements View.OnClickListener {

    private Context context;
    private List<Character> charactersList;
    private HeroesListPresenterImp heroesListPresenterImp;
    private View.OnClickListener listener;


    public AdapterHeroesList(Context context, List<Character> charactersList) {

        this.context = context;
        this.charactersList = charactersList;
        heroesListPresenterImp = new HeroesListPresenterImp();
    }

    @Override
    public ViewHolderAdapterHeroesList onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_heroes_list, parent, false);

        view.setOnClickListener(this);

        return new ViewHolderAdapterHeroesList(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderAdapterHeroesList holder, int position) {

        holder.tvName.setText(charactersList.get(position).getName().trim());
        holder.tvDescription.setText(charactersList.get(position).getDescription().trim());

        Picasso.with(context)
                .load(charactersList.get(position).getThumbnail().getPath() +"."+ charactersList.get(position).getThumbnail().getExtension())
                .fit()
                .into(holder.thumbnailImage);

    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }

    public void setList(List<Character> newCharactersList){

        charactersList = heroesListPresenterImp.newListIfListIsNull(charactersList);
        newCharactersList = heroesListPresenterImp.newListIfListIsNull(newCharactersList);

        charactersList.clear();
        charactersList.addAll(newCharactersList);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null) {
            listener.onClick(view);

        }
    }



    /**
     * Project name: MarvelHeroes
     * Package name: davidherrerojimenez.marvelheroes.heroeslist
     * <p>
     * Created by dherrero on 17/07/17.
     */

    public class ViewHolderAdapterHeroesList extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_heroes_list_imageview)
        ImageView thumbnailImage;
        @BindView(R.id.adapter_heroes_list_textview_name)
        TextView tvName;
        @BindView(R.id.adapter_heroes_list_textview_description)
        TextView tvDescription;

        public ViewHolderAdapterHeroesList(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }


    }
}
