package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleViewInterFace{

    private PlanetAdapter mAdapter;
    private ArrayList<Planet> mPlanetArrayList = new ArrayList<>();
    private int mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        setUpData();

        mAdapter = new PlanetAdapter(this, mPlanetArrayList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpData() {
        String [] names = getResources().getStringArray(R.array.solar_system);
        String [] types = getResources().getStringArray(R.array.type);
        String [] gravity = getResources().getStringArray(R.array.gravity);
        String [] mass = getResources().getStringArray(R.array.mass);
        String [] volume = getResources().getStringArray(R.array.volume);
        String [] meanDensity = getResources().getStringArray(R.array.meanDensity);
        String [] surfaceArea = getResources().getStringArray(R.array.surfaceArea);
        int[] images = {R.drawable.sun, R.drawable.moon, R.drawable.mercury, R.drawable.venus, R.drawable.earth,
                R.drawable.mars, R.drawable.jupiter, R.drawable.saturn, R.drawable.uranus,
                R.drawable.neptune, R.drawable.pluto, R.drawable.ceres};

        for (int i = 0; i < names.length; i++) {
            mPlanetArrayList.add(new Planet(names[i], types[i], images[i], gravity[i],
                    mass[i], volume[i], meanDensity[i], surfaceArea[i]));
        }
    }

    Context context = MainActivity.this;
    Class aClass = DetailsActivity.class;

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(context, aClass);

        intent.putExtra("NAME", mPlanetArrayList.get(position).getName());
        intent.putExtra("TYPE", mPlanetArrayList.get(position).getType());
        intent.putExtra("IMAGE", mPlanetArrayList.get(position).getImage());
        intent.putExtra("GRAVITY", mPlanetArrayList.get(position).getGravity());
        intent.putExtra("MASS", mPlanetArrayList.get(position).getMass());
        intent.putExtra("VOLUME", mPlanetArrayList.get(position).getVolume());
        intent.putExtra("DENSITY", mPlanetArrayList.get(position).getMeanDensity());
        intent.putExtra("AREA", mPlanetArrayList.get(position).getSurfaceArea());

        startActivity(intent);
    }

    @Override
    public void onItemLongClick(int position) {
        mPlanetArrayList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
}