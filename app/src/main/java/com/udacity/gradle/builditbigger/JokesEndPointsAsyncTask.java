package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;

import com.example.displayjokes.DisplayJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokesApi.JokesApi;

import java.io.IOException;

public class JokesEndPointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static JokesApi myApiService = null;
    private final View mLoadingView;
    private final View mTellJokeBtn;
    private Context mContext;

    public JokesEndPointsAsyncTask(Context context, View loadingView, View tellJokeBtn) {
        mContext = context;
        mLoadingView = loadingView;
        mTellJokeBtn = tellJokeBtn;
        JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                // options for running against local devappserver
                // - 10.0.2.2 is localhost's IP address in Android emulator
                // - turn off compression when running against local devappserver
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
        // end options for devappserver

        myApiService = builder.build();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mLoadingView.setVisibility(View.VISIBLE);
        mTellJokeBtn.setEnabled(false);
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mLoadingView.setVisibility(View.GONE);
        mTellJokeBtn.setEnabled(true);
        Intent intent = new Intent(mContext, DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.EXTRA_JOKE, result);
        mContext.startActivity(intent);
    }
}