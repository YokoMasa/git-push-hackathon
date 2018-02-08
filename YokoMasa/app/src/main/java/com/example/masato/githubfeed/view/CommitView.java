package com.example.masato.githubfeed.view;

import android.graphics.Bitmap;

import com.example.masato.githubfeed.model.Repository;
import com.example.masato.githubfeed.model.diff.DiffFile;

import java.util.ArrayList;

/**
 * Created by Masato on 2018/02/07.
 */

public interface CommitView {
    public void showDiffFileList(ArrayList<DiffFile> diffFiles);

    public void showRepoInfo(Repository repository);

    public void showAuthorIcon(Bitmap icon);

    public void showCommitterIcon(Bitmap icon);
}
