package com.odepe.samprotikee;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.curioustechizen.ago.RelativeTimeTextView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Model> dataset;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<Model> mlist, Context context) {
        this.dataset = mlist;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return 0;
        else
            return 1;
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {


        TextView title;
        RelativeTimeTextView subtitle;
        ImageView imageView;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.Icon);
            subtitle = (RelativeTimeTextView) itemView.findViewById(R.id.subtitle);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.list_item2, parent, false);
        //return new ImageTypeViewHolder(view) ;

        final Model object = dataset.get(0);
        final String tab = object.tab;

        View view = null;
        RecyclerView.ViewHolder viewHolder = null;

        if (tab.equals("tab2")) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2, parent, false);
            viewHolder = new ImageTypeViewHolder(view);
        } else if(tab.equals("tab3")){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder = new ImageTypeViewHolder(view);
        }else if(tab.equals("tab4")){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item3, parent, false);
            viewHolder = new ImageTypeViewHolder(view);
        }else {
            if (viewType == 0) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item3, parent, false);
                viewHolder = new ImageTypeViewHolder(view);
            } else {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2, parent, false);
                viewHolder = new ImageTypeViewHolder(view);
            }
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Model object = dataset.get(position);
        final String tab = object.tab;
        ((ImageTypeViewHolder) holder).title.setText(object.title);
        //( (ImageTypeViewHolder) holder).subtitle.setText( object.time+'Z' );

        if (object.time != null) {
            Date date = null;
            try {
                date = ISO8601Parse.parse(object.time + 'Z');
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            ((ImageTypeViewHolder) holder).subtitle.setReferenceTime(date.getTime());
        }

        Glide.with(mContext)
                .load(object.subtitle)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.on_loading)
                        .centerCrop()
                        .dontAnimate()
                        .dontTransform())
                .into(((ImageTypeViewHolder) holder).imageView);

        ((ImageTypeViewHolder) holder).title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowPost.class);
                intent.putExtra("itemPosition", position);
                intent.putExtra("get_tab", tab);
                mContext.startActivity(intent);
            }
        });
        ((ImageTypeViewHolder) holder).subtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowPost.class);
                intent.putExtra("itemPosition", position);
                intent.putExtra("get_tab", tab);
                mContext.startActivity(intent);
            }
        });
        ((ImageTypeViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowPost.class);
                intent.putExtra("itemPosition", position);
                intent.putExtra("get_tab", tab);
                mContext.startActivity(intent);
            }
        });

        /// dataset.get(position)
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
