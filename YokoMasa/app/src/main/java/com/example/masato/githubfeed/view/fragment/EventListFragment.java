package com.example.masato.githubfeed.view.fragment;

import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.masato.githubfeed.R;
import com.example.masato.githubfeed.model.BaseModel;
import com.example.masato.githubfeed.model.event.Event;
import com.example.masato.githubfeed.navigator.Navigator;
import com.example.masato.githubfeed.presenter.EventListPresenter;
import com.example.masato.githubfeed.presenter.ImageLoadablePresenter;
import com.example.masato.githubfeed.presenter.PaginatingListPresenter;
import com.example.masato.githubfeed.util.DateUtil;
import com.example.masato.githubfeed.view.EventListView;
import com.example.masato.githubfeed.view.ImageLoadableView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Masato on 2018/02/11.
 */

public class EventListFragment extends PaginatingListFragment implements EventListView {

    @Override
    public void startEventAction(Event event) {
        Navigator.navigateFromEvent(getContext(), event);
    }

    @Override
    protected PaginatingListPresenter onCreatePresenter() {
        String url = getArguments().getString("url");
        return new EventListPresenter(this, url);
    }

    @Override
    protected PaginatingListViewHolder onCreatePaginatingViewHolder(ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(PaginatingListViewHolder holder, BaseModel element, int viewType) {
        EventViewHolder eventViewHolder = (EventViewHolder) holder;
        Event event = (Event) element;
        eventViewHolder.bindEvent(event);
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        if (holder instanceof EventViewHolder) {
            EventViewHolder viewHolder = (EventViewHolder) holder;
            viewHolder.icon.setImageBitmap(null);
        }
    }

    private class EventViewHolder extends PaginatingListViewHolder implements ImageLoadableView {

        ImageLoadablePresenter presenter;
        AppCompatTextView date;
        AppCompatTextView content;
        CircleImageView icon;
        Event event;

        void bindEvent(Event event) {
            this.event = event;
            date.setText(DateUtil.getReadableDateForFeed(event.createdAt, getContext()));
            content.setText(event.content);
            if (event.actorIcon == null) {
                presenter.onFetchImage(event.actorIconUrl);
            } else {
                icon.setImageBitmap(event.actorIcon);
            }
        }

        @Override
        public void showImage(Bitmap bitmap) {
            icon.setImageBitmap(bitmap);
            event.actorIcon = bitmap;
        }

        EventViewHolder(View itemView) {
            super(itemView);
            presenter = new ImageLoadablePresenter(this);
            date = (AppCompatTextView) itemView.findViewById(R.id.event_date);
            content = (AppCompatTextView) itemView.findViewById(R.id.event_content);
            icon = (CircleImageView) itemView.findViewById(R.id.event_image);
        }
    }

}