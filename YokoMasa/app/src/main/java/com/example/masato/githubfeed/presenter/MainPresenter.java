package com.example.masato.githubfeed.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.masato.githubfeed.githubapi.Failure;
import com.example.masato.githubfeed.githubapi.GitHubApi;
import com.example.masato.githubfeed.githubapi.GitHubApiResult;
import com.example.masato.githubfeed.model.Profile;
import com.example.masato.githubfeed.navigator.Navigator;
import com.example.masato.githubfeed.view.BaseView;
import com.example.masato.githubfeed.view.MainView;

/**
 * Created by Masato on 2018/01/17.
 */

public class MainPresenter extends BasePresenter {

    private static final int ENTRANCE_LOGO_DURATION = 2000;
    private final MainView view;

    public void onResume() {
        waitASec();
    }

    @Override
    public void tryAgain() {
        GitHubApi.getApi().checkIfTokenValid(this::handleTokenCheckResult);
    }

    private void waitASec() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            GitHubApi.getApi().checkIfTokenValid(this::handleTokenCheckResult);
        }, ENTRANCE_LOGO_DURATION);
    }

    private void handleTokenCheckResult(GitHubApiResult result) {
        if (result.isSuccessful) {
            view.showHomeView();
        } else {
            if (result.failure == Failure.NOT_FOUND) {
                view.showLogInView();
            } else {
                view.showTryAgainDialog();
            }
        }
    }

    public MainPresenter(MainView view) {
        this.view = view;
    }
}
