package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.displayjokeslib.DisplayJokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements FetchJokeAsyncTask.ToastListener {
    Button button;
    ProgressBar progressBar;
    private InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(getContext(),
                "ca-app-pub-3940256099942544~3347511713");

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Toast.makeText(getContext(), "Ad did not load", Toast.LENGTH_SHORT).show();
                getJoke();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                getJoke();
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        progressBar = root.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        button = root.findViewById(R.id.tellJoke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();
            }
        });
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    private void getJoke() {
        progressBar.setVisibility(View.VISIBLE);
        ((MainActivity) getActivity()).tellJoke(this);
    }

    private void showInterstitial() {
        // Show the ad if it's ready.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @Override
    public void onTaskFinished(String string) {
        Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_INTENT, string);
        this.startActivity(intent);
        progressBar.setVisibility(View.GONE);
    }

}
