package com.example.masato.githubfeed.view.fragment;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.masato.githubfeed.R;
import com.example.masato.githubfeed.model.BaseModel;
import com.example.masato.githubfeed.model.Commit;
import com.example.masato.githubfeed.model.Repository;
import com.example.masato.githubfeed.navigator.Navigator;
import com.example.masato.githubfeed.presenter.CommitListPresenter;
import com.example.masato.githubfeed.presenter.PaginatingListPresenter;
import com.example.masato.githubfeed.util.DateUtil;
import com.example.masato.githubfeed.view.CommitListView;

/**
 * Created by Masato on 2018/02/06.
 */

public class CommitListFragment extends PaginatingListFragment implements CommitListView {

    @Override
    public void showCommit(Commit commit) {
        Navigator.navigateToCommitView(getContext(), commit);
    }

    @Override
    protected PaginatingListPresenter onCreatePresenter() {
        String url = getArguments().getString("url");
        Repository repository = getArguments().getParcelable("repository");
        if (repository != null) {
            return new CommitListPresenter(this, repository);
        } else {
            return new CommitListPresenter(this, url);
        }
    }

    @Override
    protected PaginatingListViewHolder onCreatePaginatingViewHolder(ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.commit_list_element, parent, false);
        return new CommitViewHolder(view);
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {

    }

    @Override
    protected void onBindViewHolder(PaginatingListViewHolder holder, BaseModel element, int viewType) {
        CommitViewHolder commitViewHolder = (CommitViewHolder) holder;
        Commit commit = (Commit) element;
        commitViewHolder.bindCommit(commit);
    }

    private class CommitViewHolder extends PaginatingListViewHolder {

        AppCompatTextView date;
        AppCompatTextView comment;
        AppCompatTextView sha;

        void bindCommit(Commit commit) {
            comment.setText(commit.getShortenedComment());
            sha.setText(commit.getShortenedSha());
            if (commit.committerDate != null) {
                date.setText(DateUtil.getReadableDateForFeed(commit.committerDate, getContext()));
            } else if (commit.authorDate != null) {
                date.setText(DateUtil.getReadableDateForFeed(commit.authorDate, getContext()));
            }
        }

        public CommitViewHolder(View itemView) {
            super(itemView);
            date = (AppCompatTextView) itemView.findViewById(R.id.commit_list_element_date);
            comment = (AppCompatTextView) itemView.findViewById(R.id.commit_list_element_comment);
            sha = (AppCompatTextView) itemView.findViewById(R.id.commit_list_element_sha);
        }
    }
}
