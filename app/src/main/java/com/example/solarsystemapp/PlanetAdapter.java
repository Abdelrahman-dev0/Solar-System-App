package com.example.solarsystemapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder> {

    private final RecycleViewInterFace mRecycleViewInterFace;

    Context mcontext;
    ArrayList<Planet> mPlanetArrayList;

    public PlanetAdapter(Context context, ArrayList<Planet> planetArrayList,
                         RecycleViewInterFace recycleViewInterFace) {
        this.mcontext = context;
        this.mPlanetArrayList = planetArrayList;
        this.mRecycleViewInterFace = recycleViewInterFace;
    }

    @Override
    public PlanetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new PlanetAdapter.MyViewHolder(view, mRecycleViewInterFace);
    }

    @Override
    public void onBindViewHolder(PlanetAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(mPlanetArrayList.get(position).getName());
        holder.textView2.setText(mPlanetArrayList.get(position).getType());
        holder.imageView.setImageResource(mPlanetArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mPlanetArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView textView2;

        public MyViewHolder(View itemView, RecycleViewInterFace recycleViewInterFace) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.name);
            textView2 = itemView.findViewById(R.id.type);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycleViewInterFace != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recycleViewInterFace.onItemClick(position);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (recycleViewInterFace != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recycleViewInterFace.onItemLongClick(position);
                        }
                    }

                    return true;
                }
            });
        }
    }
}
