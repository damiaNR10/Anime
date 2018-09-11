package com.example.damia.anime.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.damia.anime.model.Anime;
import com.example.damia.anime.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context mContext;
    private List<Anime> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_category.setText(mData.get(position).getCategory());
        holder.tv_studio.setText(mData.get(position).getStudio());
        holder.tv_rating.setText(mData.get(position).getRating());


        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView tv_name, tv_rating, tv_studio, tv_category;
    ImageView img_thumbnail;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv_name = itemView.findViewById(R.id.anime_name);
        tv_rating = itemView.findViewById(R.id.rating);
        tv_studio = itemView.findViewById(R.id.studio);
        tv_category = itemView.findViewById(R.id.category);
        img_thumbnail = itemView.findViewById(R.id.thumbnail);
    }
}

