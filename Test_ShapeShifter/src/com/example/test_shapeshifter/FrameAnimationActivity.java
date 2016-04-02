package com.example.test_shapeshifter;

import com.androidbook.shapeshifter.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class FrameAnimationActivity extends Activity {
	
	AnimationDrawable mframeAnimation = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.framebyframe);
		
		 // Handle Start Button
		final Button onButton = (Button) findViewById(R.id.ButtonStart);
		onButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startAnimation();
			}
		});
	}

}
