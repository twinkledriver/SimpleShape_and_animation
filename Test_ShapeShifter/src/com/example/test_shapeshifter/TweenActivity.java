package com.example.test_shapeshifter;


import com.androidbook.shapeshifter.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class TweenActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tween);
		
		
				final Button fadeButton = (Button) findViewById(R.id.ButtonAlpha);
				fadeButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						performAnimation(R.anim.transparency);
					}
				});
				
				final Button growButton = (Button) findViewById(R.id.ButtonScale);
				growButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						performAnimation(R.anim.grow);
					}
				});
				
				
				
	}
	
}
	


