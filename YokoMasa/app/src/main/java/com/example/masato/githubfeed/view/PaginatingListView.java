package com.example.masato.githubfeed.view;

import com.example.masato.githubfeed.githubapi.Failure;

/**
 * Created by Masato on 2018/01/29.
 */

public interface PaginatingListView {

    public static final int ELEMENT_VIEW = 1;
    public static final int LOADING_VIEW = 2498;
    public static final int NOTHING_TO_SHOW_VIEW = 3011;

    public void stopRefreshing();

    public void updateAdapter();

    public void showErrorView(Failure failure, String errorMessage);

    public void hideErrorView();
}
