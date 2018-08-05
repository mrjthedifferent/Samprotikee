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

public class Tab2RecyclerView extends RecyclerView.Adapter {

    private ArrayList<Model> dataset;
    private Context mContext;
    public Tab2RecyclerView(ArrayList<Model> mlist, Context context) {
        this.dataset = mlist;
        this.mContext = context;
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder{


        TextView title;
        RelativeTimeTextView subtitle;
        ImageView imageView;
        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.title = (TextView)  itemView.findViewById(R.id.title);
            this.subtitle = (RelativeTimeTextView) itemView.findViewById(R.id.subtitle);
            this.imageView = (ImageView) itemView.findViewById(R.id.Icon);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.list_item2, parent, false);
        return new ImageTypeViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Model object = dataset.get(position);
        ( (ImageTypeViewHolder) holder).title.setText( object.title );
        //( (ImageTypeViewHolder) holder).subtitle.setText( object.time );

        if(object.time != null) {
            Date date = null;
            try {
                date = ISO8601Parse.parse(object.time+'Z');
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            ((ImageTypeViewHolder) holder).subtitle.setReferenceTime(date.getTime());
        }

        Glide.with(mContext)
                .load(object.subtitle)
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .centerCrop()
                        .dontAnimate()
                        .dontTransform())
                .into(( (ImageTypeViewHolder) holder).imageView);

        ( (ImageTypeViewHolder) holder).title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowPost.class);
                intent.putExtra("itemPosition", position);
                intent.putExtra("title", object.subtitle);
                intent.putExtra("get_tab", "tab2");
                mContext.startActivity(intent);
            }
        });
        ( (ImageTypeViewHolder) holder).subtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowPost.class);
                intent.putExtra("itemPosition", position);
                intent.putExtra("title", object.subtitle);
                intent.putExtra("get_tab", "tab2");
                mContext.startActivity(intent);
            }
        });
        ( (ImageTypeViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowPost.class);
                intent.putExtra("itemPosition", position);
                intent.putExtra("title", object.subtitle);
                intent.putExtra("get_tab", "tab2");
                mContext.startActivity(intent);
            }
        });

        /// dataset.get(position)
    }

    @Override
    public int getItemCount() {
        return dataset.size() ;
    }
}
