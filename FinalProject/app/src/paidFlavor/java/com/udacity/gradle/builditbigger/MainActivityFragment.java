package com.udacity.gradle.builditbigger;

import android.app.UiAutomation;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.displayjokeslib.DisplayJokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.FetchJokeAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements FetchJokeAsyncTask.ToastListener {
    Button button;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        button = root.findViewById(R.id.tellJoke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke();

            }
        });
        return root;
    }
    private void getJoke(){
        ((MainActivity)getActivity()).tellJoke(this);
}

    @Override
    public void onTaskFinished(String string) {
        Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_INTENT, string);
        this.startActivity(intent);
    }

}
