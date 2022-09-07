package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String mName = getIntent().getStringExtra("NAME");
        String mType = getIntent().getStringExtra("TYPE");
        int mImage = getIntent().getIntExtra("IMAGE", 0);
        String mGravity = getIntent().getStringExtra("GRAVITY");
        String mMass = getIntent().getStringExtra("MASS");
        String mVolume = getIntent().getStringExtra("VOLUME");
        String mMeanDensity = getIntent().getStringExtra("DENSITY");
        String mSurfaceArea = getIntent().getStringExtra("AREA");

        TextView nameTextView = (TextView) findViewById(R.id.orb_name_value);
        TextView typeTextView = (TextView) findViewById(R.id.orb_classification_value);
        ImageView imageTextView = (ImageView) findViewById(R.id.orb_image_value);
        TextView gravityTextView = (TextView) findViewById(R.id.orb_gravity_value);
        TextView massTextView = (TextView) findViewById(R.id.orb_mass_value);
        TextView volumeTextView = (TextView) findViewById(R.id.orb_volume_value);
        TextView meanDensityTextView = (TextView) findViewById(R.id.orb_mean_density_value);
        TextView surfaceAreaTextView = (TextView) findViewById(R.id.orb_surface_area_value);

        nameTextView.setText(mName);
        typeTextView.setText(mType);
        imageTextView.setImageResource(mImage);
        gravityTextView.setText(mGravity);
        massTextView.setText(mMass);
        volumeTextView.setText(mVolume);
        meanDensityTextView.setText(mMeanDensity);
        surfaceAreaTextView.setText(mSurfaceArea);
    }
}