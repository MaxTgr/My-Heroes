package br.com.doghero.dhproject.fragments.hero;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

import br.com.doghero.dhproject.MyHeroes;
import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.api.ApiAnswer;
import br.com.doghero.dhproject.model.Hero;

public class HeroFragment extends Fragment {

    private RecyclerView mRecentRecyclerView;
    private RecyclerView.Adapter mRecentAdapter;
    private RecyclerView mFavoriteRecyclerView;
    private RecyclerView.Adapter mFavoriteAdapter;

    public HeroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View heroLayout = inflater.inflate(R.layout.fragment_hero, container, false);

        mRecentRecyclerView = heroLayout.findViewById(R.id.recent_list);
        mFavoriteRecyclerView = heroLayout.findViewById(R.id.favorite_list);

        // setting both layout managers to this activity
        mRecentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFavoriteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // getting the api response and sending to the adapters
        String apiResponse = ApiAnswer.getMyHeroes();
        HashMap<String, List<Hero>> heroes = MyHeroes.build(apiResponse);

        mRecentAdapter = new HeroAdapter(heroes.get("recents"));
        mFavoriteAdapter = new HeroAdapter(heroes.get("favorites"));
        mRecentRecyclerView.setAdapter(mRecentAdapter);
        mFavoriteRecyclerView.setAdapter(mFavoriteAdapter);

        // Inflate the layout for this fragment
        return heroLayout;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
