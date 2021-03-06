package com.example.masato.githubfeed.view.fragment;

import android.os.Bundle;

import com.example.masato.githubfeed.githubapi.Failure;
import com.example.masato.githubfeed.model.Commit;
import com.example.masato.githubfeed.model.Issue;
import com.example.masato.githubfeed.model.PullRequest;
import com.example.masato.githubfeed.model.Repository;
import com.example.masato.githubfeed.model.diff.DiffFile;

import java.util.ArrayList;

/**
 * Created by Masato on 2018/02/07.
 */

public class FragmentFactory {

    public static CommentListFragment createCommentListFragment(String url, String name) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("name", name);
        CommentListFragment commentListFragment = new CommentListFragment();
        commentListFragment.setArguments(bundle);
        return commentListFragment;
    }

    public static CommitListFragment createCommitListFragment(String url, String name) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("name", name);
        CommitListFragment commitListFragment = new CommitListFragment();
        commitListFragment.setArguments(bundle);
        return commitListFragment;
    }

    public static CommitListFragment createCommitListFragment(Repository repository, String name) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("repository", repository);
        bundle.putString("name", name);
        CommitListFragment commitListFragment = new CommitListFragment();
        commitListFragment.setArguments(bundle);
        return commitListFragment;
    }

    public static DiffFileListFragment createDiffFileListFragment(String url, String name) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("name", name);
        DiffFileListFragment diffFileListFragment = new DiffFileListFragment();
        diffFileListFragment.setArguments(bundle);
        return diffFileListFragment;
    }

    public static DiffFileListFragment createDiffFileListFragment(ArrayList<DiffFile> diffFiles, String name) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("diff_files", diffFiles);
        bundle.putString("name", name);
        DiffFileListFragment diffFileListFragment = new DiffFileListFragment();
        diffFileListFragment.setArguments(bundle);
        return diffFileListFragment;
    }

    public static FeedListFragment createFeedListFragment(String url, String name) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("name", name);
        FeedListFragment feedListFragment = new FeedListFragment();
        feedListFragment.setArguments(bundle);
        return feedListFragment;
    }

    public static IssueListFragment createIssueListFragment(Repository repository, String name) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("repository", repository);
        bundle.putString("name", name);
        IssueListFragment issueListFragment = new IssueListFragment();
        issueListFragment.setArguments(bundle);
        return issueListFragment;
    }

    public static IssueListFragment createIssueListFragment(String url, String name) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("name", name);
        IssueListFragment issueListFragment = new IssueListFragment();
        issueListFragment.setArguments(bundle);
        return issueListFragment;
    }

    public static IssueOverviewFragment createIssueOverviewFragment(Issue issue, String name) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("issue", issue);
        bundle.putString("name", name);
        IssueOverviewFragment issueOverviewFragment = new IssueOverviewFragment();
        issueOverviewFragment.setArguments(bundle);
        return issueOverviewFragment;
    }

    public static RepoOverviewFragment createRepoOverviewFragment(Repository repository, String name) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("repository", repository);
        bundle.putString("name", name);
        RepoOverviewFragment repoOverviewFragment = new RepoOverviewFragment();
        repoOverviewFragment.setArguments(bundle);
        return repoOverviewFragment;
    }

    public static PullRequestListFragment createPullRequestListFragment(Repository repository, String name) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("repository", repository);
        bundle.putString("name", name);
        PullRequestListFragment pullRequestListFragment = new PullRequestListFragment();
        pullRequestListFragment.setArguments(bundle);
        return pullRequestListFragment;
    }

    public static PullRequestOverviewFragment createPullRequestOverviewFragment(PullRequest pr, String name) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("pull_request", pr);
        bundle.putString("name", name);
        PullRequestOverviewFragment pullRequestOverviewFragment = new PullRequestOverviewFragment();
        pullRequestOverviewFragment.setArguments(bundle);
        return pullRequestOverviewFragment;
    }

    public static EventListFragment createEventListFragment(String url, String name) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("name", name);
        EventListFragment eventListFragment = new EventListFragment();
        eventListFragment.setArguments(bundle);
        return eventListFragment;
    }

    public static CommitOverviewFragment createCommitOverviewFragment(Commit commit, String name) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("commit", commit);
        bundle.putString("name", name);
        CommitOverviewFragment commitOverviewFragment = new CommitOverviewFragment();
        commitOverviewFragment.setArguments(bundle);
        return commitOverviewFragment;
    }

    public static ErrorFragment createErrorFragment(Failure failure, String message) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("failure", failure);
        bundle.putString("message", message);
        ErrorFragment errorFragment = new ErrorFragment();
        errorFragment.setArguments(bundle);
        return errorFragment;
    }

    private FragmentFactory(){}
}
