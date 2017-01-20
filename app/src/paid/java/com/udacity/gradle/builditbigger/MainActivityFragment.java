package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.gradle.builditbigger.JokesEndPointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private View mLoadingView;
    private View mTellJokeBtn;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mLoadingView = view.findViewById(R.id.loading_indicator);
        mTellJokeBtn = view.findViewById(R.id.tell_joke_btn);
        return view;
    }

    public void fetchJoke() {
        new JokesEndPointsAsyncTask(getActivity(), mLoadingView, mTellJokeBtn).execute();
    }
}
