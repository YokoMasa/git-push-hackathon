package com.example.masato.githubfeed.presenter;

import android.util.Log;

import com.example.masato.githubfeed.R;
import com.example.masato.githubfeed.githubapi.Failure;
import com.example.masato.githubfeed.githubapi.GitHubApi;
import com.example.masato.githubfeed.githubapi.GitHubApiCallback;
import com.example.masato.githubfeed.githubapi.GitHubApiResult;
import com.example.masato.githubfeed.model.Repository;
import com.example.masato.githubfeed.view.RepoView;

/**
 * Created by Masato on 2018/01/27.
 */

public class RepoPresenter extends BasePresenter {

    private RepoView view;
    private String repoUrl;

    @Override
    public void tryAgain() {
        view.showLoadingView();
        view.hideErrorView();
        GitHubApi.getApi().fetchRepository(repoUrl, this::handleFetchRepositoryResult);
    }

    private void handleFetchRepositoryResult(GitHubApiResult result) {
        view.hideLoadingView();
        if (result.isSuccessful) {
            Repository repository = (Repository) result.resultObject;
            view.setUpContent(repository);
        } else {
            view.showErrorView(result.failure, result.errorMessage);
        }
    }

    public RepoPresenter(RepoView view, String url) {
        this.view = view;
        this.repoUrl = url;
        view.showLoadingView();
        GitHubApi.getApi().fetchRepository(repoUrl, this::handleFetchRepositoryResult);
    }
}
